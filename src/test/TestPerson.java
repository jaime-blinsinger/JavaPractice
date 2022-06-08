package test;

import main.MacroRatio;
import main.Measurements;
import main.Person;
import org.junit.Test;

import java.math.BigDecimal;

public class TestPerson {

    //goal = deficit
    Measurements jaimeMeasurements = new Measurements.Builder()
            .heightCentimeters(new BigDecimal("175"))
            .currentWeightKilograms(new BigDecimal("80"))
            .goalWeightKilograms(new BigDecimal("60"))
            .build();

    //manually set with the same macros as the default
    MacroRatio jaimeMacroRatio = new MacroRatio.Builder()
            .proteinRatio(new BigDecimal(".3"))
            .fatRatio(new BigDecimal(".3"))
            .carbRatio(new BigDecimal(".4"))
            .build();

    Person jaime = new Person.Builder()
            .name("Jaime")
            .age(new BigDecimal("29"))
            .gender(Person.Gender.FEMALE)
            .activityLevel(Person.ActivityLevel.LIGHTLY_ACTIVE)
            .measurements(jaimeMeasurements)
            .macroRatio(jaimeMacroRatio)
            .build();


    //goal = deficit
    Measurements robMeasurements = new Measurements.Builder()
            .heightCentimeters(new BigDecimal("183"))
            .currentWeightKilograms(new BigDecimal("86"))
            .goalWeightKilograms(new BigDecimal("79"))
            .build();

    //uses default macro ratios

    Person rob = new Person.Builder()
            .name("Rob")
            .age(new BigDecimal("30"))
            .gender(Person.Gender.MALE)
            .activityLevel(Person.ActivityLevel.MODERATELY_ACTIVE)
            .measurements(robMeasurements)
            .macroRatio(new MacroRatio.Builder().build())
            .build();


    //goal = bulk
    Measurements bobbyMeasurements = new Measurements.Builder()
            .heightCentimeters(new BigDecimal("185"))
            .currentWeightKilograms(new BigDecimal("77"))
            .goalWeightKilograms(new BigDecimal("84"))
            .build();

    MacroRatio bobbyMacroRatio = new MacroRatio.Builder()
            .proteinRatio(new BigDecimal(".3"))
            .fatRatio(new BigDecimal(".3"))
            .carbRatio(new BigDecimal(".4"))
            .build();

    Person bobby = new Person.Builder()
            .name("Bobby")
            .age(new BigDecimal("58"))
            .gender(Person.Gender.MALE)
            .activityLevel(Person.ActivityLevel.VERY_ACTIVE)
            .measurements(bobbyMeasurements)
            .macroRatio(bobbyMacroRatio)
            .build();


    //goal = maintenance
    Measurements ellenMeasurements = new Measurements.Builder()
            .heightCentimeters(new BigDecimal("160"))
            .currentWeightKilograms(new BigDecimal("50"))
            .goalWeightKilograms(new BigDecimal("50"))
            .build();

    MacroRatio ellenMacroRatio = new MacroRatio.Builder()
            .proteinRatio(new BigDecimal(".3"))
            .fatRatio(new BigDecimal(".3"))
            .carbRatio(new BigDecimal(".4"))
            .build();

    Person ellen = new Person.Builder()
            .name("Ellen")
            .age(new BigDecimal("56"))
            .gender(Person.Gender.FEMALE)
            .activityLevel(Person.ActivityLevel.SEDENTARY)
            .measurements(ellenMeasurements)
            .macroRatio(ellenMacroRatio)
            .build();

    //@Test(expected = NullPointerException.class)
    //public void testValidateName(){
        //TODO: do I need to validate in all of my setters???
        //jaime.setName(null);
/*        Measurements test = new Measurements.Builder()
                .heightCentimeters(new BigDecimal("150"))
                .currentWeightKilograms(new BigDecimal("60"))
                .goalWeightKilograms(new BigDecimal("60"))
                .build();

        Person testNameNull = new Person.Builder()
                .name(null)
                .age(new BigDecimal("30"))
                .gender(Person.Builder.Gender.FEMALE)
                .activityLevel(Person.Builder.ActivityLevel.SEDENTARY)
                .measurements(test)
                .build();
    } */

    @Test(expected = NullPointerException.class)
    public void testValidateAge(){
        Measurements test = new Measurements.Builder()
                .heightCentimeters(new BigDecimal("150"))
                .currentWeightKilograms(new BigDecimal("60"))
                .goalWeightKilograms(new BigDecimal("60"))
                .build();

        Person testNameNull = new Person.Builder()
                .name("Jaime")
                .age(null)
                .gender(Person.Gender.FEMALE)
                .activityLevel(Person.ActivityLevel.SEDENTARY)
                .measurements(test)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testValidateGender(){
        Measurements test = new Measurements.Builder()
                .heightCentimeters(new BigDecimal("150"))
                .currentWeightKilograms(new BigDecimal("60"))
                .goalWeightKilograms(new BigDecimal("60"))
                .build();

        Person testNameNull = new Person.Builder()
                .name("Jaime")
                .age(new BigDecimal("30"))
                .gender(null)
                .activityLevel(Person.ActivityLevel.SEDENTARY)
                .measurements(test)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testValidateActivityLevel(){
        Measurements test = new Measurements.Builder()
                .heightCentimeters(new BigDecimal("150"))
                .currentWeightKilograms(new BigDecimal("60"))
                .goalWeightKilograms(new BigDecimal("60"))
                .build();

        Person testNameNull = new Person.Builder()
                .name("Jaime")
                .age(new BigDecimal("30"))
                .gender(Person.Gender.FEMALE)
                .activityLevel(null)
                .measurements(test)
                .build();
    }

}
