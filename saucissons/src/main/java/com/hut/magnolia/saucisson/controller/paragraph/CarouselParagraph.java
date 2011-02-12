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
 * Controller defining a Carousel Paragraph.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "carousel-paragraph", value = "Carousel Paragraph", dialog = "carousel-dialog")
@ParagraphDescription("Carousel Paragraph to display images and text in an animated carousel")
@DialogFactory("carousel-dialog")
@Controller
public class CarouselParagraph {
    private final static Map<String, String> transitionSpeeds = new HashMap<String, String>();
    private final static Map<String, String> displayTime = new HashMap<String, String>();

    static {
        CarouselParagraph.transitionSpeeds.put("Fast", "500");
        CarouselParagraph.transitionSpeeds.put("Medium", "1000");
        CarouselParagraph.transitionSpeeds.put("Slow", "1500");

        CarouselParagraph.displayTime.put("1 sec", "1000");
        CarouselParagraph.displayTime.put("5 sec", "5000");
        CarouselParagraph.displayTime.put("10 sec", "10000");
        CarouselParagraph.displayTime.put("20 sec", "20000");
    }

    /**
     * Process the requests on URL /carouselParagraph
     * 
     * @return
     */
    @RequestMapping("/carouselParagraph")
    public ModelAndView carouselParagraph() {
        return new ModelAndView();
    }

    /**
     * Dialog Tab.
     * 
     * @param tab
     */
    @TabFactory("Carousel")
    public void content(TabBuilder tab) {
        tab.addStatic("Carousel parameters");
        tab.addEdit("title", "Title", "").setConfig("i18n", true);
        tab.addSelect("transitionSpeed", "Image transition speed", "", transitionSpeeds);
        tab.addSelect("displayTime", "Image display time", "", displayTime);
        tab.addCheckbox("displayThumbnails", "Display images thumbnails", "");
    }
}
