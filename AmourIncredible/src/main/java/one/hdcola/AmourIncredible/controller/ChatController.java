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

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;

import one.hdcola.AmourIncredible.dto.ChatMessageDto;
import one.hdcola.AmourIncredible.dto.ChatMessages;
import one.hdcola.AmourIncredible.service.ChatMessageService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ChatController {

    private final ChatClient chatClient;
    private ChatMessageService chatService;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ChatController.class);

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

    @PostMapping("/api/chats")
    public ResponseEntity<ChatMessageDto> request(@RequestBody ChatMessageDto chatMessage) {
        logger.info("request: {}", chatMessage.toString());
        ChatMessageDto createdChatMessage = chatService.request(chatMessage);
        return ResponseEntity.ok(createdChatMessage);
    }
}
