package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MacroCalculator {

    private static final BigDecimal PROTEIN_CALORIES_PER_GRAM = new BigDecimal("4");
    private static final BigDecimal FAT_CALORIES_PER_GRAM = new BigDecimal("9");
    private static final BigDecimal CARB_CALORIES_PER_GRAM = new BigDecimal("4");

    CalorieCalculator calorieCalculator = new CalorieCalculator();

    public BigDecimal calculateGramsProtein(Person person){
        BigDecimal gramsProtein = null;

        BigDecimal caloriesFromProtein = calorieCalculator.goalCalories(person)
                .multiply(person.getMacroRatio().getProteinRatio());

        return caloriesFromProtein.divide(PROTEIN_CALORIES_PER_GRAM, 0, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateGramsFat(Person person){
        BigDecimal gramsFat = null;

        BigDecimal caloriesFromFat = calorieCalculator.goalCalories(person)
                .multiply(person.getMacroRatio().getFatRatio());

        return caloriesFromFat.divide(FAT_CALORIES_PER_GRAM, 0, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateGramsCarb(Person person){
        BigDecimal gramsCarb = null;

        BigDecimal caloriesFromCarb = calorieCalculator.goalCalories(person)
                .multiply(person.getMacroRatio().getCarbRatio());

        return caloriesFromCarb.divide(CARB_CALORIES_PER_GRAM, 0, RoundingMode.HALF_UP);
    }
}
