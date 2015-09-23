/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lanzisun.monocrawler.config;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author 60334
 */
public class SeedLinks {

    private static final Pattern LINK_PREFIX = Pattern.compile("http://");
    private final List<String> links = new ArrayList();

    public SeedLinks() {
        links.add("http://");
        links.add("http://");
        links.add("http://");
        links.add("http://");
    }

    public boolean isValidLink(String link) {
        // Ignore the url if it has an extension that matches our defined set of image extensions.
        // Only accept the url if it is in the "www.ics.uci.edu" domain and protocol is "http".
//    return href.startsWith("http://www.ul.com/");
        
        return LINK_PREFIX.matcher(link).matches();
    }

    public void addLink(Collection<String> links) {
        links.stream().filter((link) -> (isValidLink(link))).forEach((link) -> {
            links.add(link);
        });
    }

    public void addLink(String link) {
        if (isValidLink(link)) {
            links.add(link);
        }
    }

    public List<String> getLinks() {
        return links;
    }
}
