package com.board.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.board.boardback.entity.FavoriteEntity;
import com.board.boardback.entity.primaryKey.FavoritePk;
import com.board.boardback.repository.resultSet.GetFavoriteListResultSet;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk>{

    FavoriteEntity findByBoardNumberAndUserEmail(Integer boardNumber, String userEmail);

    @Query(
        value =
        "SELECT " +
            "u.email as email, " +
            "u.nickname as nickname, " +
            "u.profile_image as profileImage " +
        "FROM favorite as f " +
        "INNER join user as u " +
        "ON f.user_email = u.email " +
        "where f.board_number = ?1",
        nativeQuery = true
    )
    List<GetFavoriteListResultSet> getFavoriteList(Integer boardNumber);
    
}



