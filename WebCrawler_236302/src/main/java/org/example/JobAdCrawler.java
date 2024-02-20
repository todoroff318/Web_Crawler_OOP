package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static org.example.JobAdManipulator.addJobAd;

/**
 * The JobAdCrawler class represents a crawler responsible for fetching job advertisements
 * from specific websites and storing them using a provided storage service.
 */
public class JobAdCrawler implements Callable<List<JobAd>>, Runnable {
    private final String websiteUrl;
    private final StorageService storageService;

    /**
     * Constructs a new JobAdCrawler with the specified website URL and storage service.
     *
     * @param websiteUrl     The URL of the website to crawl for job advertisements.
     * @param storageService The storage service to store the fetched job advertisements.
     */
    public JobAdCrawler(String websiteUrl, StorageService storageService) {
        this.websiteUrl = websiteUrl;
        this.storageService = storageService;
    }

    /**
     * Runs the job ad crawling process for the specified website URL.
     * This method is called when the JobAdCrawler is executed as a Runnable.
     */
    public void run() {
        List<JobAd> jobAds = call();
        storageService.saveJobAds(jobAds);
    }

    /**
     * Fetches and parses job advertisements from the specified website URL.
     * This method is called when the JobAdCrawler is executed as a Callable.
     *
     * @return A list of JobAd objects representing the fetched job advertisements.
     */
    @Override
    public List<JobAd> call() {
        List<JobAd> jobAds = new ArrayList<>();
        try {
            Document document = Jsoup.connect(websiteUrl).get();
            if (websiteUrl.startsWith("https://www.zaplata.bg/rousse/")) {
                Elements adElements = document.select("div.title[id^=t]");
                for (Element adElement : adElements) {
                    String title = adElement.select("a").text();
                    String url = adElement.select("a").attr("abs:href");
                    addJobAd(title, url, jobAds);
                }
            } else if (websiteUrl.startsWith("https://bazar.bg/obiavi/rabota/ruse")) {
                Elements adElements = document.select("div.main-info div.details div.title");
                for (Element adElement : adElements) {
                    String title = adElement.select("a.title").text();
                    String url = adElement.select("a.title").attr("abs:href");
                    addJobAd(title, url, jobAds);
                }
            }
        } catch (IOException e) {
            System.err.println("Error crawling job ads from " + websiteUrl + ": " + e.getMessage());
        }
        return jobAds;
    }
}
