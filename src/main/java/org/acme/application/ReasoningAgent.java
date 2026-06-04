package org.acme.application;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(
        tools = {
                CalculatorTool.class,
                WeatherTool.class
        }
)
public interface ReasoningAgent {

    @SystemMessage("""
        You are a helpful assistant.
        Use available tools whenever necessary.
    """)
    String chat(@UserMessage String userMessage);
}