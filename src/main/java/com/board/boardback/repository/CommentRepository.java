package com.board.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.boardback.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
    
}
