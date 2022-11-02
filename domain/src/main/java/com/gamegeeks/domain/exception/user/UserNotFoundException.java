package com.gamegeeks.domain.exception.user;


import com.gamegeeks.domain.exception.DocumentNotFoundException;

public class UserNotFoundException extends DocumentNotFoundException {

    public UserNotFoundException(String userId) {
        super(String.format("Não existe um cadastro de usuário com código %s", userId));
    }

}
