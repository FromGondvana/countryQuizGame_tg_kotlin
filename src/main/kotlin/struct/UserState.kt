package org.example.struct

enum class UserState(val num: Int) {
    NOT_STATE(0), MAIN(1), CHOICE_MOD(2), IN_GAME(3), HELPFUL(4);

    fun index(state: UserState): Int{
        return state.num
    }
}