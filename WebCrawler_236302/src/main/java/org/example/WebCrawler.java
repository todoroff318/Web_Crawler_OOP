package org.example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The WebCrawler class represents a web crawling engine that concurrently crawls
 * multiple websites to gather job advertisements and stores them using a provided
 * storage service.
 */
public class WebCrawler {
    private final List<String> websites;
    private final int maxParallelRequests;
    private final StorageService storageService;

    /**
     * Constructs a new WebCrawler with the specified list of websites to crawl,
     * maximum number of parallel requests, and storage service.
     *
     * @param websites            The list of websites to crawl for job advertisements.
     * @param maxParallelRequests The maximum number of parallel requests to be executed.
     * @param storageService      The storage service to store the gathered job advertisements.
     */
    public WebCrawler(List<String> websites, int maxParallelRequests, StorageService storageService) {
        this.websites = websites;
        this.maxParallelRequests = maxParallelRequests;
        this.storageService = storageService;
    }

    /**
     * Starts the web crawling process for all specified websites concurrently.
     * It uses a fixed thread pool executor to manage parallel requests and waits
     * for all tasks to complete before printing the gathered job advertisements
     * to the console for testing purposes.
     */
    public void startCrawling() {
        ExecutorService executor = Executors.newFixedThreadPool(maxParallelRequests);

        for (String website : websites) {
            JobAdCrawler crawler = new JobAdCrawler(website, storageService);
            executor.execute(crawler);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Extract the gathered job advertisements from the storage service
        // and print them to the console for testing purposes
        List<JobAd> jobAds = storageService.getJobAds();
        for (JobAd jobAd : jobAds) {
            System.out.println("Title: " + jobAd.getTitle());
            System.out.println("URL: " + jobAd.getUrl());
            System.out.println("-----------------------------");
        }
    }
}
