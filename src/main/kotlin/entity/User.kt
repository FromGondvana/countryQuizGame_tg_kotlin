package org.example.entity

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.AccessType

@Entity
@Table(name = "users")
class User(chatId: Long) {
    @Id
    @Column(name = "chat_id", unique = true, nullable = false)
    var chatId: Long
        get() = field

    @Column(name = "state_index")
    var stateInd: Int = 1
        get() = field
        set(value){
            if(value > 0 && value < 10)
                field = value
            else
                field = 0;
        }
    @Column(name = "has_game_session")
    var isHasGameSession: Boolean = false
        get() = field
        set(value){
            field = value
        }

    init {
        this.chatId = chatId
        stateInd = 1
        isHasGameSession = false
    }
}