package one.hdcola.AmourIncredible.mapper;

import java.util.List;
import java.util.stream.Collectors;

import one.hdcola.AmourIncredible.dto.ChatMessageDto;
import one.hdcola.AmourIncredible.entity.ChatMessage;

public class ChatMessageMapper {
    public static ChatMessage toEntity(ChatMessageDto chatMessageDto) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setId(chatMessageDto.getId());
        chatMessage.setScenarioId(chatMessageDto.getScenarioId());
        chatMessage.setChatId(chatMessageDto.getChatId());
        chatMessage.setSerial(chatMessageDto.getSerial());
        chatMessage.setRole(chatMessageDto.getRole());
        chatMessage.setContent(chatMessageDto.getContent());
        return chatMessage;
    }

    public static ChatMessageDto toDto(ChatMessage chatMessage) {
        ChatMessageDto chatMessageDto = new ChatMessageDto();
        chatMessageDto.setId(chatMessage.getId());
        chatMessageDto.setScenarioId(chatMessage.getScenarioId());
        chatMessageDto.setChatId(chatMessage.getChatId());
        chatMessageDto.setSerial(chatMessage.getSerial());
        chatMessageDto.setRole(chatMessage.getRole());
        chatMessageDto.setContent(chatMessage.getContent());
        return chatMessageDto;
    }

    public static List<ChatMessageDto> toDtoList(List<ChatMessage> chatMessages) {
        return chatMessages.stream().map(ChatMessageMapper::toDto).collect(Collectors.toList());
    }
}
