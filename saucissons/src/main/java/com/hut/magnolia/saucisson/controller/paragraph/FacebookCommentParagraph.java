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
 * Controller defining a Facebook Comment Paragraph.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "facebook-comment-paragraph", value = "Facebook Comment Paragraph", dialog = "facebook-comment-dialog")
@ParagraphDescription("Facebook Comment paragraph to display a comment box linked with user's facebook account")
@DialogFactory("facebook-comment-dialog")
@Controller
public class FacebookCommentParagraph {
    /**
     * Process the requests on URL /facebookCommentParagraph
     * 
     * @return
     */
    @RequestMapping("/facebookCommentParagraph")
    public ModelAndView facebookCommentParagraph() {
        return new ModelAndView();
    }

    /**
     * Dialog Tab.
     * 
     * @param tab
     */
    @TabFactory("Facebook Application")
    public void content(TabBuilder tab) {
        tab.addStatic("Facebook Application ID");
        tab.addEdit("applicationID", "Application ID", "");
        tab.addEdit("title", "Comment title", "").setConfig("i18n", true);
    }
}
