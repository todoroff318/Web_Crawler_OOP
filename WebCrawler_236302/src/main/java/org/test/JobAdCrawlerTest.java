package org.test;

import org.example.JobAd;
import org.example.JobAdCrawler;
import org.example.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * The JobAdCrawlerTest class contains unit tests for the JobAdCrawler class.
 */
public class JobAdCrawlerTest {

    private JobAdCrawler crawler;
    private StorageService storageService;

    /**
     * Sets up the test environment before each test method execution.
     */
    @BeforeEach
    public void setUp() {
        storageService = mock(StorageService.class);
        crawler = new JobAdCrawler("https://www.zaplata.bg/rousse/", storageService);
    }

    /**
     * Tests the crawling functionality for Zaplata.bg website.
     *
     * @throws IOException if an error occurs during crawling
     */
    @Test
    public void testCrawlZaplataBg() throws IOException {
        // Arrange: Setup

        // Act: Perform the crawling operation
        List<JobAd> jobAds = crawler.call();

        // Assert: Verify the results
        assertNotNull(jobAds);
        assertFalse(jobAds.isEmpty());
    }
}
