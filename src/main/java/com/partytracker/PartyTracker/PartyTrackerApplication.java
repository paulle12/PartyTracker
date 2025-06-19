package com.partytracker.PartyTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.partytracker")
public class PartyTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyTrackerApplication.class, args);
	}

}
