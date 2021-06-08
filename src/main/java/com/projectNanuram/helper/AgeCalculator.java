package com.projectNanuram.helper;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeCalculator {

    public static int age(String birthday) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birth = LocalDate.parse(birthday , formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birth , currentDate);

        return period.getYears();
    }
}
