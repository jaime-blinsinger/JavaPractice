package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalorieCalculator {

    private BMRCalculator bmrCalculator = new BMRCalculator();

    public BigDecimal calculateMaintenanceCalories(Person person) {

        BigDecimal bmr = bmrCalculator.calculateBMR(person);
        BigDecimal calories = bmr.multiply(person.getActivityLevel().multiplierValue);

        return calories.setScale(4, RoundingMode.HALF_UP);
    }


    public BigDecimal calculateCalorieDeficit(Person person){
        BigDecimal DEFAULT_DEFICIT_CALORIES_SUBTRAHEND = new BigDecimal("500");
        BigDecimal total = calculateMaintenanceCalories(person).subtract(DEFAULT_DEFICIT_CALORIES_SUBTRAHEND);
        return total.setScale(4, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateBulkingCalories(Person person) {
        final BigDecimal DEFAULT_BULKING_CALORIES_MULTIPLIER = new BigDecimal("0.1");
        BigDecimal addBulkCalories = calculateMaintenanceCalories(person).multiply(DEFAULT_BULKING_CALORIES_MULTIPLIER);
        BigDecimal total = calculateMaintenanceCalories(person).add(addBulkCalories);
        return total.setScale(4, RoundingMode.HALF_UP);
    }

    //this is what will be calculated to output to the user
    public BigDecimal goalCalories (Person person) {
        BigDecimal goalCalories = new BigDecimal("0");
        BigDecimal currentWeight = person.getMeasurements().getCurrentWeightKilograms();
        BigDecimal goalWeight = person.getMeasurements().getGoalWeightKilograms();

        //current weight > goal weight
        if (currentWeight.compareTo(goalWeight) > 0){
            goalCalories = calculateCalorieDeficit(person);
        }

        //current weight < goal weight
        else if (currentWeight.compareTo(goalWeight) < 0){
            goalCalories = calculateBulkingCalories(person);
        }
        else {
            goalCalories = calculateMaintenanceCalories(person);
        }
        return goalCalories.setScale(0, RoundingMode.HALF_UP);
    }
}
