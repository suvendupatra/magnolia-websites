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
 * Controller defining a Youtube Video Paragraph.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "youtube-paragraph", value = "Youtube Paragraph", dialog = "youtube-dialog")
@ParagraphDescription("Youtube Paragraph to display a Youtube video")
@DialogFactory("youtube-dialog")
@Controller
public class YoutubeParagraph {
    /**
     * Process the requests on URL /youtubeParagraph
     * 
     * @return
     */
    @RequestMapping("/youtubeParagraph")
    public ModelAndView youtubeParagraph() {
        return new ModelAndView();
    }

    /**
     * Dialog Tab.
     * 
     * @param tab
     */
    @TabFactory("Youtube")
    public void content(TabBuilder tab) {
        tab.addStatic("Youtube parameters");
        tab.addEdit("title", "Title", "").setConfig("i18n", true);
        tab.addEdit("video", "Video Reference", "Video reference located in the Youtube video URL");
    }
}
