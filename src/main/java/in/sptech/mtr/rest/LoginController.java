package in.sptech.mtr.rest;

import in.sptech.mtr.dto.LoginRequest;
import in.sptech.mtr.repository.UserRepository;
import in.sptech.mtr.security.JwtUtil;
import in.sptech.mtr.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "APIs for User Registration and Login")
public class LoginController {

    private final UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Login user",
            description = "Authenticates a user and returns a JWT token"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Login successful"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Invalid credentials")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest dto) {

        try {
            String token = userService.login(dto);
            return ResponseEntity.ok(Map.of(
                    "token", "Bearer " + token,
                    "message", "Login Successful"));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiError("Login Unsuccessful " + e.getMessage()));
        }



//        return userRepository.findByEmail(email)
//                .map(user -> {
//                    if (passwordEncoder.matches(password, user.getPasswordHash())) {
//                        String token = jwtUtil.generateToken(email);
//                        return ResponseEntity.ok("Bearer " + token);
//                    } else {
//                        return ResponseEntity.status(401).body("Invalid email or password");
//                    }
//                })
//                .orElseGet(() -> ResponseEntity.status(401).body("Invalid email or password"));
    }
}
