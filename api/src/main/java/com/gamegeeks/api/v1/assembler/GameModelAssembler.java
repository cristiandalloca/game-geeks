package com.gamegeeks.api.v1.assembler;

import com.gamegeeks.api.v1.model.GameModel;
import com.gamegeeks.domain.model.Game;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameModelAssembler implements ModelAssembler<Game, GameModel> {

    private final ModelMapper modelMapper;

    @Override
    public GameModel toModel(Game game) {
        return modelMapper.map(game, GameModel.class);
    }

}
