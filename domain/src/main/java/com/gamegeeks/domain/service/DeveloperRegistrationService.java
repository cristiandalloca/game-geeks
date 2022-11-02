package com.gamegeeks.domain.service;

import com.gamegeeks.domain.exception.developer.DeveloperNotFoundException;
import com.gamegeeks.domain.model.Developer;
import com.gamegeeks.domain.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperRegistrationService implements RegistrationService<Developer, String> {

    private final DeveloperRepository developerRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(String id) {
        return developerRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Developer findByIdOrFail(String id) {
        return developerRepository.findById(id).orElseThrow(() -> new DeveloperNotFoundException(id));
    }

    @Override
    @Transactional
    public Developer createOrUpdate(Developer developer) {
        // TODO: Verificar se já existe usuário se for create
        return developerRepository.save(developer);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        developerRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Developer> findAll() {
        return developerRepository.findAll();
    }
}
