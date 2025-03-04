package com.korit.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.basic.dto.PostUserRequestDto;
import com.korit.basic.dto.ResponseDto;
import com.korit.basic.entity.UserEntity;
import com.korit.basic.repository.UserRepository;
import com.korit.basic.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto) {
    
    String userId = dto.getUserId();
    UserEntity userEntity = userRepository.findByUserId(userId);
    if (userEntity != null) {
      ResponseDto responseBody = new ResponseDto("DI", "Duplicated Id.");
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    String userTelNumber = dto.getUserTelNumber();
    userEntity = userRepository.findByUserTelNumber(userTelNumber);
    if (userEntity != null) {
      ResponseDto responseBody = new ResponseDto("DT", "Duplicated Tel number.");
      return ResponseEntity
        .status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    userEntity = new UserEntity(userId, dto.getUserPassword(), dto.getUserName(), dto.getUserAddress(), userTelNumber);

    userRepository.save(userEntity);

    ResponseDto response = new ResponseDto("SU", "Success.");
    return ResponseEntity.status(HttpStatus.CREATED).body(response);

  }
  
}
