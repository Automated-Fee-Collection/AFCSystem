package com.afcs.backend.arrivals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrivalsRepository extends JpaRepository<Arrivals, Long> {
}
