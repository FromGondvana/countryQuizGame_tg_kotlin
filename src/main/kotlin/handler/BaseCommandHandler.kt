package org.example.handler

import org.example.Repository.JpaUserRepository
import org.example.services.UserService
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class BaseCommandHandler(val service: UserService) {
    //val userService: UserService = UserService(userRepository = JpaUserRepository<User, >);
    //private val userRepository: JpaUserRepository
    fun handle(upd: Update):SendMessage{
        val responseMessage: SendMessage
        val textMsg: String = upd.message.text
        val chatId: Long = upd.message.chatId
        if(textMsg == "/stop"){
            val size: Int = service.getSize()
            println(size)
            responseMessage = SendMessage.builder()
                .text("/stop IS PUSH!!! ___ Size useer list = " + size)
                .chatId(upd.message.chatId)
                .build()}
        else if(textMsg == "/version")
            responseMessage = SendMessage.builder()
                .text("--version app push\nalpha version")
                .chatId(upd.message.chatId)
                .build()
        else if(textMsg == "/start") {
            val bo: Boolean = service.isHasCheck(chatId)
            responseMessage = SendMessage.builder()
                .text("/start IS PUSH!!! --- Has your id in list?= " + bo)
                .chatId(upd.message.chatId)
                .build()
        }
        else
            responseMessage = SendMessage.builder()
                .text("COMMAND NOT FOUND")
                .chatId(upd.message.chatId)
                .build()
        return responseMessage
    }
}