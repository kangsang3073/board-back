package com.board.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.board.boardback.entity.BoardEntity;
import com.board.boardback.repository.resultSet.GetBoardResultSet;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{

    boolean existsByBoardNumber(Integer boardNumber);

    BoardEntity findByBoardNumber(Integer boardNumber);
    
    @Query(
        value=
        "SELECT " +
        "b.board_number as boardNumber, " +
        "b.title as title, " +
        "b.content as content, " +
        "b.write_datetime as writeDatetime, " +
        "b.writer_email as writerEmail, " +
        "u.nickname as writerNickname, " +
        "u.profile_image as writerProfileImage " +
        "FROM board as b " + 
        "INNER JOIN user as u " +
        "ON b.writer_email = u.email " +
        "WHERE board_number = ?1",
        nativeQuery = true
    )
    GetBoardResultSet getBoard(Integer boardNumber);
}
