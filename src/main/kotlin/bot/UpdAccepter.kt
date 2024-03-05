package org.example.bot

import org.example.Repository.JpaUserRepository
import org.example.handler.BaseCommandHandler
import org.example.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class UpdAccepter(userRepository: JpaUserRepository){
    //val userRepository: JpaUserRepository
    val userService: UserService

    init {
        //this.userRepository = userRepository
        //userService = UserService(this.userRepository)
        userService = UserService(userRepository)
    }
    fun accept(upd: Update): SendMessage{
        println("UPDATE")
        if(!upd.hasCallbackQuery() && upd.message.hasText())
            return BaseCommandHandler(userService).handle(upd)
        else
            return (SendMessage.builder()
            .text("IS NOT TO HANDLE")
            .chatId(upd.message.chatId)
            .build())
    }
}