package com.fitstore.fitstore_core.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request){
        try{
            User user = userService.register(request);
            return ResponseEntity.ok().body(
                    new java.util.LinkedHashMap<>(){{
                        put("id", user.getId());
                        put("email",user.getEmail());
                        put("fullName", user.getFullName());
                    }}
            );
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}