package com.hr_handlers.chat.repository;

import com.hr_handlers.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>, ChatCustomRepository {
}
