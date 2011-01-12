package com.hut.magnolia.saucisson.controller.paragraph;

import info.magnolia.module.blossom.annotation.DialogFactory;
import info.magnolia.module.blossom.annotation.Paragraph;
import info.magnolia.module.blossom.annotation.ParagraphDescription;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.dialog.TabBuilder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller defining a Simple Paragraph.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "saucisson-simple-paragraph", value = "Saucisson Simple Paragraph", dialog = "saucisson-simple-dialog")
@ParagraphDescription("Simple Paragraph with title, text, description, image and link")
@DialogFactory("saucisson-simple-dialog")
@Controller
public class SimpleParagraph {
    private final static Map<String, String> imagePositions = new HashMap<String, String>();
    static {
        SimpleParagraph.imagePositions.put("Left", "left");
        SimpleParagraph.imagePositions.put("Right", "right");
        SimpleParagraph.imagePositions.put("Center", "center");
    }

    /**
     * Process the requests on URL /simpleParagraph
     * 
     * @return
     */
    @RequestMapping("/simpleParagraph")
    public ModelAndView handleRequest() {
        return new ModelAndView();
    }

    /**
     * First Dialog Tab.
     * 
     * @param tab
     */
    @TabFactory("Content")
    public void content(TabBuilder tab) {
        tab.addStatic("Title, image and description of the paragraph");
        tab.addEdit("title", "Title", "").setConfig("i18n", true);
        tab.addFile("image", "Image", "Image 100 x 70 px");
        tab.addSelect("imagePosition", "Image Position", "", SimpleParagraph.imagePositions);
        tab.addFckEditor("description", "Description", "").setConfig("i18n", true);
        tab.addEdit("extraClass", "Extra CSS class", "");
    }
}
