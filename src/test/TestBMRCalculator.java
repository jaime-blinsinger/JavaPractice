package test;

import main.BMRCalculator;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public class TestBMRCalculator {

    BMRCalculator bmrCalculator = new BMRCalculator();
    TestPerson testPerson = new TestPerson();

    @Test
    public void testCalculateBMR() {
        // Female formula: 447.593 + (9.247 x weight in kg) + (3.098 x height in cm) – (4.330 x age in years)

        // 447.593 + 739.76 + 542.15 - 125.57 = 1603.993; expected via manual calculation
        assertEquals(new BigDecimal("1603.9330"), bmrCalculator.calculateBMR(testPerson.jaime));

        // 447.593 + 462.35 + 495.68 - 242.48 = 1163.143; expected via manual calculation
        assertEquals(new BigDecimal("1163.1430"), bmrCalculator.calculateBMR(testPerson.ellen));

        // Male formula: 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) – (5.677 x age in years)

        // 88.362 + 1152.142 + 878.217 - 170.31 = 1948.411; expected via manual calculation
        assertEquals(new BigDecimal("1948.4110"), bmrCalculator.calculateBMR(testPerson.rob));

        //88.362 + 1031.569 + 887.815 - 329.266 = 1678.48; expected via manual calculation
        assertEquals(new BigDecimal("1678.4800"), bmrCalculator.calculateBMR(testPerson. bobby));
    }
}