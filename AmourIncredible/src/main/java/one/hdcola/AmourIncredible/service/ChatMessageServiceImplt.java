package one.hdcola.AmourIncredible.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;

import lombok.AllArgsConstructor;
import one.hdcola.AmourIncredible.dto.ChatMessageDto;
import one.hdcola.AmourIncredible.respository.ChatMessageRespository;
import one.hdcola.AmourIncredible.util.MarkContent;

@AllArgsConstructor
@Service
public class ChatMessageServiceImplt implements ChatMessageService {
    private final ChatClient chatClient;
    private static final Logger logger = LoggerFactory.getLogger(ChatMessageServiceImplt.class);
    private ChatMessageRespository chatMessageRespository;

    @Override
    public ChatMessageDto request(ChatMessageDto chatMessageDto) {
        Message system = new SystemMessage(
                "Next you will play a girlfriend who wants to go to the movies tonight and has bought tickets. And I want to play a game with my friend.\n\n\nYour reply will be JSON fomat:{'content':string,'mark':int}. content for your reply, which will only be a simple everyday conversation. mark for your happy status of my reply, with negative numbers being unhappy and positive numbers being happy.");
        Message message = new UserMessage(chatMessageDto.getContent());
        Prompt prompt = new Prompt(List.of(system, message));
        logger.info("prompt: {}", prompt.toString());
        String response = chatClient.call(prompt).getResult().getOutput().getContent();

        MarkContent markContent = new MarkContent(response);
        return new ChatMessageDto(chatMessageDto.getId(), chatMessageDto.getScenarioId(), chatMessageDto.getChatId(),
                chatMessageDto.getSerial(), "assistant", markContent.getContent(), markContent.getMark());
    }

    @Override
    public List<ChatMessageDto> getAll(Long scenarioId, Long chatId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
