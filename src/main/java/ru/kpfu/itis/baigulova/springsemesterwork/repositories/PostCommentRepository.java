package ru.kpfu.itis.baigulova.springsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.baigulova.springsemesterwork.model.PostComment;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Integer> {

    @Query(value = "select u from PostComment u where u.post.id = :postId")
    List<PostComment> getAllByPostId(@Param("postId") Long postId);
}
