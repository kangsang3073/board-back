package com.board.boardback.service;

import org.springframework.http.ResponseEntity;

import com.board.boardback.dto.response.user.GetSignUserReponseDto;

public interface UserService {
    ResponseEntity<? super GetSignUserReponseDto> getSignInUser(String email);
}
