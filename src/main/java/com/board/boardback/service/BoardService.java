package com.board.boardback.service;

import org.springframework.http.ResponseEntity;

import com.board.boardback.dto.request.board.PostBoardRequestDto;
import com.board.boardback.dto.response.board.GetBoardResponseDto;
import com.board.boardback.dto.response.board.PostBoardResponseDto;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
    
}
