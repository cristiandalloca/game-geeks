package com.gamegeeks.api.v1.assembler;

import com.gamegeeks.api.v1.model.FranchiseModel;
import com.gamegeeks.domain.model.Franchise;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FranchiseModelAssembler implements ModelAssembler<Franchise, FranchiseModel> {

    private final ModelMapper modelMapper;

    @Override
    public FranchiseModel toModel(Franchise franchise) {
        return modelMapper.map(franchise, FranchiseModel.class);
    }

}
