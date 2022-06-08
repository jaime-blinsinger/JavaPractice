package main;

import java.math.BigDecimal;

public class Person {

    public enum Gender {
        MALE,
        FEMALE
    }

    public enum ActivityLevel {

        SEDENTARY (new BigDecimal("1.2")),     //no exercise and seated job
        LIGHTLY_ACTIVE (new BigDecimal("1.375")),     //3x exercise per week or active job
        MODERATELY_ACTIVE (new BigDecimal("1.55")),     //5x exercise per week or strenuous job
        VERY_ACTIVE (new BigDecimal("1.725"));     //5x+ exercise per week and strenuous job

        public final BigDecimal multiplierValue;

        private ActivityLevel (BigDecimal multiplierValue){
            this.multiplierValue = multiplierValue;
        }
    }

    private String name;
    private BigDecimal age;
    private Person.Gender gender;
    private Person.ActivityLevel activityLevel;
    private Measurements measurements;
    private MacroRatio macroRatio;

    public void validate(){
        if (name == null || age == null || gender == null || activityLevel == null){
            throw new NullPointerException("Name, Age, Gender, and Activity Level are required fields and cannot be null.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public void setGender(Person.Gender gender) {
        this.gender = gender;
    }

    public void setActivityLevel(Person.ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void setMeasurements(Measurements measurements) {
        this.measurements = measurements;
    }

    public void setMacroRatio(MacroRatio macroRatio) {
        this.macroRatio = macroRatio;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAge() {
        return age;
    }

    public Person.Gender getGender() {
        return gender;
    }

    public Person.ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public Measurements getMeasurements() {
        return measurements;
    }

    public MacroRatio getMacroRatio() {
        return macroRatio;
    }

    public static class Builder {

        private String name;
        private BigDecimal age;
        private Gender gender;
        private ActivityLevel activityLevel;
        private Measurements measurements;
        private MacroRatio macroRatio;

        public Builder name(final String name){
            this.name = name;
            return this;
        }

        public Builder age(final BigDecimal age){
            this.age = age;
            return this;
        }

        public Builder gender(final Gender gender){
            this.gender = gender;
            return this;
        }

        public Builder activityLevel(final ActivityLevel activityLevel){
            this.activityLevel = activityLevel;
            return this;
        }

        public Builder measurements(final Measurements measurements){
            this.measurements = measurements;
            return this;
        }

        public Builder macroRatio(final MacroRatio macroRatio){
            this.macroRatio = macroRatio;
            return this;
        }

        public Person build(){
            Person person = new Person();

            person.setName(name);
            person.setAge(age);
            person.setGender(gender);
            person.setActivityLevel(activityLevel);
            person.setMeasurements(measurements);
            person.setMacroRatio(macroRatio);
            person.validate();

            return person;
        }
    }
}