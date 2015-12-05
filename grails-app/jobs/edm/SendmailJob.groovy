package edm

import com.funtime.edm.SendMailService

class SendmailJob {
    SendMailService sendMailService

    static triggers = {
        simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        // execute job
        sendMailService.send()

    }
}
