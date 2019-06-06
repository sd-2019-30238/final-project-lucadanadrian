package com.finalproject.demo.model;

import javax.persistence.*;

@Entity
@Table
public class BusSchedule {
    @Id
    @Column(name = "bus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bus_line")
    private String line;
    @Column(name = "bus_trip")
    private String trip;
    @Column(name = "bus_stations")
    private String stations;
    @Column(name = "bus_information")
    private String information;

    public BusSchedule() {
    }

    public BusSchedule(String line, String trip, String stations, String information) {
        this.line = line;
        this.trip = trip;
        this.stations = stations;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getStations() {
        return stations;
    }

    public void setStations(String stations) {
        this.stations = stations;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
