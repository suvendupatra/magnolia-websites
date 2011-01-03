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
 * Controller defining a Nested SubParagraph.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "saucisson-nested-sub-paragraph", value = "Saucisson Nested SubParagraph", dialog = "saucisson-nested-sub-dialog")
@ParagraphDescription("Nested SubParagraph with title and links")
@DialogFactory("saucisson-nested-sub-dialog")
@Controller
public class NestedSubParagraph {
    @RequestMapping("/nestedSubParagraph")
    public ModelAndView handleRequest() {
        return new ModelAndView();
    }

    @TabFactory("Content")
    public void content(TabBuilder tab) {
        tab.addStatic("Title, Title of the paragraph");
        tab.addEdit("text", "Text", "Text").setConfig("i18n", true);
        tab.addLink("link", "Link", "Link");
    }
}
