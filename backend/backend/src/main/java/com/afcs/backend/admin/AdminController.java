package com.afcs.backend.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AdminController {
        private final AdminRepository adminRepository;

        @Autowired
        public AdminController(AdminRepository adminRepository) {
            this.adminRepository = adminRepository;
        }

    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        Optional<Admin> adminOpt = adminRepository.findByUsername(request.getUsername());

        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            if (admin.getPassword().equals(request.getPassword())) {

                String name = admin.getUsername();
                Map<String, String> response = new HashMap<>();
                response.put("message", "Welcome back " + name + "!");
                response.put("name", admin.getUsername());
                return ResponseEntity.ok(response);
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","Invalid credentials"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","An error occurred while trying to log in."));
    }

}
