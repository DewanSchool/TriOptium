package org.acme.application;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculatorTool {

    @Tool("Calculate percentage of a value")
    public String calculatePercentage(String input) {
        try {
            String[] parts = input.split(" of ");
            double percent = Double.parseDouble(parts[0].replace("%", "").trim());
            double value = Double.parseDouble(parts[1].trim());

            double result = (percent / 100) * value;

            return String.format("%.2f", result);
        } catch (Exception e) {
            return "Invalid input";
        }
    }
}
