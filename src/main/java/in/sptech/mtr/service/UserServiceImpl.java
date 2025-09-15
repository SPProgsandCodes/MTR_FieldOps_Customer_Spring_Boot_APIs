package in.sptech.mtr.service;

import in.sptech.mtr.dto.LoginRequest;
import in.sptech.mtr.dto.RegisterUserRequest;
import in.sptech.mtr.entity.RegisterUserEntity;
import in.sptech.mtr.exception.DuplicateResourceException;
import in.sptech.mtr.exception.UsernameNotFoundException;
import in.sptech.mtr.repository.UserRepository;
import in.sptech.mtr.security.JwtUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    @Transactional
    public void register(RegisterUserRequest dto) {
        if (existsByEmail(dto.getEmail())){
            throw new DuplicateResourceException("Email Already in Use");
        }

        RegisterUserEntity user = new RegisterUserEntity();
        user.setFirstName(dto.getFirstName().trim());
        user.setMiddleName(dto.getMiddleName().trim());
        user.setLastName(dto.getLastName().trim());
        user.setEmail(dto.getEmail().toLowerCase().trim());
        user.setRoleId(dto.getRoleId());
        user.setYearOfExp(dto.getYearOfExp());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(true);

        try{
            RegisterUserEntity saved = userRepository.save(user);
        } catch (DataIntegrityViolationException e){
            throw new DuplicateResourceException("Email already Exists");
        }
    }

    @Override
    public String login(LoginRequest dto) {
        return userRepository.findByEmail(dto.getEmail())
                .map(user -> {
                    if (passwordEncoder.matches(dto.getPassword(), user.getPasswordHash())) {
                            return jwtUtil.generateToken(user.getEmail());
                    } else {
                        throw new BadCredentialsException("Invalid Password");
                    }
                })
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + dto.getEmail()));
    }
}
