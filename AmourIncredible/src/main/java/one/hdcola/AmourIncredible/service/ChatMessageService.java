package one.hdcola.AmourIncredible.service;

import java.util.List;

import one.hdcola.AmourIncredible.dto.ChatMessageDto;

public interface ChatMessageService {
    ChatMessageDto request(ChatMessageDto chatMessageDto);

    List<ChatMessageDto> getAll(Long scenarioId, Long chatId);
}
