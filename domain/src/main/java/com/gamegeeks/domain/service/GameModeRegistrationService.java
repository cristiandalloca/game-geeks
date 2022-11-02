package com.gamegeeks.domain.service;

import com.gamegeeks.domain.exception.gamemode.GameModeNotFoundException;
import com.gamegeeks.domain.model.GameMode;
import com.gamegeeks.domain.repository.GameModeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameModeRegistrationService implements RegistrationService<GameMode, String> {

    private final GameModeRepository gameModeRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(String id) {
        return gameModeRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public GameMode findByIdOrFail(String id) {
        return gameModeRepository.findById(id).orElseThrow(() -> new GameModeNotFoundException(id));
    }

    @Override
    @Transactional
    public GameMode createOrUpdate(GameMode gameMode) {
        // TODO: Verificar se já existe usuário se for create
        return gameModeRepository.save(gameMode);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        gameModeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameMode> findAll() {
        return gameModeRepository.findAll();
    }
}
