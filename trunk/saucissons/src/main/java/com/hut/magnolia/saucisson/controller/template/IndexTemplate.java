package com.hut.magnolia.saucisson.controller.template;

import info.magnolia.module.blossom.annotation.Template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller defining the Index Template.
 * 
 * @author bruno.chauvet
 * 
 */
@Template(name = "saucisson-index-template", value = "Saucisson - Index Template", description = "Saucisson Index Template", visible = true)
@Controller
public class IndexTemplate {
    /**
     * Process the requests on URL /indexTemplate
     * 
     * @return
     */
    @RequestMapping("/indexTemplate")
    public ModelAndView indexTemplate() {
        return new ModelAndView();
    }
}
