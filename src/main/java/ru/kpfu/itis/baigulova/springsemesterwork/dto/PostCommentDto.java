package ru.kpfu.itis.baigulova.springsemesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;
import ru.kpfu.itis.baigulova.springsemesterwork.model.PostComment;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCommentDto {

    private Long id;
    private String text;
    private Account account;
    private Long postId;


    public static PostCommentDto fromModel(PostComment comment) {
        return new PostCommentDto(comment.getId(), comment.getText(), comment.getAccount(),
                comment.getPost().getId());
    }
}
