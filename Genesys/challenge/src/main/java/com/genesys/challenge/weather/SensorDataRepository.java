package com.genesys.challenge.weather;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface SensorDataRepository extends JpaRepository<SensorData, Integer>{


@Query("SELECT s FROM SensorData s WHERE s.temperature = :temperature")
List<SensorDataService> findByTemperature(double temperature);


@Query("SELECT AVG(s.temperature) FROM SensorData s")
Double getAverageTemperature();



@Query("SELECT s FROM SensorData s WHERE s.readingDate >= :startDate ORDER BY s.readingDate DESC")
List<SensorData> getLast30DaysTemperatureData(LocalDate startDate);

@Query("SELECT s FROM SensorData s WHERE s.readingDate >= :startDate ORDER BY s.readingDate DESC")
SensorData getReadingDate(LocalDate startDate);



// These Queries are to get each sensor data for a period of one week
@Query("SELECT sd FROM SensorData sd WHERE sd.days BETWEEN 1 AND 7 AND sd.sensorOne IS NOT NULL")
List<SensorData> findSensorOneTemperatureDataOneWeek();

@Query("SELECT sd FROM SensorData sd WHERE sd.days BETWEEN 1 AND 7 AND sd.sensorTwo IS NOT NULL")
List<SensorData> findSensorTwoTemperatureDataOneWeek();

@Query("SELECT sd FROM SensorData sd WHERE sd.days BETWEEN 1 AND 7 AND sd.sensorThree IS NOT NULL")
List<SensorData> findSensorThreeTemperatureDataOneWeek();



// These Queries are to get each sensor data for a period of two weeks
@Query("SELECT sd FROM SensorData sd WHERE sd.days BETWEEN 1 AND 14 AND sd.sensorOne IS NOT NULL")
List<SensorData> findSensorOneTemperatureDataTwoWeeks();

@Query("SELECT sd FROM SensorData sd WHERE sd.days BETWEEN 1 AND 14 AND sd.sensorTwo IS NOT NULL")
List<SensorData> findSensorTwoTemperatureDataTwoWeeks();

@Query("SELECT sd FROM SensorData sd WHERE sd.days BETWEEN 1 AND 14 AND sd.sensorThree IS NOT NULL")
List<SensorData> findSensorThreeTemperatureDataTwoWeeks();

@Query("SELECT AVG(sd.sensorOne) FROM SensorData sd WHERE sd.days BETWEEN 1 AND 14 AND sd.sensorOne IS NOT NULL")
Double findSensorOneTemperatureDataTwoWeeksAverage();



// This is to specifically find data for sensor one 
@Query("SELECT AVG(sd.sensorOne) FROM SensorData sd WHERE sd.sensorOne IS NOT NULL")
Double findSensorOneTemperatureDataAverage();


}
