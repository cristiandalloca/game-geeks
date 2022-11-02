package com.gamegeeks.domain.exception.platform;

import com.gamegeeks.domain.exception.DocumentNotFoundException;

public class PlatformNotFoundException extends DocumentNotFoundException {

    public PlatformNotFoundException(String platformId) {
        super(String.format("Não existe um cadastro de plataforma com código %s", platformId));
    }

}
