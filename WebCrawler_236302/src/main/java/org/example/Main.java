package org.example;

import java.util.List;

/**
 * The Main class represents the entry point of the application. It initializes
 * the necessary components and starts the web crawling process to gather job ads
 * from specified websites.
 */
public class Main {

    /**
     * The main method of the application. It initializes the storage service,
     * specifies the websites to crawl, and starts the web crawler.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of StorageService
        StorageService storageService = new InMemoryStorageService();

        // List of websites to crawl for job ads
        List<String> websites = List.of(
                "https://www.zaplata.bg/rousse/",
                "https://www.zaplata.bg/rousse/?page=2",
                "https://www.zaplata.bg/rousse/?page=3",
                "https://www.zaplata.bg/rousse/?page=4",
                "https://bazar.bg/obiavi/rabota/ruse",
                "https://bazar.bg/obiavi/rabota/ruse?page=2"
        );

        // Maximum number of parallel requests
        int maxParallelRequests = 5;

        // Create an instance of WebCrawler
        WebCrawler webCrawler = new WebCrawler(websites, maxParallelRequests, storageService);

        // Start the web crawler
        webCrawler.startCrawling();
    }
}
