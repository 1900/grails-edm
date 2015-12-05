package com.funtime.edm
import org.bson.types.ObjectId

class Report {
    ObjectId id
    String mailTo
    String mailFrom
    String status
    String logDesc
//    Date sendDate

    Date dateCreated

    static mapping = {
        version false
    }

    static constraints = {
    }

    static mapWith = "mongo"

}