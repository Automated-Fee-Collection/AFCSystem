package com.afcs.backend.capture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptureRepository extends JpaRepository<Capture, Long> {

}
