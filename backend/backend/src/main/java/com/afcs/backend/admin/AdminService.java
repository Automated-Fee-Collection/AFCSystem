package com.afcs.backend.admin;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class AdminService {
    public List<Admin> getAdmins () {
        return List.of(
                new Admin(
                        1L,
                        "Suleiman Suleiman",
                        "255743900555",
                        "suleimansleiz@gmail.com",
                        "#20SULEiman"
                )
        );
    }
}
