package app.serviceImpls;

import app.daos.CommentDao;
import app.entities.Comment;
import app.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void persist(Comment comment) {
        this.commentDao.saveAndFlush(comment);
    }
}
