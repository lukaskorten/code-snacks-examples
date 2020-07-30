package de.codesnacks.progresslog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgressLogApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ProgressLogApplication.class);

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ProgressLogApplication.class, args);

		LOG.info("start process ...");
		Marker progress = MarkerFactory.getMarker("PROGRESS");
		for (int i = 0; i <= 100; i++) {
			LOG.info(progress, "items processed - {} / {}", i, 100);
			Thread.sleep(100);
		}
		LOG.info("finish process ...");
	}

}
