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
 * Controller defining a Nested Paragraph.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "saucisson-nested-paragraph", value = "Saucisson Nested Paragraph", dialog = "saucisson-nested-dialog")
@ParagraphDescription("Nested Paragraph with a title and a list of links")
@DialogFactory("saucisson-nested-dialog")
@Controller
public class NestedParagraph {
    @RequestMapping("/nestedParagraph")
    public ModelAndView handleRequest() {
        return new ModelAndView();
    }

    @TabFactory("Content")
    public void content(TabBuilder tab) {
        tab.addStatic("Title, Title of the paragraph");
        tab.addEdit("title", "Title", "Main title").setConfig("i18n", true);
    }
}
