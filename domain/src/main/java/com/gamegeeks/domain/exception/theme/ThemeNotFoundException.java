package com.gamegeeks.domain.exception.theme;

import com.gamegeeks.domain.exception.DocumentNotFoundException;

public class ThemeNotFoundException extends DocumentNotFoundException {

    public ThemeNotFoundException(String themeId) {
        super(String.format("Não existe um cadastro de tema com código %s", themeId));
    }

}
