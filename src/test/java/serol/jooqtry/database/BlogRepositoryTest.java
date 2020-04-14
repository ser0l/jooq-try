package serol.jooqtry.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import serol.jooqtry.database.jooq.tables.pojos.Blogs;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest(properties = {
        // run liquibase migration before tests
        "spring.liquibase.change-log=classpath:/liquibase/changelog.xml",
        // log generated SQL
        "logging.level.org.jooq=debug"
})
class BlogRepositoryTest {
    @Autowired
    BlogRepository blogRepository;

    @Container
    static PostgreSQLContainer postgres = new PostgreSQLContainer<>("postgres:12.2");

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    void testBlogRepository() {
        assertTrue(blogRepository.getBlogs().isEmpty(), "expected container database to be empty");

        // create and read
        String author = "author";
        String text = "text";
        int blogId = blogRepository.createBlog(author, text);

        Optional<Blogs> blog = blogRepository.getBlog(blogId);
        assertTrue(blog.isPresent(), "expected blog to be created");

        List<Blogs> blogs = blogRepository.getBlogs();
        assertEquals(1, blogs.size(), "expected blog to be created");

        assertEquals(author, blog.get().getAuthor());
        assertEquals(text, blog.get().getText());
        assertNotNull(blog.get().getDatePublished());
        assertNotNull(blog.get().getDateEdited());
        assertEquals(blog.get(), blogs.get(0));

        // update and read
        String newText = "text2";
        blogRepository.updateBlog(blogId, newText);

        Blogs updated = blogRepository.getBlog(blogId).get();
        assertEquals(newText, updated.getText());
        assertTrue(updated.getDateEdited().after(updated.getDatePublished()), "dateEdited should be updated");

        // delete and read
        blogRepository.deleteBlog(blogId);
        assertTrue(blogRepository.getBlog(blogId).isEmpty());
        assertTrue(blogRepository.getBlogs().isEmpty());
    }
}