package org.example;

/**
 * The JobAd class represents a job advertisement with a title and a URL.
 */
public class JobAd {
    private String title;
    private String url;

    /**
     * Constructs a new JobAd object with the specified title and URL.
     *
     * @param title The title of the job advertisement.
     * @param url   The URL of the job advertisement.
     */
    public JobAd(String title, String url) {
        this.title = title;
        this.url = url;
    }

    /**
     * Retrieves the title of the job advertisement.
     *
     * @return The title of the job advertisement.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the job advertisement.
     *
     * @param title The new title of the job advertisement.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the URL of the job advertisement.
     *
     * @return The URL of the job advertisement.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL of the job advertisement.
     *
     * @param url The new URL of the job advertisement.
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
