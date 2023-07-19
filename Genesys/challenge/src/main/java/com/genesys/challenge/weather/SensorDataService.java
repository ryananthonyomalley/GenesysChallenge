package com.genesys.challenge.weather;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {
    
    private double temperature;
    private final SensorDataRepository sensorDataRepository;


    @Autowired
    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }
    
    public SensorData saveSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }
    public Double getAverageTemperature() {
            return sensorDataRepository.getAverageTemperature();
        }

          
    public void addTemperatureData(double temperature) {
        SensorData sensorData = new SensorData();
        sensorData.setTemperature(temperature);

        sensorDataRepository.save(sensorData);
    }


    public List<SensorData> getLast30DaysTemperatureData() {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        return sensorDataRepository.getLast30DaysTemperatureData(thirtyDaysAgo);
    }

    // This method 
    public List<SensorData> saveTemperatureDataList(List<SensorData> temperatureDataList) {
        return sensorDataRepository.saveAll(temperatureDataList);
    }

    // The following methods are to get the sensor temperature data for one week period 
        public List<SensorData> getSensorOneTemperatureDataOneWeek() {
        return sensorDataRepository.findSensorOneTemperatureDataOneWeek();
    }

        public List<SensorData> getSensorTwoTemperatureDataOneWeek() {
        return sensorDataRepository.findSensorTwoTemperatureDataOneWeek();
    }

        public List<SensorData> getSensorThreeTemperatureDataOneWeek() {
        return sensorDataRepository.findSensorThreeTemperatureDataOneWeek();
    }




    // The following methods are for getting the sensor data for two week period
    public List<SensorData> getSensorOneTemperatureDataBetweenTwoWeeks() {
        return sensorDataRepository.findSensorOneTemperatureDataTwoWeeks();
    }

        public List<SensorData> getSensorTwoTemperatureDataBetweenTwoWeeks() {
        return sensorDataRepository.findSensorOneTemperatureDataTwoWeeks();
    }

        public List<SensorData> getSensorThreeTemperatureDataBetweenTwoWeeks() {
        return sensorDataRepository.findSensorThreeTemperatureDataTwoWeeks();
    }


    public Double getSensorOneTemperatureDataAverage() {
        return sensorDataRepository.findSensorOneTemperatureDataAverage();
    }

        public Double getSensorOneTemperatureDataTwoWeeksAverage() {
        return sensorDataRepository.findSensorOneTemperatureDataTwoWeeksAverage();
    }

      public List<SensorData> saveSensorDataList(List<SensorData> sensorDataList) {
        return sensorDataRepository.saveAll(sensorDataList);
    }

}
