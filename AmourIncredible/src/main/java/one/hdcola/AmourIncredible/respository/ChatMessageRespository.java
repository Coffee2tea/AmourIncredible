package one.hdcola.AmourIncredible.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.hdcola.AmourIncredible.entity.ChatMessage;

public interface ChatMessageRespository extends JpaRepository<ChatMessage, Long> {

}