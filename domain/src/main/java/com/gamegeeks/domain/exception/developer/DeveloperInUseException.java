package com.gamegeeks.domain.exception.developer;

import com.gamegeeks.domain.exception.BusinessException;

public class DeveloperInUseException extends BusinessException {

    public DeveloperInUseException(String name) {
        super(String.format("Não é possível remover o desenvolvedor %s, pois o mesmo está sendo utilizado em um ou mais recursos", name));
    }
}
