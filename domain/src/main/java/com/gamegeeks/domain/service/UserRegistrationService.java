package com.gamegeeks.domain.service;

import com.gamegeeks.domain.exception.user.UserNotFoundException;
import com.gamegeeks.domain.model.User;
import com.gamegeeks.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRegistrationService implements RegistrationService<User, String> {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByIdOrFail(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    @Transactional
    public User createOrUpdate(User document) {
        // TODO: Verificar se já existe usuário se for create
        return userRepository.save(document);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
