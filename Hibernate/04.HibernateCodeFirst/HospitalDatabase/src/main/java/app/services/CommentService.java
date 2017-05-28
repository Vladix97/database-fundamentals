package app.services;


import app.entities.Comment;

public interface CommentService {

    void persist(Comment comment);
}
