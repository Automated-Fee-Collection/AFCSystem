package com.afcs.backend.arrivals;

import com.afcs.backend.capture.Capture;
import com.afcs.backend.capture.CaptureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/arrivals")
public class ArrivalsController {
    private final ArrivalsRepository arrivalsRepository;

    public ArrivalsController (ArrivalsRepository arrivalsRepository){
        this.arrivalsRepository = arrivalsRepository;
    }

    @GetMapping
    public List<Arrivals> getArrivals(){
        return arrivalsRepository.findAll();
    }
}
