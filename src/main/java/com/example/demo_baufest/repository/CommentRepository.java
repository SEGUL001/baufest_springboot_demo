package com.example.demo_baufest.repository;

import com.example.demo_baufest.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
