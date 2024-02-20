package org.test;

import org.example.InMemoryStorageService;
import org.example.JobAd;
import org.example.StorageService;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The StorageServiceTest class contains unit tests for the StorageService implementation.
 */
public class StorageServiceTest {

    /**
     * Tests the save and retrieval of JobAds from the storage service.
     */
    @Test
    public void testSaveAndGetJobAds() {
        // Arrange: Setup
        StorageService storageService = new InMemoryStorageService();
        List<JobAd> jobAds = new ArrayList<>();
        jobAds.add(new JobAd("Test Job 1", "https://example.com/test1"));
        jobAds.add(new JobAd("Test Job 2", "https://example.com/test2"));

        // Act: Save JobAds and retrieve them
        storageService.saveJobAds(jobAds);
        List<JobAd> savedJobAds = storageService.getJobAds();

        // Assert: Verify the saved JobAds
        assertNotNull(savedJobAds);
        assertEquals(2, savedJobAds.size());
    }
}
