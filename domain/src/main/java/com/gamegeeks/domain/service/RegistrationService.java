package com.gamegeeks.domain.service;

import java.util.List;

public interface RegistrationService<D, T> {
    boolean existsById(T id);
    D findByIdOrFail(T id);
    D createOrUpdate(D document);
    void deleteById(T id);
    List<D> findAll();
}
