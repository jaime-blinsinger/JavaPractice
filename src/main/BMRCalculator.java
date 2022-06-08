package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

    //TODO: I FEEL LIKE THERE'S A LOT OF REDUNDANT CODE HERE ... BUT I CAN'T FIGURE OUT HOW TO ABSTRACT IT

/**
 * BMR formulas:
 * Men: BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) – (5.677 x age in years)
 * Women: BMR = 447.593 + (9.247 x weight in kg) + (3.098 x height in cm) – (4.330 x age in years)
 */

public class BMRCalculator {

    public BigDecimal calculateWeightValueForBMRFormula(Person person){
        BigDecimal MALE_WEIGHT_MULTIPLIER = new BigDecimal("13.397");
        BigDecimal FEMALE_WEIGHT_MULTIPLIER = new BigDecimal("9.247");

        BigDecimal maleWeightValue = MALE_WEIGHT_MULTIPLIER.multiply(person.getMeasurements().getCurrentWeightKilograms());
        BigDecimal femaleWeightValue = FEMALE_WEIGHT_MULTIPLIER.multiply(person.getMeasurements().getCurrentWeightKilograms());

        Person.Gender gender = person.getGender();

        return gender.equals(Person.Gender.MALE) ? maleWeightValue : femaleWeightValue;
    }

    public BigDecimal calculateHeightValueForBMRFormula(Person person){
        BigDecimal MALE_HEIGHT_MULTIPLIER = new BigDecimal("4.799");
        BigDecimal FEMALE_HEIGHT_MULTIPLIER = new BigDecimal("3.098");

        BigDecimal maleHeightValue = MALE_HEIGHT_MULTIPLIER.multiply(person.getMeasurements().getHeightCentimeters());
        BigDecimal femaleHeightValue = FEMALE_HEIGHT_MULTIPLIER.multiply(person.getMeasurements().getHeightCentimeters());

        Person.Gender gender = person.getGender();

        return gender.equals(Person.Gender.MALE) ? maleHeightValue : femaleHeightValue;
    }

    public BigDecimal calculateAgeValueForBMRFormula(Person person){
        BigDecimal MALE_AGE_MULTIPLIER = new BigDecimal("5.677");
        BigDecimal FEMALE_AGE_MULTIPLIER = new BigDecimal("4.330");

        BigDecimal maleAgeValue = MALE_AGE_MULTIPLIER.multiply(person.getAge());
        BigDecimal femaleAgeValue = FEMALE_AGE_MULTIPLIER.multiply(person.getAge());

        Person.Gender gender = person.getGender();

        return gender.equals(Person.Gender.MALE) ? maleAgeValue : femaleAgeValue;
    }

    public BigDecimal calculateBMR(Person person) {

        BigDecimal MALE_BMR_FORMULA_CONSTANT = new BigDecimal("88.362");
        BigDecimal FEMALE_BMR_FORMULA_CONSTANT = new BigDecimal("447.593");

        BigDecimal weightValue = calculateWeightValueForBMRFormula(person);
        BigDecimal heightValue = calculateHeightValueForBMRFormula(person);
        BigDecimal ageValue = calculateAgeValueForBMRFormula(person);

        BigDecimal calculateBMR = weightValue.add(heightValue).subtract(ageValue).setScale(4, RoundingMode.HALF_UP);

        Person.Gender gender = person.getGender();

        return gender.equals(Person.Gender.MALE) ? MALE_BMR_FORMULA_CONSTANT.add(calculateBMR) : FEMALE_BMR_FORMULA_CONSTANT.add(calculateBMR);
    }
}
