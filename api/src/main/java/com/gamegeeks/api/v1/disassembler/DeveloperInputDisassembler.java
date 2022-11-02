package com.gamegeeks.api.v1.disassembler;

import com.gamegeeks.api.v1.model.input.DeveloperInput;
import com.gamegeeks.domain.model.Developer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeveloperInputDisassembler implements InputDisassembler<DeveloperInput, Developer> {

    private final ModelMapper modelMapper;

    @Override
    public Developer toDomainObject(DeveloperInput developerInput) {
        return modelMapper.map(developerInput, Developer.class);
    }

    @Override
    public void copyToDomainObject(DeveloperInput developerInput, Developer developer) {
        modelMapper.map(developerInput, developer);
    }
}
