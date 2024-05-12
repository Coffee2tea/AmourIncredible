package one.hdcola.AmourIncredible.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long scenarioId;
    private Long chatId;
    private Integer serial;
    private String role;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Transient
    private String assistantContent;
    @Transient
    private Integer mark;

    public ChatMessage(Long scenarioId, Long chatId, Integer serial, String role, String content) {
        this.scenarioId = scenarioId;
        this.chatId = chatId;
        this.serial = serial;
        this.role = role;
        this.content = content;
        extractAssistantContentAndMark();
    }

    private void extractAssistantContentAndMark() {
        if ("assistant".equals(role)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                TypeReference<AssistantContent> typeRef = new TypeReference<>() {
                };
                AssistantContent assistantContentObj = objectMapper.readValue(content, typeRef);
                this.assistantContent = assistantContentObj.getContent();
                this.mark = assistantContentObj.getMark();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Setter
    @Getter
    private static class AssistantContent {
        private String content;
        private Integer mark;
    }
}
