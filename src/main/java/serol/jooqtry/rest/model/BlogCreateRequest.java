package serol.jooqtry.rest.model;

import lombok.Data;

@Data
public class BlogCreateRequest {
    private String author;
    private String text;
}
