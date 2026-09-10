package com.ben.SplunkDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class SplunkDemo implements CommandLineRunner {

	/* IMPLEMENTS CommandLineRunner

	Why? To execute code after the Spring Boot application starts.
	We're gonna take advantage of that to simulate log generation for Splunk.

	Spring calls this automatically when you run main! Cool
	*/

    private static final Logger logger = LoggerFactory.getLogger(SplunkDemo.class);

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();

        logger.info("Starting log simulation - 500 iterations");

        for (int i = 1; i <= 500; i++) {
            int roll = random.nextInt(100); // 0-99

            if (roll < 60) {
                // 60% chance - success
                logger.info("Iteration {}: Transaction processed successfully. Amount: ${}",
                        i, (random.nextInt(9000) + 1000));

            } else if (roll < 85) {
                // 25% chance - warning
                logger.warn("Iteration {}: Transaction flagged for review. Amount exceeded threshold: ${}",
                        i, (random.nextInt(5000) + 9000));

            } else {
                // 15% chance - error
                logger.error("Iteration {}: Transaction failed. Reason: {}",
                        i, getRandomError(random));
            }

            // Small delay so logs have slightly different timestamps
            Thread.sleep(10);
        }

        logger.info("Log simulation complete.");
    }

    private String getRandomError(Random random) {
        String[] errors = {
                "Connection timeout",
                "Insufficient funds",
                "Invalid account number",
                "Duplicate transaction detected",
                "Authorization failed"
        };
        return errors[random.nextInt(errors.length)];
    }
}