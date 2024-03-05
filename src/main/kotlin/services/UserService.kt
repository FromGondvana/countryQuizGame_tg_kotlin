package org.example.services

import org.example.Repository.JpaUserRepository
import org.example.entity.User
import org.example.struct.UserState
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: JpaUserRepository) {

    fun save(user: User): Boolean{
        if(isHasCheck(user))
            return false
        else{
            userRepository.save(user)
            if(isHasCheck(user))
                return true
            else false
        }
        return false
    }

    fun isHasCheck(chatId: Long): Boolean{
        if(getSize() != 0){
            if(userRepository.getByChatId(chatId) != null)
                return true
        }
        return false
    }

    fun isHasCheck(user: User): Boolean{
        if(userRepository.getByChatId(user.chatId) != null)
            return true
        else
            return false
    }

    fun getSize(): Int{
        return userRepository.findAll().size
    }

    fun getState(chatId: Long): UserState{
        if(getSize() !=0 ){
            val user: User = userRepository.getByChatId(chatId)
            val stateInd: Int = user.stateInd
            return UserState.valueOf(stateInd.toString())
        }
        return UserState.NOT_STATE
    }
}