package one.hdcola.AmourIncredible.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDto {
    private Long id;
    private Long scenarioId;
    private Long chatId;
    private Integer serial;
    private String role;
    private String content;
    private Integer mark;
}
