package com.gamegeeks.domain.exception.developer;

import com.gamegeeks.domain.exception.BusinessException;

public class DeveloperDuplicateException extends BusinessException {

    public DeveloperDuplicateException(String name) {
        super(String.format("Já existe cadastro de desenvolvedor com o nome %s", name));
    }
}
