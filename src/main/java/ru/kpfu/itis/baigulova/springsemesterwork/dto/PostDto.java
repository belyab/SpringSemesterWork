package ru.kpfu.itis.baigulova.springsemesterwork.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Post;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    private Long id;
    private String title;
    private String text;
    private String data;
    private Long accountId;
    private String accountEmail;


    public static PostDto fromModel(Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getText(),
                post.getData(), post.getAccount().getId(), post.getAccount().getEmail());
    }
}
