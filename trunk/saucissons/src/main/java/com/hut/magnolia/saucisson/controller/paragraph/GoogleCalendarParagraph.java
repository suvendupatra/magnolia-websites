package com.hut.magnolia.saucisson.controller.paragraph;

import info.magnolia.module.blossom.annotation.DialogFactory;
import info.magnolia.module.blossom.annotation.Paragraph;
import info.magnolia.module.blossom.annotation.ParagraphDescription;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.dialog.TabBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller defining a Google Calendar Paragraph.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "google-calendar-paragraph", value = "Google Calendar Paragraph", dialog = "google-calendar-dialog")
@ParagraphDescription("Google Calendar to display on the page. Must refer to an existing Google Calendar.")
@DialogFactory("google-calendar-dialog")
@Controller
public class GoogleCalendarParagraph {
    /**
     * Process the requests on URL /googleCalendarParagraph
     * 
     * @return
     */
    @RequestMapping("/googleCalendarParagraph")
    public ModelAndView googleCalendarParagraph() {
        return new ModelAndView();
    }

    /**
     * Dialog Tab.
     * 
     * @param tab
     */
    @TabFactory("Google Calendar")
    public void content(TabBuilder tab) {
        tab.addStatic("Google Calendar");
        tab.addEdit("title", "Title", "").setConfig("i18n", true);
        tab.addEdit("bgColor", "Background Color", "");
        tab.addEdit("fontColor", "Font Color", "");
        tab.addEdit("src", "Source Calendar", "");
        tab.addEdit("width", "Calendar Width", "");
        tab.addEdit("height", "Calendar Height", "");
        tab.addCheckbox("showTitle", "Display Calendar Title", "");
    }
}
