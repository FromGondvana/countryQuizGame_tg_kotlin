package org.example.bot

import java.io.FileInputStream
import java.util.*

class Login(val key: String){
    val field: String;
    init {
        val pathLoginProperty = "src/main/resources/test_login.properties"
        val fis: FileInputStream
        fis = FileInputStream(pathLoginProperty)
        val property = Properties();
        property.load(fis)

        if(key == "username" || key == "token")
            field = property.getProperty(key)
        else {
            println("HAS NOT DATA in LOGIN class")
            field = "HAS NOT DATA"
        }
    }
}
/*class Login(val key: String) {
    val pathLoginProperty = "src/main/resources/test_login.properties"
    val fis: FileInputStream = FileInputStream(pathLoginProperty)
    val property = Properties()
    //val n: String = property.getProperty("username")
    //val t: String = property.getProperty("token")
    fun get(text: String): String{
        property.load(fis)
        val resp: String = property.getProperty(text)
        return resp
    }

}*/