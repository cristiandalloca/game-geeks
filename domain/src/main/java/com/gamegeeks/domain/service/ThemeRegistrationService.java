package com.gamegeeks.domain.service;

import com.gamegeeks.domain.exception.theme.ThemeNotFoundException;
import com.gamegeeks.domain.model.Theme;
import com.gamegeeks.domain.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeRegistrationService implements RegistrationService<Theme, String> {

    private final ThemeRepository themeRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(String id) {
        return themeRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Theme findByIdOrFail(String id) {
        return themeRepository.findById(id).orElseThrow(() -> new ThemeNotFoundException(id));
    }

    @Override
    @Transactional
    public Theme createOrUpdate(Theme theme) {
        // TODO: Verificar se já existe usuário se for create
        return themeRepository.save(theme);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        themeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }
}
