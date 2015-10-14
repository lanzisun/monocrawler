/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lanzisun.monocrawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.BinaryParseData;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.parser.TextParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import java.util.Set;
import java.util.regex.Pattern;

/**
 *
 * @author 60334
 */
public class MonoCrawler extends WebCrawler {

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|zip|gz))$");
//    private final static Pattern FILTERS = Pattern.compile(".*(\\.(gif|jpg|png|mp3|mp3|zip|gz))$");

    /**
     * This method receives two parameters. The first parameter is the page in
     * which we have discovered this new url and the second parameter is the new
     * url. You should implement this function to specify whether the given url
     * should be crawled or not (based on your crawling logic). In this example,
     * we are instructing the crawler to ignore urls that have css, js, git, ...
     * extensions and to only accept urls that start with
     * "http://www.ics.uci.edu/". In this case, we didn't need the referringPage
     * parameter to make the decision.
     *
     * @param referringPage
     * @param url
     * @return
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
//        return !FILTERS.matcher(href).matches();
         return !FILTERS.matcher(href).matches()
                && href.contains("hotel/r8358");
    }

    /**
     * This function is called when a page is fetched and ready to be processed
     * by your program.
     *
     * @param page
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {
            //TODO collection Html data
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            System.out.println("Text length: " + text.length());
            System.out.println("Html length: " + html.length());
            System.out.println("Number of outgoing links: " + links.size());
        }

        // We are only interested in processing images which are bigger than 10k
        if (page.getParseData() instanceof TextParseData ) {
            //TODO collection text data
            TextParseData textParseData = (TextParseData) page.getParseData();
            String text = textParseData.getTextContent();
            Set<WebURL> links = textParseData.getOutgoingUrls();
            
            
            System.out.println("Text length: " + text.length());
            System.out.println("Number of outgoing links: " + links.size());
        }
        
        // We are only interested in processing images which are bigger than 10k
        if (page.getParseData() instanceof BinaryParseData) {
            //TODO collection binary data
//            BinaryParseData binaryParseData = (BinaryParseData) page.getParseData();
            String contentType = page.getContentType();
            String contentEncoding = page.getContentEncoding();
            String contentCharset = page.getContentCharset();
            String language = page.getLanguage();
            
            
            System.out.println("Content type: " + contentType);
            System.out.println("Content encoding: " + contentEncoding);
            System.out.println("Content charset: " + contentCharset);
            System.out.println("Language: " + language);
        }
        
    }
}
