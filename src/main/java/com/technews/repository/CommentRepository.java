package com.technews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.technews.model.Comment;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository <Comment,Integer >{
    List<Comment> findAllCommentsByPostID(int postId);
}
