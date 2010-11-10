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
 * Controller defining the Header paragraph and dialog.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "saucisson-header-paragraph", value = "Saucisson Header Paragraph", dialog = "saucisson-header-dialog")
@ParagraphDescription("Saucisson Header Paragraph")
@DialogFactory("saucisson-header-dialog")
@Controller
public class HeaderParagraph {
    /**
     * Process the requests on URL /headerParagraph
     * 
     * @return
     */
    @RequestMapping("/headerParagraph")
    public ModelAndView handleRequest() {
        return new ModelAndView();
    }

    /**
     * Tabs of the Header Paragraph.
     * 
     * @param tab
     */
    @TabFactory("Header")
    public void content(TabBuilder tab) {
        tab.addStatic("Header paragraph");
        // Logo image
        tab.addFile("logo", "Logo", "Logo Image (about 120 x 100 px)");
        // Header text
        tab.addEdit("text", "Header Text", "Header Text (about 60 characters)");
    }
}
