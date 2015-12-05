package com.funtime.edm
import org.bson.types.ObjectId

class Mail {
    ObjectId id
    String account
    String mailDesc

    int status = 1 // 1 -Normal, 0 -Failure
    int mailType // 1 -Abroad, 0 -Domestic

//    Date dateCreated
//    Date lastUpdate

    static mapping = {
        version false
    }

    static constraints = {
    }

    static mapWith = "mongo"

}