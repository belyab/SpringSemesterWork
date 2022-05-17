package ru.kpfu.itis.baigulova.springsemesterwork.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.PostCommentDto;
import ru.kpfu.itis.baigulova.springsemesterwork.model.PostComment;
import ru.kpfu.itis.baigulova.springsemesterwork.repositories.PostCommentRepository;
import ru.kpfu.itis.baigulova.springsemesterwork.service.PostCommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PostCommentServiceImpl implements PostCommentService {

    private final PostCommentRepository postCommentRepository;

    @Autowired
    public PostCommentServiceImpl(PostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }

    @Override
    public PostCommentDto save(PostComment comment) {
        return PostCommentDto.fromModel(postCommentRepository.save(comment));
    }

    @Override
    public List<PostCommentDto> getAllByPostId(Long postId) {
        List<PostComment> allComments = postCommentRepository.getAllByPostId(postId);

        return allComments.stream()
                .map(PostCommentDto::fromModel)
                .collect(Collectors.toList());
    }
}
