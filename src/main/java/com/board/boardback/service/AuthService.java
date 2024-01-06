package com.board.boardback.service;

import org.springframework.http.ResponseEntity;

import com.board.boardback.dto.request.auth.SignInRequestDto;
import com.board.boardback.dto.request.auth.SignUpRequestDto;
import com.board.boardback.dto.response.auth.SignInResponseDto;
import com.board.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
    
}
