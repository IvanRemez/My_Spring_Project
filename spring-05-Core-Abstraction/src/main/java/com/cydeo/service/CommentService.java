package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
//          ^^ going through Interface creates LOOSELY COUPLED structure
//          which allows for easy future upgrades/extensions

//    @Autowired    with only 1 Constructor, injection happens automatically
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL")
    CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        // save in the DB
        commentRepository.storeComment(comment);
        // send email
        commentNotificationProxy.sendComment(comment);
    }
}
