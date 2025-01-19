package com.bohdansavshak;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class JavaFeatures {

	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();

		System.out.println(now);

		ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("America/Toronto"));
		System.out.println(now1);
	}

}
