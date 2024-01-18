package com.board.boardback.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.board.boardback.common.ResponseCode;
import com.board.boardback.common.ResponseMessage;
import com.board.boardback.dto.response.ResponseDto;
import com.board.boardback.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetSignUserReponseDto extends ResponseDto{

    private String email;
    private String nickname;
    private String profileImage;

    private GetSignUserReponseDto(UserEntity userEntity){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.profileImage = userEntity.getProfileImage();
    }

    public static ResponseEntity<GetSignUserReponseDto> success(UserEntity userEntity){
        GetSignUserReponseDto result = new GetSignUserReponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExEntityUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
