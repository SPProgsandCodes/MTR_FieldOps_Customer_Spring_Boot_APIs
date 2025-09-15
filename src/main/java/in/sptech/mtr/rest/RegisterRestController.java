package in.sptech.mtr.rest;

import in.sptech.mtr.dto.RegisterUserRequest;
import in.sptech.mtr.entity.RegisterUserEntity;
import in.sptech.mtr.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "APIs for User Registration and Login")
public class RegisterRestController {
    private final UserService userService;

    @Autowired
    public RegisterRestController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "Register a new user", description = "Registers a user with email, username, and password")
    @PostMapping(
            value = "/register"
    )
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserRequest request) {
        if (userService.existsByEmail(request.getEmail())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ApiError("Email already in use"));
        }

        userService.register(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse("Registration successful"));
    }
}
