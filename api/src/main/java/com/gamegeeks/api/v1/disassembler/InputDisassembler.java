package com.gamegeeks.api.v1.disassembler;


public interface InputDisassembler<I, D> {
    D toDomainObject(I source);
    void copyToDomainObject(I source, D destination);
}
