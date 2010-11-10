package com.hut.magnolia.saucisson.controller.paragraph;

import java.util.HashMap;
import java.util.Map;

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
@Paragraph(name = "facebook-like-paragraph", value = "Facebook Like Paragraph", dialog = "facebook-like-dialog")
@ParagraphDescription("Facebook Like paragraph to display a like button linked with user's facebook account")
@DialogFactory("facebook-like-dialog")
@Controller
public class FacebookLikeParagraph {
    private final static Map<String, String> fonts = new HashMap<String, String>();
    static {
        FacebookLikeParagraph.fonts.put("Arial", "arial");
        FacebookLikeParagraph.fonts.put("Lucia Grande", "lucida grande");
        FacebookLikeParagraph.fonts.put("Segoe UI", "segoe ui");
        FacebookLikeParagraph.fonts.put("Tahoma", "tahoma");
        FacebookLikeParagraph.fonts.put("Trebuchet MS", "trebuchet ms");
        FacebookLikeParagraph.fonts.put("Verdana", "verdana");
    }

    private final static Map<String, String> schemes = new HashMap<String, String>();
    static {
        FacebookLikeParagraph.schemes.put("Light", "light");
        FacebookLikeParagraph.schemes.put("Dark", "dark");
    }

    /**
     * Process the requests on URL /facebookLikeParagraph
     * 
     * @return
     */
    @RequestMapping("/facebookLikeParagraph")
    public ModelAndView facebookLikeParagraph() {
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
        tab.addLink("url", "Page to link to the Like Button", "Leave empty if refers to current page");
        tab.addEdit("title", "Like title", "");
        tab.addSelect("font", "Font", "", FacebookLikeParagraph.fonts);
        tab.addSelect("scheme", "Color Scheme", "", FacebookLikeParagraph.schemes);
    }
}
