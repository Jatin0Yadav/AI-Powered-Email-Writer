package com.email.writer.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class EmailGeneratorService {

    private final WebClient webClientBuilder;

    @Value("${gemini.api.url}")     // to access values from the env variables
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;


    public EmailGeneratorService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder.build();
    }


    public String generateEmailReply(EmailRequest emailRequest){
        // Build the prompt
        String prompt = buildPrompt(emailRequest);

        // Craft a request
        Map<String, Object> requestBody = Map.of(
                "contents", java.util.List.of(
                        Map.of(
                                "parts", java.util.List.of(
                                        Map.of("text", prompt)
                                )
                        )
                )
        );

        // Do request and get response
        String response = webClientBuilder.post()
                .uri(geminiApiUrl)
                .header("Content-Type", "application/json")
                .header("X-goog-api-key", geminiApiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();


        // Return response
        return extractResponseContent(response);


    }

    private String extractResponseContent(String response) {
        try {
            // mapper comes from jackson.
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)     // first item of the candidates array
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asString();
        }

        catch (Exception e) {
            return "Error processing request: " + e.getMessage();
        }
    }

    // just building the prompt
    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content. Please don't generate a subject line");

        if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a ").append(emailRequest.getTone()).append(" tone. ");
        }

        prompt.append("\nOriginal Email: \n").append(emailRequest.getEmailContent());

        return prompt.toString();
    }

}
