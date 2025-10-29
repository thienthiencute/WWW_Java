package fit.iuh.thanhoangthienthien_tuan07.reposities;

import fit.iuh.thanhoangthienthien_tuan07.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByProduct_Id(Integer productId);
}