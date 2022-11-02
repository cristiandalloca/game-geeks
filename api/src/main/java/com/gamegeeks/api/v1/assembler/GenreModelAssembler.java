package com.gamegeeks.api.v1.assembler;

import com.gamegeeks.api.v1.model.GenreModel;
import com.gamegeeks.domain.model.Genre;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenreModelAssembler implements ModelAssembler<Genre, GenreModel> {

    private final ModelMapper modelMapper;

    @Override
    public GenreModel toModel(Genre genre) {
        return modelMapper.map(genre, GenreModel.class);
    }

}
