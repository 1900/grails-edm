package com.funtime.edm

import grails.transaction.Transactional

@Transactional
class SendMailService {
    MailService mailService

    def send() {
        def data = EmailAccount.findByEmailStatus(1)

        if (data != null) {
//             Set email address
            def emailTo = Mail.list([max: 10])

//            load html template
            def htmlContent = new File("web-app/template/indexTemplate.html").text
            emailTo.each {
//                Call function
                mailService.sendMailCommm(data.smtp, data.userName, data.passWord, it.account, data.port, "TITLE", htmlContent)
            }

            data.emailStatus = 0
            data.save()

        } else {
//            update emailStatus = 1
            def allData = EmailAccount.findAll()
            allData.each {
                def p = EmailAccount.get(it.id.toString())
                p.emailStatus = 1
                p.save(flush: true)
            }
        }


    }
}
