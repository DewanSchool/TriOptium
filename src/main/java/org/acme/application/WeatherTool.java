package org.acme.application;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WeatherTool {

    @Tool("Get current weather")
    public String getCurrentWeather(String city) {
        return "It is sunny in " + city;
    }
}
