package com.gamegeeks.api.v1.assembler;

import com.gamegeeks.api.v1.model.UserModel;
import com.gamegeeks.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserModelAssembler implements ModelAssembler<User, UserModel> {

    private final ModelMapper modelMapper;

    @Override
    public UserModel toModel(User user) {
        return modelMapper.map(user, UserModel.class);
    }

}
