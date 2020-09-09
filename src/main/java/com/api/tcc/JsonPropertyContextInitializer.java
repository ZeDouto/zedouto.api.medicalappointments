package com.api.tcc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JsonPropertyContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static String FILENAME = "AppConfig.json";

    @Override
    @SuppressWarnings("unchecked")
    public void initialize(ConfigurableApplicationContext applicationContext) {
        try {
            Resource resource = applicationContext.getResource("classpath:" + FILENAME);
            Map readValue = new ObjectMapper().readValue(resource.getInputStream(), Map.class);
            Set<Map.Entry> set = readValue.entrySet();
            List<MapPropertySource> propertySources = set.stream()
                    .map(entry -> new MapPropertySource(
                            entry.getKey().toString(),
                            Collections.singletonMap(
                                    entry.getKey().toString(), entry.getValue()
                            )))
                    .collect(Collectors.toList());

            for (PropertySource propertySource : propertySources) {
                applicationContext
                        .getEnvironment()
                        .getPropertySources()
                        .addFirst(propertySource);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
