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
 * Controller defining an Image Paragraph.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "image-paragraph", value = "Image Paragraph", dialog = "image-dialog")
@ParagraphDescription("Image paragraph")
@DialogFactory("image-dialog")
@Controller
public class ImageParagraph {
    private final static Map<String, String> imagePositions = new HashMap<String, String>();
    static {
        ImageParagraph.imagePositions.put("Left", "left");
        ImageParagraph.imagePositions.put("Right", "right");
        ImageParagraph.imagePositions.put("Center", "center");
    }

    /**
     * Process the requests on URL /imageParagraph
     * 
     * @return
     */
    @RequestMapping("/imageParagraph")
    public ModelAndView imageParagraph() {
        return new ModelAndView();
    }

    /**
     * Dialog Tab.
     * 
     * @param tab
     */
    @TabFactory("Image")
    public void content(TabBuilder tab) {
        tab.addStatic("Image to display");
        tab.addEdit("imageName", "Name", "Text to be displayed on mouse hover").setConfig("i18n", true);
        tab.addFile("image", "Image", "Image 100 x 70 px");
        tab.addSelect("imagePosition", "Image Position", "", ImageParagraph.imagePositions);
    }
}
