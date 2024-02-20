package org.test;

import org.example.JobAd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The JobAdTest class contains unit tests for the JobAd class.
 */
public class JobAdTest {

    /**
     * Tests the creation of a JobAd instance.
     */
    @Test
    public void testCreateJobAd() {
        // Arrange: Setup
        String title = "Test Job";
        String url = "https://example.com/test-job";

        // Act: Create a JobAd instance
        JobAd jobAd = new JobAd(title, url);

        // Assert: Verify the properties of the created JobAd instance
        assertNotNull(jobAd);
        assertEquals(title, jobAd.getTitle());
        assertEquals(url, jobAd.getUrl());
    }
}
