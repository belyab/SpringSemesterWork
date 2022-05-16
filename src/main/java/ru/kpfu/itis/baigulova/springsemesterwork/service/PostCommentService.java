package ru.kpfu.itis.baigulova.springsemesterwork.service;

import ru.kpfu.itis.baigulova.springsemesterwork.dto.PostCommentDto;
import ru.kpfu.itis.baigulova.springsemesterwork.model.PostComment;

import java.util.List;

public interface PostCommentService {

    PostCommentDto save(PostComment comment);

    List<PostCommentDto> getAllByPostId(Long postId);
}
