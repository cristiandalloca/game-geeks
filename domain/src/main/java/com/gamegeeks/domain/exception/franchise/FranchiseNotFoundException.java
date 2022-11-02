package com.gamegeeks.domain.exception.franchise;

import com.gamegeeks.domain.exception.DocumentNotFoundException;

public class FranchiseNotFoundException extends DocumentNotFoundException {

    public FranchiseNotFoundException(String franchiseId) {
        super(String.format("Não existe um cadastro de franquia com código %s", franchiseId));
    }

}
