package com.gamegeeks.api.v1.assembler;

import com.gamegeeks.api.v1.model.PlatformModel;
import com.gamegeeks.domain.model.Platform;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlatformModelAssembler implements ModelAssembler<Platform, PlatformModel> {

    private final ModelMapper modelMapper;

    @Override
    public PlatformModel toModel(Platform platform) {
        return modelMapper.map(platform, PlatformModel.class);
    }

}
