package cm;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScottDylanTestTask2 {


    private ArrayList<Period> Null;

    public ScottDylanTestTask2() {

    }

    cm.CarParkKind kind;
    BigDecimal normalRate = BigDecimal.valueOf(10);
    BigDecimal reducedRate = BigDecimal.valueOf(5);

    ArrayList<Period> reducedPeriods, normalPeriods;
    int startHourNormal, endHourNormal, secondStartHourNormal, secondEndHourNormal, startHourReduced, endHourReduced, secondStartHourReduced, secondEndHourReduced, rRate, nRate;


    public ArrayList<Period> calPeriod(ArrayList<Period> periodStay, int startHour, int endHour) {
        Period period = new Period(startHour, endHour);
        periodStay.add(period);
        return periodStay;
    }

    @org.junit.jupiter.api.Test // Test Calculate Function
    public void testOne() {


        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> periodStay = new ArrayList<Period>();

        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(5);
        startHourNormal = 2;
        endHourNormal = 6;
        secondStartHourNormal = 19;
        secondEndHourNormal = 21;

        startHourReduced = 7;
        endHourReduced = 10;
        secondStartHourReduced = 12;
        secondEndHourReduced = 17;

        BigDecimal calc = BigDecimal.ZERO;

        int periodStart = 1;
        int periodEnd = 6;
        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourNormal, secondEndHourNormal);
        periodStay = calPeriod(periodStay, periodStart, periodEnd);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

        BigDecimal correctVal = BigDecimal.valueOf(40);
        calc = rate.calculate(periodStay.get(0));
        int returnOF = calc.compareTo(correctVal);
    }

    @org.junit.jupiter.api.Test // Test if Reduced rate is less than 0
    public void testTwo() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(-5);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }


    @org.junit.jupiter.api.Test // Test if Reduced Rate is greater than 0
    public void testThree() {

        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(-5);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.jupiter.api.Test // Test if Normal Rate is less than 0
    public void testFour() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalRate = BigDecimal.valueOf(-10);
        reducedRate = BigDecimal.valueOf(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.jupiter.api.Test // Test if Normal Rate is greater than 0
    public void testFive() {

        reducedPeriods = new ArrayList<Period>();
        normalPeriods = new ArrayList<Period>();
        normalRate = BigDecimal.valueOf(-10);
        reducedRate = BigDecimal.valueOf(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.jupiter.api.Test // Test if reduced rate is less than normal rate
    public void testSix() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalRate = BigDecimal.valueOf(3);
        reducedRate = BigDecimal.valueOf(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

        //assertTrue("Hourly normal rate (" + normalRate + ") Cannot be less than ("+ reducedRate +")", nRate < rRate );

    }

    @org.junit.jupiter.api.Test // Test if periods overlap
    public void testSeven() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(5);

        startHourNormal = 12;
        endHourNormal = 14;
        secondStartHourNormal = 15;
        secondEndHourNormal = 16;

        startHourReduced = 12;
        endHourReduced = 13;
        secondStartHourReduced = 14;
        secondEndHourReduced = 16;


        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourNormal, secondEndHourNormal);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.jupiter.api.Test // Test if reduced period is NULL
    public void testEight() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(5);

        startHourNormal = 12;
        endHourNormal = 17;
        secondStartHourNormal = 19;
        secondEndHourNormal = 21;

        startHourReduced = 5;
        endHourReduced = 7;
        secondStartHourReduced = 12;
        secondEndHourReduced = 14;

        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourNormal, secondEndHourNormal);

        Rate rate = new Rate(kind, normalRate, reducedRate, null, normalPeriods);

    }

    @org.junit.jupiter.api.Test // Test if normal period is NULL
    public void testNine() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(5);

        startHourNormal = 12;
        endHourNormal = 17;
        secondStartHourNormal = 19;
        secondEndHourNormal = 21;

        startHourReduced = 5;
        endHourReduced = 7;
        secondStartHourReduced = 12;
        secondEndHourReduced = 14;

        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourNormal, secondEndHourNormal);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, null);

    }

    @org.junit.jupiter.api.Test // Test if Reduced Rate is NULL
    public void testTen() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalRate = BigDecimal.valueOf(10);
        reducedRate = null;

        startHourNormal = 12;
        endHourNormal = 17;
        secondStartHourNormal = 19;
        secondEndHourNormal = 21;

        startHourReduced = 5;
        endHourReduced = 7;
        secondStartHourReduced = 8;
        secondEndHourReduced = 11;


        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourNormal, secondEndHourNormal);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.jupiter.api.Test // Test if normal rate is NULL
    public void testEleven() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalRate = null;
        reducedRate = BigDecimal.valueOf(5);

        startHourNormal = 12;
        endHourNormal = 17;
        secondStartHourNormal = 19;
        secondEndHourNormal = 21;

        startHourReduced = 5;
        endHourReduced = 7;
        secondStartHourReduced = 8;
        secondEndHourReduced = 11;


        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourReduced, secondEndHourReduced);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.jupiter.api.Test // Test if periods are valid individually
    public void testTwelve() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(5);

        startHourNormal = 12;
        endHourNormal = 13;
        secondStartHourNormal = 12;
        secondEndHourNormal = 16;

        startHourReduced = 12;
        endHourReduced = 13;
        secondStartHourReduced = 14;
        secondEndHourReduced = 16;


        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourNormal, secondEndHourNormal);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

    }

    @org.junit.jupiter.api.Test // Test if start hour is less than 0
    public void testThirteen() {

        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(5);
        ArrayList<Period> reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1, 6), new Period(6, 12)));
        ArrayList<Period> normalPeriod = new ArrayList<Period>(Arrays.asList(new Period(12, 16), new Period(16, 24)));
        Period period = new Period(-1, 2);

    }

    @org.junit.jupiter.api.Test // Test to check normal rate for visitors.
    public void testFourteen(){

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> periodStay = new ArrayList<Period>();

        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(5);
        kind = CarParkKind.Visitor;

        startHourNormal = 2;
        endHourNormal = 6;
        secondStartHourNormal = 19;
        secondEndHourNormal = 21;

        startHourReduced = 7;
        endHourReduced = 10;
        secondStartHourReduced = 12;
        secondEndHourReduced = 17;

        BigDecimal calc = BigDecimal.ZERO;

        int periodStart = 1;
        int periodEnd = 6;
        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourNormal, secondEndHourNormal);
        periodStay = calPeriod(periodStay, periodStart, periodEnd);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

        BigDecimal correctVal = BigDecimal.valueOf(15);
        calc = rate.calculate(periodStay.get(0));
        int returnOF = calc.compareTo(correctVal);
        assertEquals(0, returnOF, "Expected: (" + correctVal + ") Actual: (" + calc + ")");

    }

    @org.junit.jupiter.api.Test // Test to check normal rate for management.
    public void testFifteen(){

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> periodStay = new ArrayList<Period>();

        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(5);
        kind = CarParkKind.Management;

        startHourNormal = 2;
        endHourNormal = 6;
        secondStartHourNormal = 19;
        secondEndHourNormal = 21;

        startHourReduced = 7;
        endHourReduced = 10;
        secondStartHourReduced = 12;
        secondEndHourReduced = 17;

        BigDecimal calc = BigDecimal.ZERO;

        int periodStart = 1;
        int periodEnd = 6;
        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourNormal, secondEndHourNormal);
        periodStay = calPeriod(periodStay, periodStart, periodEnd);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

        BigDecimal correctVal = BigDecimal.valueOf(40);
        calc = rate.calculate(periodStay.get(0));
        int returnOF = calc.compareTo(correctVal);
        assertEquals(0, returnOF, "Expected: (" + correctVal + ") Actual: (" + calc + ")");

    }

    @org.junit.jupiter.api.Test // Test to check normal rate for student.
    public void testSixteen() {

        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> periodStay = new ArrayList<Period>();

        normalRate = BigDecimal.valueOf(10);
        reducedRate = BigDecimal.valueOf(5);
        kind = CarParkKind.Student;

        startHourNormal = 2;
        endHourNormal = 6;
        secondStartHourNormal = 19;
        secondEndHourNormal = 21;

        startHourReduced = 7;
        endHourReduced = 10;
        secondStartHourReduced = 12;
        secondEndHourReduced = 17;

        BigDecimal calc = BigDecimal.ZERO;

        int periodStart = 1;
        int periodEnd = 6;
        reducedPeriods = calPeriod(reducedPeriods, startHourReduced, endHourReduced);
        reducedPeriods = calPeriod(reducedPeriods, secondStartHourReduced, secondEndHourReduced);
        normalPeriods = calPeriod(normalPeriods, startHourNormal, endHourNormal);
        normalPeriods = calPeriod(normalPeriods, secondStartHourNormal, secondEndHourNormal);
        periodStay = calPeriod(periodStay, periodStart, periodEnd);

        Rate rate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);

        BigDecimal correctVal = BigDecimal.valueOf(30);
        calc = rate.calculate(periodStay.get(0));
        int returnOF = calc.compareTo(correctVal);
        assertEquals(0, returnOF, "Expected: (" + correctVal + ") Actual: (" + calc + ")");
    }
}
