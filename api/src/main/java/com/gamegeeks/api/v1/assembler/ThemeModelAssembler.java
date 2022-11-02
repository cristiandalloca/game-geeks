package com.gamegeeks.api.v1.assembler;

import com.gamegeeks.api.v1.model.ThemeModel;
import com.gamegeeks.domain.model.Theme;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ThemeModelAssembler implements ModelAssembler<Theme, ThemeModel> {

    private final ModelMapper modelMapper;

    @Override
    public ThemeModel toModel(Theme theme) {
        return modelMapper.map(theme, ThemeModel.class);
    }

}
