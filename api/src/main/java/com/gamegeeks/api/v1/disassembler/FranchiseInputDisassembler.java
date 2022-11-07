package com.gamegeeks.api.v1.disassembler;

import com.gamegeeks.api.v1.model.input.DeveloperInput;
import com.gamegeeks.api.v1.model.input.FranchiseInput;
import com.gamegeeks.domain.model.Developer;
import com.gamegeeks.domain.model.Franchise;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FranchiseInputDisassembler implements InputDisassembler<FranchiseInput, Franchise> {

    private final ModelMapper modelMapper;

    @Override
    public Franchise toDomainObject(FranchiseInput franchiseInput) {
        return modelMapper.map(franchiseInput, Franchise.class);
    }

    @Override
    public void copyToDomainObject(FranchiseInput franchiseInput, Franchise franchise) {
        modelMapper.map(franchiseInput, franchise);
    }
}
