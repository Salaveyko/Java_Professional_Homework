package com.lab06_expressions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Create a program that calculates the current lifetime.
 */
public class SampleDate {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH);
        Calendar birthDate = new GregorianCalendar(1993, Calendar.FEBRUARY, 15);
        Calendar currentDate = Calendar.getInstance();

        long diff = currentDate.getTime().getTime() - birthDate.getTime().getTime();
        long years = Double.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 365.25).longValue();
        diff -= TimeUnit.MILLISECONDS.convert(years, TimeUnit.DAYS) * 365.25;
        long months = Double.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 30.416).longValue();
        diff -= TimeUnit.MILLISECONDS.convert(months, TimeUnit.DAYS) * 30.416;
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        diff -= TimeUnit.MILLISECONDS.convert(days, TimeUnit.DAYS);
        long hours = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
        diff -= TimeUnit.MILLISECONDS.convert(hours, TimeUnit.HOURS);
        long minutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);

        System.out.println("You were born on " + dateFormat.format(birthDate.getTime()) + ".");
        System.out.println("Today is " + dateFormat.format(currentDate.getTime()) + ".");
        System.out.println("You are "
                + years + " years, "
                + months + " months, "
                + days + " days, "
                + hours + " hours, "
                + minutes + " minutes old."
        );
    }
}
