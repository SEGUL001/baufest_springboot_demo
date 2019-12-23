package com.example.demo_baufest.repository;

import com.example.demo_baufest.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
