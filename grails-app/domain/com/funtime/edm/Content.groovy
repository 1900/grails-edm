package com.funtime.edm

import org.bson.types.ObjectId

class Content {
    ObjectId id
    String title
    String mailContent
    String templateName
    int projectId
    String projectName
    Date expiredDate

    Date dateCreated
    Date lastUpdate

    static mapping = {
        version false
        mailContent type: 'text'
    }

    static constraints = {
    }

    static mapWith = "mongo"

}