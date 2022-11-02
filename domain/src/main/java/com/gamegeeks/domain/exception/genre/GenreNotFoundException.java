package com.gamegeeks.domain.exception.genre;

import com.gamegeeks.domain.exception.DocumentNotFoundException;

public class GenreNotFoundException extends DocumentNotFoundException {

    public GenreNotFoundException(String genreId) {
        super(String.format("Não existe um cadastro de gênero com código %s", genreId));
    }

}
