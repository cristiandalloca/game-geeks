package com.gamegeeks.domain.service;

import com.gamegeeks.domain.exception.genre.GenreNotFoundException;
import com.gamegeeks.domain.model.Genre;
import com.gamegeeks.domain.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreRegistrationService implements RegistrationService<Genre, String> {

    private final GenreRepository genreRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(String id) {
        return genreRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Genre findByIdOrFail(String id) {
        return genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id));
    }

    @Override
    @Transactional
    public Genre createOrUpdate(Genre genre) {
        // TODO: Verificar se já existe usuário se for create
        return genreRepository.save(genre);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        genreRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
