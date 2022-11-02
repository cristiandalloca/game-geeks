package com.gamegeeks.api.v1.assembler;

import java.util.List;

public interface ModelAssembler<S, D> {
    D toModel(S source);

    default List<D> toCollectionModel(List<S> source) {
        return source.stream()
                .map(this::toModel)
                .toList();
    }
}
