package com.hut.magnolia.saucisson.core;

import info.magnolia.module.DefaultModuleVersionHandler;
import info.magnolia.module.InstallContext;
import info.magnolia.module.delta.DeltaBuilder;
import info.magnolia.module.delta.ModuleBootstrapTask;
import info.magnolia.module.delta.ModuleFilesExtraction;
import info.magnolia.module.delta.Task;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class instructs Magnolia on what to do when this module is installed or
 * updated.
 * 
 * @author bruno.chauvet
 * 
 */
public class ModuleVersionHandler extends DefaultModuleVersionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleVersionHandler.class);
    private static final String PROPERTY_FILE = "application.properties";

    /**
     * ModuleVersionHandler Constructor.
     * 
     * Register any tasks in here that need to happen as part of an update. All
     * though the constructor here will always be invoked, it will only ever
     * have an effect for updates (not new installs) because the DeltaBuilder is
     * adding "update" tasks. By default new installs are setup correctly
     * through inherited behaviour. However, if you need to perform additional
     * non default tasks as part of a new install the way this needs to be done
     * is by overriding the getExtraInstallTasks() method and adding additional
     * non-default tasks in here.
     * 
     * @see <a
     *      href="http://wiki.magnolia-cms.com/display/WIKI/Handling+module+versions">
     *          http://wiki.magnolia-cms.com/display/WIKI/Handling+module+versions
     *      </a>
     *      for more info on module versioning
     * 
     */
    public ModuleVersionHandler() {
        // Get the module version from the properties
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_FILE);
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            ModuleVersionHandler.LOGGER.error("Cannot load property file: " + PROPERTY_FILE, e);
        }

        // Register the module using version specified in the properties.
        super.register(DeltaBuilder.update(properties.getProperty("Application.version"), "Common tasks").addTasks(
                getCommonTasks()));
    }

    /**
     * Overwrites the list of tasks to perform during module installation.
     */
    @Override
    protected List<Task> getExtraInstallTasks(InstallContext installContext) {
        return this.getCommonTasks();
    }

    /**
     * Return the common task for every module update.
     * 
     * @return
     */
    private List<Task> getCommonTasks() {
        final List<Task> commonTasks = new ArrayList<Task>();

        // Installs all files from
        // /src/main/resources/mgnl-bootstrap
        commonTasks.add(new ModuleBootstrapTask());

        // Extracts all files from
        // /src/main/resources/mgnl-files
        commonTasks.add(new ModuleFilesExtraction());

        return commonTasks;
    }
}
