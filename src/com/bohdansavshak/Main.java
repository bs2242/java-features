package com.bohdansavshak;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();

        System.out.println(now);

        ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("America/Toronto"));
        System.out.println(now1);
    }
}
