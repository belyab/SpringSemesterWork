package ru.kpfu.itis.baigulova.springsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> getAllByTitleContains(@Param("title") String title);

    List<Post> getAllByTitleContainsAndAccountId(String title, Long id);

    @Query(value = "select u from Post u where u.account.id = :userId")
    List<Post> getAllByAccountId(@Param("userId") Long userId);

    void deletePostById(Long id);
}
