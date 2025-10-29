package fit.iuh.thanhoangthienthien_tuan07.services;

import fit.iuh.thanhoangthienthien_tuan07.entities.Comment;
import fit.iuh.thanhoangthienthien_tuan07.reposities.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByProductId(Integer productId) {
        return commentRepository.findByProduct_Id(productId);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
