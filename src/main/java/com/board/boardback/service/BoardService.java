package com.board.boardback.service;

import org.springframework.http.ResponseEntity;

import com.board.boardback.dto.request.board.PostBoardRequestDto;
import com.board.boardback.dto.request.board.PostCommentReqeustDto;
import com.board.boardback.dto.response.board.GetBoardResponseDto;
import com.board.boardback.dto.response.board.GetCommentListResponseDto;
import com.board.boardback.dto.response.board.GetFavoriteListResponseDto;
import com.board.boardback.dto.response.board.PostBoardResponseDto;
import com.board.boardback.dto.response.board.PostCommentResponseDto;
import com.board.boardback.dto.response.board.PutFavoriteResponseDto;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);

    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
    ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentReqeustDto dto, Integer boardNumber ,String email);
    
    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);

}
