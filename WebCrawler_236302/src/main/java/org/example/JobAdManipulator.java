package org.example;

import java.util.List;

/**
 * The JobAdManipulator class provides utility methods for manipulating job advertisements.
 */
public class JobAdManipulator {
    /**
     * Adds a new job advertisement with the specified title and URL to the given list of job advertisements.
     *
     * @param title  The title of the job advertisement to be added.
     * @param url    The URL of the job advertisement to be added.
     * @param jobAds The list of job advertisements to which the new job advertisement will be added.
     */
    public static void addJobAd(String title, String url, List<JobAd> jobAds) {
        JobAd jobAd = new JobAd(title, url);
        jobAds.add(jobAd);
    }
}
