package com.hut.magnolia.saucisson.controller.template;

import info.magnolia.module.blossom.annotation.DialogFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.dialog.DialogBuilder;
import info.magnolia.module.blossom.dialog.TabBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller defining the Main Template.
 * 
 * @author bruno.chauvet
 * 
 */
@Template(name = "saucisson-main-template", value = "Saucisson - Main Template", description = "Saucisson Main Template", visible = true)
@Controller
public class MainTemplate {
    /**
     * Process the requests on URL /mainTemplate
     * 
     * @return
     */
    @RequestMapping("/mainTemplate")
    public ModelAndView homeTemplate() {
        return new ModelAndView();
    }

    /**
     * Dialog factory associated to the Main page settings.
     * 
     * @param dialog
     */
    @DialogFactory("saucisson-main-dialog")
    public void homeDialog(DialogBuilder dialog) {
        TabBuilder settings = dialog.addTab("Main page settings");
        settings.addEdit("title", "Title", "The HTML page title");
        settings.addEdit("metaDescription", "Meta Description", "HTML Meta Description of the web site");
        settings.addEdit("metaKeywords", "Meta Keywords", "HTML Meta Keywords of the web site");
        settings.addCheckbox("hideInNav", "Hide page in navigation menu", "");
    }
}
