package com.gamegeeks.api.v1.assembler;

import com.gamegeeks.api.v1.model.DeveloperModel;
import com.gamegeeks.domain.model.Developer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeveloperModelAssembler implements ModelAssembler<Developer, DeveloperModel> {

    private final ModelMapper modelMapper;

    @Override
    public DeveloperModel toModel(Developer developer) {
        return modelMapper.map(developer, DeveloperModel.class);
    }
}
