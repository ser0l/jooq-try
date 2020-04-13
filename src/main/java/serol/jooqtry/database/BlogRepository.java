package serol.jooqtry.database;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Component;
import serol.jooqtry.database.jooq.tables.pojos.Blogs;

import java.util.List;
import java.util.Optional;

import static serol.jooqtry.database.jooq.Tables.BLOGS;

@Component
@RequiredArgsConstructor
public class BlogRepository {
    private final DSLContext create;

    public List<Blogs> getBlogs() {
        return create.selectFrom(BLOGS)
                .fetchInto(Blogs.class);
    }

    public Optional<Blogs> getBlog(int blogId) {
        return Optional.ofNullable(
                create.selectFrom(BLOGS)
                        .where(BLOGS.ID.eq(blogId))
                        .fetchOneInto(Blogs.class));
    }

    public int createBlog(String author, String text) {
        return create.insertInto(BLOGS)
                .set(BLOGS.AUTHOR, author)
                .set(BLOGS.TEXT, text)
                .set(BLOGS.DATE_PUBLISHED, DSL.currentTimestamp())
                .set(BLOGS.DATE_EDITED, DSL.currentTimestamp())
                .returningResult(BLOGS.ID)
                .fetchOne()
                .into(Integer.class);
    }

    public void updateBlog(int blogId, String text) {
        create.update(BLOGS)
                .set(BLOGS.TEXT, text)
                .set(BLOGS.DATE_EDITED, DSL.currentTimestamp())
                .where(BLOGS.ID.eq(blogId))
                .execute();
    }

    public void deleteBlog(int blogId) {
        create.delete(BLOGS)
                .where(BLOGS.ID.eq(blogId))
                .execute();
    }
}
