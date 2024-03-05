package org.example.Repository

import org.example.entity.User
import org.example.struct.UserState
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface JpaUserRepository: JpaRepository<User, Long> {
    @Transactional
    fun getByChatId(chatId: Long): User
}