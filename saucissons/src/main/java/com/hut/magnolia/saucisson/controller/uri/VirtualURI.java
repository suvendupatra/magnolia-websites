package com.hut.magnolia.saucisson.controller.uri;

import info.magnolia.module.blossom.annotation.VirtualURIMapper;

import javax.servlet.http.HttpServletRequest;

/**
 * Overwrites the URIs.
 * 
 * @author bruno.chauvet
 * 
 */
@VirtualURIMapper
public class VirtualURI {
    public String products(String uri, HttpServletRequest request) {
        if (uri.equals("/home/produits/")) {
            return "forward:/home/produits/presentation";
        }
        return null;
    }

    public String information(String uri, HttpServletRequest request) {
        if (uri.equals("/home/information/")) {
            return "forward:/home/information/evenement";
        }
        return null;
    }
}
