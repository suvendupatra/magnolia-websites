package com.hut.magnolia.saucisson.controller.paragraph;

import info.magnolia.cms.gui.dialog.DialogEdit;
import info.magnolia.cms.gui.dialog.DialogTab;
import info.magnolia.cms.util.AlertUtil;
import info.magnolia.module.blossom.annotation.Paragraph;
import info.magnolia.module.blossom.annotation.ParagraphDescription;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.TabValidator;
import info.magnolia.module.blossom.dialog.TabBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hut.magnolia.saucisson.controller.paragraph.form.ContactBean;
import com.hut.magnolia.saucisson.controller.paragraph.form.ContactValidator;
import com.hut.magnolia.saucisson.core.ModuleCore;
import com.hut.magnolia.saucisson.util.EmailSender;

/**
 * 
 * @author bruno.chauvet
 * 
 */
@Controller
@Paragraph(name = "contact-paragraph", value = "Contact Paragraph")
@ParagraphDescription("Adds a customizable Contact Form")
public class ContactParagraph {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactParagraph.class);

    @Autowired
    private ContactValidator contactValidator;

    @RequestMapping(value = "contactParagraph", method = RequestMethod.GET)
    public ModelAndView form() {
        ContactBean contactUsFormBean = new ContactBean();
        return new ModelAndView("contactParagraph", "contactUsFormBean", contactUsFormBean);
    }

    @RequestMapping(value = "contactParagraph", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("name") String name, @RequestParam("email") String email,
            @RequestParam("state") String state, @RequestParam("enquirytype") String enquirytype,
            @RequestParam("message") String message, HttpServletRequest request) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("name:" + name);
            LOGGER.debug("email:" + email);
            LOGGER.debug("state:" + state);
            LOGGER.debug("enquirytype:" + enquirytype);
            LOGGER.debug("message:" + message);
        }

        ContactBean fbean = new ContactBean();
        fbean.setName(name);
        fbean.setEmail(email);
        fbean.setState(state);
        fbean.setEnquiryType(enquirytype);
        fbean.setMessage(message);

        Errors errors = new BindException(fbean, "contactBean");
        contactValidator.validate(fbean, errors);

        if (errors.hasErrors()) {
            List<String> errorMessages = new ArrayList<String>();
            for (FieldError fieldError : errors.getFieldErrors()) {
                LOGGER.debug("getField:" + fieldError.getField());
                LOGGER.debug("defaultMessage:" + fieldError.getDefaultMessage());
                errorMessages.add(fieldError.getDefaultMessage());
            }
            return new ModelAndView("contactParagraph", "errorMessage", errorMessages);
        }

        Map<String, String> tv = new HashMap<String, String>();
        tv.put("personName", name);
        tv.put("email", email);
        tv.put("enquirytype", enquirytype);
        tv.put("state", state);
        tv.put("message", message);
        // Send the email
        try {
            // Read the output options from the module properties
            ModuleCore module = ModuleCore.getInstance();
            EmailSender.sendTemplateEmail("/com/hut/saucissons/emailTemplate.htm", tv, email, module.getContactEmail(),
                    module.getContactSubject(), "text/html");
        } catch (ServletException e) {
            LOGGER.error("Contact Us email failed:" + e.getMessage());
        }
        return new ModelAndView(new RedirectView("thanks"));
    }

    @TabFactory("Settings")
    public void createDialog(TabBuilder builder) {
        builder.addEdit("title", "Title", "");
        builder.addFckEditor("bodyText", "Text", "");
        builder.addEdit("errorMessage", "Error message", "Blank is not acceptable.");
    }

    @TabValidator("Settings")
    public void validate(DialogTab dialogTab) {
        DialogEdit title = (DialogEdit) dialogTab.getSub("title");
        if (StringUtils.isEmpty(title.getValue())) {
            AlertUtil.setMessage("You need to enter a title!");
        }
    }
}
