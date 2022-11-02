package com.gamegeeks.domain.service;

import com.gamegeeks.domain.exception.franchise.FranchiseNotFoundException;
import com.gamegeeks.domain.model.Franchise;
import com.gamegeeks.domain.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FranchiseRegistrationService implements RegistrationService<Franchise, String> {

    private final FranchiseRepository franchiseRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(String id) {
        return franchiseRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Franchise findByIdOrFail(String id) {
        return franchiseRepository.findById(id).orElseThrow(() -> new FranchiseNotFoundException(id));
    }

    @Override
    @Transactional
    public Franchise createOrUpdate(Franchise franchise) {
        // TODO: Verificar se já existe usuário se for create
        return franchiseRepository.save(franchise);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        franchiseRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Franchise> findAll() {
        return franchiseRepository.findAll();
    }
}
