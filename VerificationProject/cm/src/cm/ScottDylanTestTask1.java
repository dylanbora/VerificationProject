package cm;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ScottDylanTestTask1 {

    public ScottDylanTestTask1() {

    }
    cm.CarParkKind kind;
    BigDecimal normalRate = BigDecimal.valueOf(4.0);
    BigDecimal reducedRate = BigDecimal.valueOf(1.0);
    ArrayList<Period> reducedPeriods, normalPeriods;
    Rate rate = new Rate(kind, normalRate,reducedRate,reducedPeriods, normalPeriods);
    int startHour = 3;
    int endHour = 10;
    int rRate;
    int nRate;
    Period period = new Period(startHour,endHour);

    public ArrayList<Period> addMethods(ArrayList<Period> ps,int startHour,int endHour )
    {
        Period period = new Period(startHour,endHour);
        ps.add(period);
        return ps;
    }

    @org.junit.jupiter.api.Test // Test if periods overlap
    public void testOne() {

        assertEquals(new BigDecimal(22), rate.calculate(period));

    }

    @org.junit.jupiter.api.Test // Test if Reduced rate is less than 0
    public void testTwo() {

        reducedRate = BigDecimal.valueOf(-1.0);
        rRate = reducedRate.intValue();
        //assertTrue("Hourly normal rate (" + normalRate + ") cannot be less than zero", nRate <= 0 );

    }

    @org.junit.jupiter.api.Test // Test if Reduced Rate is greater than 0
    public void testThree() {

        reducedRate = BigDecimal.valueOf(1.0);
        rRate = reducedRate.intValue();
        //assertTrue("Hourly reduced rate (" + rRate + ") is greater than 0", rRate > 0);

    }

    @org.junit.jupiter.api.Test // Test if Normal Rate is less than 0
    public void testFour() {

        normalRate = BigDecimal.valueOf(-1.0);
        nRate = normalRate.intValue();
       // assertTrue("Hourly normal rate (" + rRate + ") cannot be less than 0", nRate <= 0);

    }

    @org.junit.jupiter.api.Test // Test if Normal Rate is greater than 0
    public void testFive() {

        normalRate = BigDecimal.valueOf(5.0);
        nRate = normalRate.intValue();
       // assertTrue("Hourly normal rate (" + rRate + ") is greater than 0", nRate > 0);

    }

    @org.junit.jupiter.api.Test // Test if reduced rate is less than normal rate
    public void testSix() {

        reducedRate = BigDecimal.valueOf(6.0);
        rRate = reducedRate.intValue();
        normalRate = BigDecimal.valueOf(4.0f);
        nRate = normalRate.intValue();
       // assertTrue("Hourly normal rate (" + normalRate + ") Cannot be less than ("+ reducedRate +")", nRate < rRate);
    }

    @org.junit.jupiter.api.Test // Test if periods overlap
    public void testSeven() {

        reducedRate = BigDecimal.valueOf(6.0);
        normalRate = BigDecimal.valueOf(4.0f);
        int sReduced = 4, eReduced = 7, sNorm = 6, eNorm =10;

        Period normalTest = new Period(sNorm,eNorm);
        Period reducedTest = new Period(sReduced,eReduced);

       // assertTrue("Periods of stay cannot overlap)", eReduced > sNorm );

    }

}

