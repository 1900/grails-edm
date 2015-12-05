package com.funtime.edm

import grails.transaction.Transactional
import groovy.transform.Synchronized
import org.springframework.web.context.request.RequestContextHolder
import java.util.*

@Transactional
class SendMailLogService {
    def list() {

    }

    @Synchronized
    def save(def status,def mailTo,def mailFrom,def logdesc){
        def sendlogInstance = new Report("status":status,"mailTo":mailTo,"mailFrom":mailFrom,"logDesc":logdesc,dateCreated: new Date())
        if (!sendlogInstance.save(flush: true)) {
            return ["success": false, "errorMsg": "Failure!"]
        }
        return ["success": true]
    }
}
