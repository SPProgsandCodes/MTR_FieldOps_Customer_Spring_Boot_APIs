package in.sptech.mtr.service;

import in.sptech.mtr.dto.LoginRequest;
import in.sptech.mtr.dto.RegisterUserRequest;
import in.sptech.mtr.entity.RegisterUserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    boolean existsByEmail(String email);
    void register(RegisterUserRequest dto);
    String login(LoginRequest dto);
}
