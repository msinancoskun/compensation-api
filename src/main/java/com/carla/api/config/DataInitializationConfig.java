package com.carla.api.config;

import com.carla.api.entities.Compensation;
import com.carla.api.repositories.CompensationRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DataInitializationConfig implements CommandLineRunner {

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Compensation>> typeReference = new TypeReference<List<Compensation>>() {
        };

        InputStream inputStream = TypeReference.class.getResourceAsStream("/static/salary_survey-3.json");
        try {
            System.out.println("Compensation data is being read!");
            List<Compensation> compensations = mapper.readValue(inputStream, typeReference);
            System.out.println(
                    "Saving compensation data into Repository! This can take up to 5 minutes for the first start!");
            compensationRepository.saveAll(compensations);
            System.out.println("Compensation data saved!");
        } catch (Exception e) {
            System.out.println("Unable to save compensation data: " + e.getMessage());
        }
    }
}