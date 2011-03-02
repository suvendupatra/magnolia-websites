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

import com.hut.magnolia.saucisson.controller.paragraph.CarouselParagraph;

/**
 * Controller defining a Google Map Paragraph.
 * 
 * @author bruno.chauvet
 * 
 */
@Paragraph(name = "gmap-paragraph", value = "Google Map Paragraph", dialog = "gmap-dialog")
@ParagraphDescription("Google Map frame")
@DialogFactory("gmap-dialog")
@Controller
public class GMapParagraph {
    private final static Map<String, String> height = new HashMap<String, String>();
    private final static Map<String, String> width = new HashMap<String, String>();

    static {
        GMapParagraph.height.put("200px", "200");
        GMapParagraph.height.put("350px", "350");
        GMapParagraph.height.put("500px", "500");
        
        GMapParagraph.width.put("250px", "250");
        GMapParagraph.width.put("400px", "400");
        GMapParagraph.width.put("550px", "550");
    }

    /**
     * Process the requests on URL /gmapParagraph
     * 
     * @return
     */
    @RequestMapping("/gmapParagraph")
    public ModelAndView gmapParagraph() {
        return new ModelAndView();
    }

    @TabFactory("Map")
    public void content(TabBuilder tab) {
        tab.addStatic("Details of the Google Map frame");
        tab.addEdit("title", "Title", "").setConfig("i18n", true);
        tab.addEdit("gmapLink", "Google Map Link", "");
        tab.addSelect("height", "Map height", "", height);
        tab.addSelect("width", "Map width", "", width);
    }
}
