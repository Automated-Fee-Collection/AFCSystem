package com.afcs.backend.capture;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

    @Entity
    @Table(name = "arrivals")
    @Data
    @AllArgsConstructor
    public class Capture {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String plate;
        private String bus_name;
        private Double fee;

        @Column(name = "arrival_time", nullable = false, updatable = false)
        private LocalDateTime arrival_time;

        @PrePersist
        protected void onCreate() {
            arrival_time = LocalDateTime.now();
        }

        public Capture() {
        }

        protected void setPlate(String plate) {
            this.plate = plate;
        }

        protected void setBus_name(String bus_name) {
            this.bus_name = bus_name;
        }

        public void setBus_fee(Double bus_fee) {
            this.fee = bus_fee;
        }
    }
