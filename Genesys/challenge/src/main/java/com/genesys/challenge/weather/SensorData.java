package com.genesys.challenge.weather;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.genesys.challenge.exception.SensorApiException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Days")
    private Long days;

    @JsonProperty("temperature")
    private double temperature;


    @Column(name = "reading_date") // Renamed the column to 'reading_date' to avoid conflict with 'date'
    private LocalDate readingDate;

    @Column(name = "sensor_one")
    private double sensorOne;

    @Column(name = "sensor_two")
    private double sensorTwo;

    @Column(name = "sensor_three")
    private double sensorThree;
 

    public SensorData(String string, double s1, double s2, double s3,double t) {
    }

    public SensorData(double temperature) {
        this.temperature = temperature;
    }
    

    // Getters and setters

    public SensorData() {
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
             if(temperature > 57.6){

            throw new SensorApiException("There has never been a higher recorded temperature than 57.6 degrees celcius, this temperature is too high");
          } else{
        this.temperature = temperature;
    }
}
     
    public LocalDate getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(LocalDate readingDate) {
        LocalDate today = LocalDate.now();
                 if(readingDate != null && readingDate.isAfter(today)){
            throw new SensorApiException("This data cannot be inputted as the Date cannot be after today");
          } else{
        this.readingDate = readingDate;

    }
}


        public double getSensorOne() {
        return sensorOne;
    }
    public void setSensorOne(double sensorOne) {
        this.sensorOne = sensorOne;
    }
    
    public double getSensorTwo() {
        return sensorTwo;
    }

    public void setSensorTwo(double sensorTwo) {
        this.sensorTwo = sensorTwo;
    }
        public double getSensorThree() {
        return sensorThree;
    }

    public void setSensorThree(double sensorThree) {
        this.sensorThree = sensorThree;
    }




}