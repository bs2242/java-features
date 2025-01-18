package com.bohdansavshak;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaFeatures {

  public static void main(String[] args) {
    ZonedDateTime now = ZonedDateTime.now();

    System.out.println(now);

    ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("America/Toronto"));
    System.out.println(now1);
  }
}
