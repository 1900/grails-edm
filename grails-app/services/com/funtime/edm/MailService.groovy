package com.funtime.edm

import grails.transaction.Transactional

import javax.mail.Message
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import java.util.*

@Transactional
class MailService {
    SendMailLogService sendMailLogService

    def sendMailCommm(String smtphost, String from, String password, String to, int port, String subject, String body) {
        Properties props = System.getProperties()
        props.put("mail.smtp.starttls.enable", true)
        /* mail.smtp.ssl.trust is needed in script to avoid error "Could not convert socket to TLS"  */
        props.setProperty("mail.smtp.ssl.trust", smtphost)
        props.put("mail.smtp.auth", true)
        props.put("mail.smtp.host", smtphost)
        props.put("mail.smtp.user", from)
        props.put("mail.smtp.password", password)
        props.put("mail.smtp.port", port)

        try {
            Session session = Session.getDefaultInstance(props, null)
            MimeMessage message = new MimeMessage(session)
            message.setFrom(new InternetAddress(from))

            InternetAddress toAddress = new InternetAddress(to)

            message.addRecipient(Message.RecipientType.TO, toAddress)

            message.setSubject(subject)
//        message.setText(body);
            message.setText(body, "utf-8", "html")
//        message.setContent(body, "text/html")
            Transport transport = session.getTransport("smtp")

            transport.connect(smtphost, from, password)

            transport.sendMessage(message, message.getAllRecipients())

            transport.close()

            def email = Mail.findByAccount(to)
            email.status = 0
            email.save()

            sendMailLogService.save("Send success: ", to, from, from + "send to " + to + "success!")

        } catch (Exception e) {
            e.printStackTrace()
            sendMailLogService.save("Failed to send: ", to, from, from + "send to " + to + "failed!")

        }


    }
}
