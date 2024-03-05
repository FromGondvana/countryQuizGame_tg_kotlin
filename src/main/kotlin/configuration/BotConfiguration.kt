package org.example.configuration

import org.example.Repository.JpaUserRepository
import org.example.bot.Bot
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
@EnableJpaRepositories
open class BotConfiguration {
    @Bean
    open fun telegramBotsApi(bot: Bot): TelegramBotsApi{
        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
        telegramBotsApi.registerBot(bot)
        return telegramBotsApi
    }
}