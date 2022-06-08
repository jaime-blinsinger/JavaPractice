package test;

import main.CalorieCalculator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class TestCalorieCalculator {

    CalorieCalculator calorieCalculator = new CalorieCalculator();
    TestPerson testPerson = new TestPerson();

    /**
     * Activity Level Constants:
     * Sedentary: 1.2
     * Lightly Active: 1.375
     * Moderately Active: 1.55
     * Very Active: 1.725
     */

    @Test
    // maintenance calories = BMR * activity level constant
    public void testCalculateMaintenanceCalories() {
        // jaime MC = 1603.933 * 1.375 = 2205.4079
        assertEquals(new BigDecimal("2205.4079"), calorieCalculator.calculateMaintenanceCalories(testPerson.jaime));

        // rob MC = 1948.411 * 1.55 = 3020.0370
        assertEquals(new BigDecimal("3020.0371"), calorieCalculator.calculateMaintenanceCalories(testPerson.rob));

        // bobby MC = 1678.4800 * 1.725 = 2895.378
        assertEquals(new BigDecimal("2895.3780"), calorieCalculator.calculateMaintenanceCalories(testPerson.bobby));

        // ellen MC = 1163.1430 * 1.2 = 1395.7716
        assertEquals(new BigDecimal("1395.7716"), calorieCalculator.calculateMaintenanceCalories(testPerson.ellen));
    }

    @Test
    //deficit = maintenance calories - 500 cal
    public void testCalculateCalorieDeficit() {
        assertEquals(new BigDecimal("1705.4079"), calorieCalculator.calculateCalorieDeficit(testPerson.jaime));
        assertEquals(new BigDecimal("2520.0371"), calorieCalculator.calculateCalorieDeficit(testPerson.rob));
    }

    @Test
    //bulk cal = maintenance calories * 0.1
    public void testCalculateBulkingCalories() {
        assertEquals(new BigDecimal("2425.9487"), calorieCalculator.calculateBulkingCalories(testPerson.jaime));
        assertEquals(new BigDecimal("3322.0408"), calorieCalculator.calculateBulkingCalories(testPerson.rob));
        assertEquals(new BigDecimal("3184.9158"), calorieCalculator.calculateBulkingCalories(testPerson.bobby));

    }

    @Test
    //maintenance, bulking, or deficit determined by current weight compared to goal weight
    public void testCalculateGoalCalories() {
        assertEquals(new BigDecimal("1705"), calorieCalculator.goalCalories(testPerson.jaime));
        assertEquals(new BigDecimal("2520"), calorieCalculator.goalCalories(testPerson.rob));
        assertEquals(new BigDecimal("3185"), calorieCalculator.goalCalories(testPerson.bobby));
        assertEquals(new BigDecimal("1396"), calorieCalculator.goalCalories(testPerson.ellen));

    }
}
