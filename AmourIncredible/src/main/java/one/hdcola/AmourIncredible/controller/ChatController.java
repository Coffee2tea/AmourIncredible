package one.hdcola.AmourIncredible.controller;

import org.slf4j.Logger;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import one.hdcola.AmourIncredible.dto.ChatMessages;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ChatController {

    private final ChatClient chatClient;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ChatController.class);

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping("/api/chat")
    public Map<String, String> completion(@RequestBody ChatMessages messages) {
        List<Message> pMessages = messages.getMessages().stream()
                .map(message -> {
                    switch (message.getRole()) {
                        case "user":
                            return new UserMessage(message.getContent());
                        case "assistant":
                            return new AssistantMessage(message.getContent());
                        case "system":
                            return new SystemMessage(message.getContent());
                        default:
                            return new UserMessage("unknow role:" + message.getRole() + message.getContent());
                    }
                })
                .collect(Collectors.toList());
        Prompt prompt = new Prompt(pMessages);
        logger.info("prompt: {}", prompt.toString());
        return Map.of("generation", chatClient.call(prompt).getResult().getOutput().getContent());
    }
}
