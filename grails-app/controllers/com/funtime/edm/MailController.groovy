package com.funtime.edm

import com.funtime.edm.*
import java.io.*
import java.util.*

class MailController {
    MailService mailService
    SendMailLogService sendMailLogService

    def index() {}

    def sendMail() {
        def data = EmailAccount.findByEmailStatus(1)

        if (data != null) {
            ///* Set email address */
            //load html template
            def htmlContent = new File("web-app/template/indexTemplate.html").text
            def emailTo = Mail.list([max: 10])

            emailTo.each {
                ///*Call function */
                mailService.sendMailCommm(data.smtp, data.userName, data.passWord, it.account, data.port, "TITLE", htmlContent)

            }

            data.emailStatus = 0
            data.save()

        } else {
            //update emailStatus = 1
            def allData = EmailAccount.findAll()
            allData.each {
                def p = EmailAccount.get(it.id.toString())
                p.emailStatus = 1
                p.save(flush: true)
            }
        }

    }

    def loadeMail() {
        def filePath = "C://Users//Steven//Desktop//test.txt"

        new File(filePath).eachLine { line ->
            def mailType
            if (line.indexOf(".gmail.com") >= 0 && line.indexOf(".yahoo") >= 0 && line.indexOf(".aol.com") >= 0 && line.indexOf(".hotmail.com") >= 0) {
                mailType = 0
            } else {
                mailType = 1
            }

            new Mail(account: line, mailDesc: "xxx desc", mailType: mailType, status: 1).save()
        }

    }
}
