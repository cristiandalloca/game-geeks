package com.gamegeeks.domain.service;

import com.gamegeeks.domain.exception.platform.PlatformNotFoundException;
import com.gamegeeks.domain.model.Platform;
import com.gamegeeks.domain.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatformRegistrationService implements RegistrationService<Platform, String> {

    private final PlatformRepository platformRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(String id) {
        return platformRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Platform findByIdOrFail(String id) {
        return platformRepository.findById(id).orElseThrow(() -> new PlatformNotFoundException(id));
    }

    @Override
    @Transactional
    public Platform createOrUpdate(Platform platform) {
        // TODO: Verificar se já existe usuário se for create
        return platformRepository.save(platform);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        platformRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }
}
