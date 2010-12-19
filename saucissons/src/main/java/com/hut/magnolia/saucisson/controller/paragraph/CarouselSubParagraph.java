package com.hut.magnolia.saucisson.controller.paragraph;

import info.magnolia.module.blossom.annotation.DialogFactory;
import info.magnolia.module.blossom.annotation.Paragraph;
import info.magnolia.module.blossom.annotation.ParagraphDescription;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.dialog.TabBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Paragraph(name = "carousel-sub-paragraph", value = "Carousel Sub Paragraph", dialog = "carousel-sub-dialog")
@ParagraphDescription("Carousel Sub Paragraph to display an image and text in the carousel")
@DialogFactory("carousel-sub-dialog")
@Controller
public class CarouselSubParagraph {
    /**
     * Process the requests on URL /carouselSubParagraph
     * 
     * @return
     */
    @RequestMapping("/carouselSubParagraph")
    public ModelAndView carouselSubParagraph() {
        return new ModelAndView();
    }

    /**
     * Dialog Tab.
     * 
     * @param tab
     */
    @TabFactory("Carousel Element")
    public void content(TabBuilder tab) {
        tab.addStatic("Carousel Image and Text");
        tab.addFile("image", "Image", "Size: 400 x 250");
        tab.addFckEditor("description", "Text", "").setConfig("i18n", true);
    }
}
