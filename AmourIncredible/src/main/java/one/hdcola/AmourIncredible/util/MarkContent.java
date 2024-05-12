package one.hdcola.AmourIncredible.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MarkContent {
    private String content;
    private Integer mark;
    private String assistantContent;

    public MarkContent(String assistantContent) {
        this.assistantContent = assistantContent;
        extractAssistantContentAndMark();
    }

    private void extractAssistantContentAndMark() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<AssistantContent> typeRef = new TypeReference<>() {
            };
            AssistantContent assistantContentObj = objectMapper.readValue(assistantContent, typeRef);
            this.content = assistantContentObj.getContent();
            this.mark = assistantContentObj.getMark();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Setter
    @Getter
    private static class AssistantContent {
        private String content;
        private Integer mark;
    }
}