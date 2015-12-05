import com.funtime.edm.EmailAccount
import com.funtime.edm.Mail
import grails.converters.JSON
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.hibernate.validator.constraints.Email

class BootStrap {
    GrailsApplication grailsApplication

    def init = { servletContext ->
        if (EmailAccount.count() == 0) {
            new EmailAccount(userName: "test1@gmail.com", nickName: "test1", passWord: "password", ssl: 1, smtp: "smtp.gmail.com", pop3: "pop3.gmail.com", emailStatus: 1, port: 465).save()
            new EmailAccount(userName: "test2@gmail.com", nickName: "test2", passWord: "password", ssl: 1, smtp: "smtp.gmail.com", pop3: "pop3.gmail.com", emailStatus: 1, port: 465).save()

        }
        if (Mail.count() == 0){
            new Mail(account: "abc@gmail.com",mailDesc: "mail desc",mailType: 1,status: 1).save()
        }


    }
    def destroy = {
    }
}
