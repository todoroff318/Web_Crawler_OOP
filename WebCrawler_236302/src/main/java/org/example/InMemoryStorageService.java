package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * The InMemoryStorageService class implements the StorageService interface
 * to provide storage for job advertisements in memory.
 */
public class InMemoryStorageService implements StorageService {
    private List<JobAd> jobAds = new ArrayList<>();

    /**
     * Saves the provided job advertisements to the in-memory storage.
     *
     * @param jobAds The list of job advertisements to save.
     */
    @Override
    public void saveJobAds(List<JobAd> jobAds) {
        this.jobAds.addAll(jobAds);
    }

    /**
     * Retrieves a copy of the stored job advertisements from memory.
     *
     * @return A list containing copies of the stored job advertisements.
     */
    @Override
    public List<JobAd> getJobAds() {
        return new ArrayList<>(jobAds);
    }
}
