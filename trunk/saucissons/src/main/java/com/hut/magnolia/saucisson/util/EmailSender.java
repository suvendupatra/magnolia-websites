package com.hut.magnolia.saucisson.util;

import info.magnolia.module.ModuleRegistry;
import info.magnolia.module.mail.MailModule;
import info.magnolia.module.mail.MailTemplate;
import info.magnolia.module.mail.MgnlMailFactory;
import info.magnolia.module.mail.templates.MgnlEmail;

import java.util.Map;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

    /**
     * Send an email using a freemarker template
     * 
     * @param emailTemplateLocation
     * @param templateValues
     * @param from
     * @param toList
     * @param subject
     * @throws ServletException
     */
    public static void sendTemplateEmail(String emailTemplateLocation, Map<String, String> templateValues, String from,
            String toList, String subject, String contentType) throws ServletException {

        MgnlMailFactory mailFactory = ((MailModule) ModuleRegistry.Factory.getInstance().getModuleInstance("mail"))
                .getFactory();
        try {
            templateValues.put(MailTemplate.MAIL_TEMPLATE_FILE, emailTemplateLocation);

            MgnlEmail mail = mailFactory.getEmailFromType(templateValues, "freemarker");
            mail.setFrom(from);
            mail.setToList(toList);
            mail.setSubject(subject);
            mail.setBodyFromResourceFile();
            mail.setReplyToList(from);

            mail.setContent(mail.getContent(), contentType);

            mailFactory.getEmailHandler().prepareAndSendMail(mail);
        } catch (Exception e) {
            LOGGER.debug("e.message:" + e.getMessage());
            e.printStackTrace();
            throw new ServletException("Error sending email:", e);
        }
    }
}
