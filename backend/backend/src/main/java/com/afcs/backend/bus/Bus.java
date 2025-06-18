package com.afcs.backend.bus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String plate;
    private String bus_name;
    private String bus_type;
    private String route;
    private String owner_phone;

    public Bus() {
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public String getBus_type() {
        return bus_type;
    }

    public void setBus_type(String bus_type) {
        this.bus_type = bus_type;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "plate='" + plate + '\'' +
                ", bus_name='" + bus_name + '\'' +
                ", bus_type='" + bus_type + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
