package com.nathanodong.nationaltrainhunterws.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ScheduledTasksComponent {
    private final Logger logger = LoggerFactory.getLogger(ScheduledTasksComponent.class);

    @Value("${nth.endpoint}")
    private String endpoint;

    /**
     * Poll self to keep alive every 7 minutes (first poll after 1 second of start-up)
     */
    @Scheduled(initialDelay = 1000, fixedRate = 42000)
    public void pollNTH() {
        logger.info("Polling NTH....");

        try {
            URL siteURL = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.connect();

            logger.info("Polled NTH with response code: {}", connection.getResponseCode());
        } catch (Exception e) {
            logger.error("Could not poll NTH.", e.getMessage());
        }
    }
}
