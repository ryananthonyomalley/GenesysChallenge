package com.genesys.challenge.controller;



import com.genesys.challenge.weather.SensorDataService;
import com.genesys.challenge.weather.SensorData;
import com.genesys.challenge.weather.SensorDataRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class SensorDataController {
  

  private final SensorDataService sensorDataService;
  private final SensorDataRepository sensorDataRepository;

  @Autowired
  public SensorDataController(SensorDataService sensorDataService, SensorDataRepository sensorDataRepository) {
      this.sensorDataService = sensorDataService;
      this.sensorDataRepository = sensorDataRepository;
  }

  @GetMapping("/average-temperature")
  public ResponseEntity<Double> getAverageTemperature() {
      Double averageTemperature = sensorDataService.getAverageTemperature();
      return ResponseEntity.ok(averageTemperature);
  }


  @GetMapping("/all-temperature")
  public ResponseEntity<List<SensorData>> getLast30DaysTemperatureData() {
      List<SensorData> temperatureData = sensorDataService.getLast30DaysTemperatureData();
      return ResponseEntity.ok(temperatureData);
  }


      @GetMapping("/sensor-one-one-week")
      public ResponseEntity<List<Double>> getSensorOneTemperatureDataOneWeek() {
        List<SensorData> savedData = sensorDataService.getSensorOneTemperatureDataOneWeek();
        List<Double> sensorOneData = new ArrayList<>();
        for (SensorData data : savedData) {
            sensorOneData.add(data.getSensorOne());
        }
        
        return ResponseEntity.ok(sensorOneData);
    }
    
      @GetMapping("/sensor-two-one-week")
  public ResponseEntity<List<Double>> getSensorTwoTemperatureDataOneWeek() {
        List<SensorData> savedData = sensorDataService.getSensorTwoTemperatureDataOneWeek();
        List<Double> sensorTwoData = new ArrayList<>();
        for (SensorData data : savedData) {
            sensorTwoData.add(data.getSensorTwo());
        }
        
        return ResponseEntity.ok(sensorTwoData);
    }


      @GetMapping("/sensor-three-one-week")
  public ResponseEntity<List<Double>> getSensorThreeTemperatureDataOneWeek() {
        List<SensorData> savedData = sensorDataService.getSensorThreeTemperatureDataOneWeek();
        List<Double> sensorThreeData = new ArrayList<>();
        for (SensorData data : savedData) {
            sensorThreeData.add(data.getSensorThree());
        }
        
        return ResponseEntity.ok(sensorThreeData);
    }


    @GetMapping("/sensor-one-two-weeks")
  public ResponseEntity<List<Double>> getSensorOneTemperatureDataBetweenTwoWeeks() {
        List<SensorData> savedData = sensorDataService.getSensorOneTemperatureDataBetweenTwoWeeks();
        List<Double> sensorOneData = new ArrayList<>();
        for (SensorData data : savedData) {
            sensorOneData.add(data.getSensorOne());
        }
        
        return ResponseEntity.ok(sensorOneData);
    }


      @GetMapping("/sensor-two-two-weeks")
  public ResponseEntity<List<Double>> getSensorTwoTemperatureDataBetweenTwoWeeks() {
        List<SensorData> savedData = sensorDataService.getSensorTwoTemperatureDataBetweenTwoWeeks();
        List<Double> sensorTwoData = new ArrayList<>();
        for (SensorData data : savedData) {
            sensorTwoData.add(data.getSensorTwo());
        }
        
        return ResponseEntity.ok(sensorTwoData);
    }


      @GetMapping("/sensor-three-two-weeks")
  public ResponseEntity<List<Double>> getSensorthreeTemperatureDataBetweenTwoWeeks() {
        List<SensorData> savedData = sensorDataService.getSensorThreeTemperatureDataBetweenTwoWeeks();
        List<Double> sensorThreeData = new ArrayList<>();
        for (SensorData data : savedData) {
            sensorThreeData.add(data.getSensorThree());
        }
        
        return ResponseEntity.ok(sensorThreeData);
    }


      @GetMapping("/avg-sensor-one")
      public ResponseEntity<Double> getAverageSensorOneTemperatureData() {
        Double sensorOneAverage = sensorDataService.getSensorOneTemperatureDataAverage();
        return ResponseEntity.ok(sensorOneAverage);
    }

          @GetMapping("/avg-sensor-one-two-weeks")
      public ResponseEntity<Double> getSensorOneTemperatureDataTwoWeeksAverage() {
        Double sensorOneTwoWeeks = sensorDataService.getSensorOneTemperatureDataTwoWeeksAverage();
        return ResponseEntity.ok(sensorOneTwoWeeks);
    }

//This posts the temperature and sensor data for each day and gives the date
    @PostMapping("/sensor-data")
    public ResponseEntity<List<SensorData>> addSensorData(@RequestBody List<SensorData> sensorDataList) {
      List<SensorData> savedData = sensorDataService.saveSensorDataList(sensorDataList);
      return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

}















    

