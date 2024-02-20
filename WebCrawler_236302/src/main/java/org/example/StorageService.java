package org.example;

import java.util.List;

/**
 * The StorageService interface defines methods for storing and retrieving job advertisements.
 */
public interface StorageService {
    /**
     * Saves a list of job advertisements.
     *
     * @param jobAds The list of job advertisements to be saved.
     */
    void saveJobAds(List<JobAd> jobAds);

    /**
     * Retrieves a list of job advertisements.
     *
     * @return The list of job advertisements retrieved.
     */
    List<JobAd> getJobAds();
}
