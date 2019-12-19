package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pojo.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query
    Double avgRating();
    @Query
    Double getRating();
}
