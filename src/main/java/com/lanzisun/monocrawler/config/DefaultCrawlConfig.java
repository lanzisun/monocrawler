/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lanzisun.monocrawler.config;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;

/**
 *
 * @author 60334
 */
public class DefaultCrawlConfig extends CrawlConfig {

    private static final String userAgentString = "crawler4j (https://github.com/yasserg/crawler4j/)";
    private static final String crawlStorageFolder = "/data/crawl/root/caoliu";
    private static final int numberOfCrawlers = 7;
    private static final String crawlStoregeImageFolder = "/data/crawl/root/caoliu/images";

    public DefaultCrawlConfig() {
        super();

        setUserAgentString(userAgentString);
        setCrawlStorageFolder(crawlStorageFolder);
    }

    public String getCrawlStoregeImageFolder() {
        return crawlStoregeImageFolder;
    }

    public int getNumberOfCrawlers() {
        return numberOfCrawlers;
    }

    public String getCrawlStorageFolder(){
        return crawlStoregeImageFolder;
    }
}
