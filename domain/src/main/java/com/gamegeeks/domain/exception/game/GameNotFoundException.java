package com.gamegeeks.domain.exception.game;

import com.gamegeeks.domain.exception.DocumentNotFoundException;

public class GameNotFoundException extends DocumentNotFoundException {

    public GameNotFoundException(String gameId) {
        super(String.format("Não existe um cadastro de jogo com código %s", gameId));
    }

}
