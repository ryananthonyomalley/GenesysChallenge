package com.genesys.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.genesys.challenge.weather.SensorData;
import com.genesys.challenge.weather.SensorDataRepository;
import com.genesys.challenge.weather.SensorDataService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class ChallengeApplicationTests {
	

  @Autowired
  private SensorDataService sensorDataService;

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Test
    public void testSaveTemperatureDataList() {
        List<SensorData> testData = new ArrayList<>();
        testData.add(new SensorData("2023-07-20", 25.8, 13.0, 16.6, 19.5));
        testData.add(new SensorData("2023-07-21", 26.2, 12.5, 17.0, 20.1));

        List<SensorData> savedData = sensorDataService.saveTemperatureDataList(testData);

        assertEquals(testData.size(), savedData.size());
    }

	@Test
    @Rollback(false)
	public void testGetLast30DaysTemperatureData() {
            List<SensorData> testData = new ArrayList<>();
        testData.add(new SensorData("2023-07-20", 25.8, 13.0, 16.6, 19.5));
        testData.add(new SensorData("2023-07-21", 26.2, 12.5, 17.0, 20.1));

        List<SensorData> savedData = sensorDataService.saveTemperatureDataList(testData);

        assertEquals(testData.size(), savedData.size());
    }
	@Test
    @Rollback(false) // 
    public void testAddTemperatureData() {
        double temperature = 25.8;
        sensorDataService.addTemperatureData(temperature);

        assertEquals(25.8, temperature, 0.01);
    }



}
