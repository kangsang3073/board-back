package com.board.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.board.boardback.entity.CommentEntity;
import com.board.boardback.repository.resultSet.GetCommentListResultSet;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

    @Query(
        value = 
        "select " +
            "u.nickname as nickname, " +
            "u.profile_image as profileImage, " +
            "c.write_datetime as writeDatetime, " +
            "c.content as content " +
        "from comment as c " +
        "inner join user as u " +
        "on c.user_email = u.email " +
        "where c.board_number = ?1 " +
        "ORDER BY writeDatetime desc", 
        nativeQuery = true
    )
    List<GetCommentListResultSet> getCommentList(Integer boardNumber);
    
}
