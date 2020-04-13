package serol.jooqtry.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import serol.jooqtry.database.BlogRepository;
import serol.jooqtry.rest.model.BlogCreateRequest;
import serol.jooqtry.rest.model.BlogUpdateRequest;
import serol.jooqtry.rest.model.BlogView;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogRepository blogRepository;

    @GetMapping("/blogs")
    public List<BlogView> getBlogs() {
        return blogRepository.getBlogs().stream()
                .map(blog -> new BlogView(
                        blog.getId(),
                        blog.getAuthor(),
                        blog.getDatePublished().toLocalDateTime(),
                        blog.getDateEdited().toLocalDateTime(),
                        blog.getText()
                ))
                .collect(toList());
    }

    @GetMapping("/blogs/{blogId}")
    public BlogView getBlog(@PathVariable int blogId) {
        return blogRepository.getBlog(blogId)
                .map(blog -> new BlogView(
                        blog.getId(),
                        blog.getAuthor(),
                        blog.getDatePublished().toLocalDateTime(),
                        blog.getDateEdited().toLocalDateTime(),
                        blog.getText()
                ))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("No blog found with id=%s", blogId)
                ));
    }

    @PostMapping("/blogs")
    public long createBlog(@RequestBody BlogCreateRequest request) {
        return blogRepository.createBlog(
                request.getAuthor(),
                request.getText()
        );
    }

    @PutMapping("/blogs/{blogId}")
    public void updateBlog(@PathVariable int blogId,
                           @RequestBody BlogUpdateRequest request) {
        blogRepository.updateBlog(blogId, request.getText());
    }

    @DeleteMapping("/blogs/{blogId}")
    public void deleteBlog(@PathVariable int blogId) {
        blogRepository.deleteBlog(blogId);
    }
}
