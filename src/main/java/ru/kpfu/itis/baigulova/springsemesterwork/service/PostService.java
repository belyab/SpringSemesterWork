package ru.kpfu.itis.baigulova.springsemesterwork.service;

import ru.kpfu.itis.baigulova.springsemesterwork.dto.PostDto;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Post;

import java.util.List;

public interface PostService {

    PostDto save(Post post);

    PostDto getPostById(Long postId);

    Post getRawPostById(Long postId);

    List<PostDto> getAll();

    List<PostDto> getPostsByTitleLike(String title);

    List<PostDto> getPostsByTitleLikeAndAccountId(String title, Long id);

    List<PostDto> getAllByAccountId(Long userId);

    void deletePostById(Long id);

}
