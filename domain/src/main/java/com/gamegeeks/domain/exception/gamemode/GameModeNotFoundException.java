package com.gamegeeks.domain.exception.gamemode;

import com.gamegeeks.domain.exception.DocumentNotFoundException;

public class GameModeNotFoundException extends DocumentNotFoundException {

    public GameModeNotFoundException(String gameModeId) {
        super(String.format("Não existe um cadastro de modo de jogo com código %s", gameModeId));
    }

}
