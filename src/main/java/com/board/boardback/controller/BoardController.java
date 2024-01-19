package com.board.boardback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.boardback.dto.request.board.PostBoardRequestDto;
import com.board.boardback.dto.response.board.PostBoardResponseDto;
import com.board.boardback.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
        @RequestBody @Valid PostBoardRequestDto requestBody,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody, email);
        return response;
    }
    
}