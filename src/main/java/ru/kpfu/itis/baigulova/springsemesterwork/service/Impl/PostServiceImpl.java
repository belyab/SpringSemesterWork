package ru.kpfu.itis.baigulova.springsemesterwork.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.PostDto;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Post;
import ru.kpfu.itis.baigulova.springsemesterwork.repositories.PostRepository;
import ru.kpfu.itis.baigulova.springsemesterwork.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto save(Post post) {
        return PostDto.fromModel(postRepository.save(post));
    }

    @Override
    public PostDto getPostById(Long postId) {
        return PostDto.fromModel(postRepository.findById(postId).get());
    }

    @Override
    public Post getRawPostById(Long postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public List<PostDto> getAll() {
        List<Post> allPosts = postRepository.findAll();

        return allPosts.stream()
                .map(PostDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByTitleLike(String title) {
        List<Post> allPosts;

        if (title.isEmpty() || title == null) {
            allPosts = postRepository.findAll();
        } else {
            allPosts = postRepository.getAllByTitleContains(title);
        }

        return allPosts.stream()
                .map(PostDto::fromModel)
                .collect(Collectors.toList());
    }



    @Override
    public List<PostDto> getPostsByTitleLikeAndAccountId(String title, Long id) {
        List<Post> allPosts;

        if (title.isEmpty() || title == null) {
            allPosts = postRepository.findAll();
        } else {
            allPosts = postRepository.getAllByTitleContainsAndAccountId(title, id);
        }

        return allPosts.stream()
                .map(PostDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getAllByAccountId(Long userId) {
        List<Post> allPosts = postRepository.getAllByAccountId(userId);

        return allPosts.stream()
                .map(PostDto::fromModel)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deletePostById(Long id) {
        postRepository.deletePostById(id);
    }
}
