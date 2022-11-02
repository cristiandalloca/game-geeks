package com.gamegeeks.domain.exception.developer;

import com.gamegeeks.domain.exception.DocumentNotFoundException;

public class DeveloperNotFoundException extends DocumentNotFoundException {

    public DeveloperNotFoundException(String developerId) {
        super(String.format("Não existe um cadastro de desenvolvedor com código %s", developerId));
    }

}
