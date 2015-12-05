package com.funtime.edm

import org.bson.types.ObjectId

class EmailAccount {
    ObjectId id
    String userName
    String nickName
    String passWord
    int ssl = 0 //0 -close,1-open
    String smtp
    String pop3
    int port
    int emailStatus = 1 // 1 -normal ,0- run out

//    Date dateCreated
//    Date lastUpdate

    static mapping = {
        version false
    }

    static constraints = {
    }

    static mapWith = "mongo"

}