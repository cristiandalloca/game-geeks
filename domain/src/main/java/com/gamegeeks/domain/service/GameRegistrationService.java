package com.gamegeeks.domain.service;

import com.gamegeeks.domain.exception.game.GameNotFoundException;
import com.gamegeeks.domain.model.Game;
import com.gamegeeks.domain.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameRegistrationService implements RegistrationService<Game, String> {

    private final GameRepository gameRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(String id) {
        return gameRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Game findByIdOrFail(String id) {
        return gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
    }

    @Override
    @Transactional
    public Game createOrUpdate(Game game) {
        // TODO: Verificar se já existe usuário se for create
        return gameRepository.save(game);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        gameRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
