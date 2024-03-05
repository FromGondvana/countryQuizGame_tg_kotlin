package org.example.bot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class Bot(botToken: String = Login("token").field, updAccepter: UpdAccepter) : TelegramLongPollingBot(botToken) {
    val updAccepter: UpdAccepter

    init {
        this.updAccepter = updAccepter
    }

    override fun getBotUsername(): String = Login("username").field

    override fun onUpdateReceived(upd: Update) {
        if(upd.hasMessage() || upd.hasCallbackQuery()){
            execute(updAccepter.accept(upd))
        }
    }
}