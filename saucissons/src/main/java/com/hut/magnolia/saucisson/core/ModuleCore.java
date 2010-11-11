package com.hut.magnolia.saucisson.core;

import info.magnolia.module.ModuleLifecycle;
import info.magnolia.module.ModuleLifecycleContext;
import info.magnolia.module.blossom.module.BlossomModuleSupport;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Core class of the Magnolia and Blossom Module.<br/>
 * Starts the Spring Context using Blossom.
 * 
 * @author bruno.chauvet
 * 
 */
public class ModuleCore extends BlossomModuleSupport implements ModuleLifecycle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleCore.class);
    private static ModuleCore instance;

    @SuppressWarnings("rawtypes")
    private Map contact;

    /**
     * Initialise the instance variable
     */
    public ModuleCore() {
        ModuleCore.instance = this;
    }

    /**
     * Return the singleton instance
     * 
     * @return
     */
    public static ModuleCore getInstance() {
        return ModuleCore.instance;
    }

    /**
     * Starts the Spring/Blossom context.
     */
    public void start(ModuleLifecycleContext moduleLifecycleContext) {
        ModuleCore.LOGGER.info(this.getClass().getSimpleName() + " is starting");
        super.initRootWebApplicationContext("classpath:/applicationContext.xml");
        super.initBlossomDispatcherServlet("blossom", "classpath:/blossom-servlet.xml");
    }

    /**
     * Stops the Spring/Blossom context.
     */
    public void stop(ModuleLifecycleContext moduleLifecycleContext) {
        ModuleCore.LOGGER.info(this.getClass().getSimpleName() + " is stopping");
        super.destroyDispatcherServlets();
        super.closeRootWebApplicationContext();
    }

    /**
     * Returns Contact Us email.
     * 
     * @return
     */
    public String getContactEmail() {
        String retVal = "";
        try {
            if (this.contact != null) {
                retVal = (String) this.contact.get("email");
            }
        } catch (Exception e) {
            LOGGER.error("Unable to find property email", e);
        }
        return retVal;
    }

    /**
     * Returns Contact Us email.
     * 
     * @return
     */
    public String getContactSubject() {
        String retVal = "";
        try {
            if (this.contact != null) {
                retVal = (String) this.contact.get("subject");
            }
        } catch (Exception e) {
            LOGGER.error("Unable to find property subject", e);
        }
        return retVal;
    }

    /**
     * Auto-populates the contact Map using Magnolia Configuration.
     * 
     * @return
     */
    public Map getContact() {
        return contact;
    }

    public void setContact(Map contact) {
        this.contact = contact;
    }
}
