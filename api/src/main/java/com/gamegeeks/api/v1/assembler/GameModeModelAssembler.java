package com.gamegeeks.api.v1.assembler;

import com.gamegeeks.api.v1.model.GameModeModel;
import com.gamegeeks.domain.model.GameMode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameModeModelAssembler implements ModelAssembler<GameMode, GameModeModel> {

    private final ModelMapper modelMapper;

    @Override
    public GameModeModel toModel(GameMode gameMode) {
        return modelMapper.map(gameMode, GameModeModel.class);
    }

}
