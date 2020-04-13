package serol.jooqtry.rest.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class BlogView {
    private long id;
    private String author;
    private LocalDateTime datePublished;
    private LocalDateTime dateEdited;
    private String text;
}
