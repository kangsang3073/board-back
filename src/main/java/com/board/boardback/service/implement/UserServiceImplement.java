package com.board.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.board.boardback.dto.response.ResponseDto;
import com.board.boardback.dto.response.user.GetSignUserReponseDto;
import com.board.boardback.entity.UserEntity;
import com.board.boardback.repository.UserRepository;
import com.board.boardback.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetSignUserReponseDto> getSignInUser(String email) {
        
        UserEntity userEntity = null;

        try {

            userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return GetSignUserReponseDto.notExEntityUser();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignUserReponseDto.success(userEntity);
    }
    
}
