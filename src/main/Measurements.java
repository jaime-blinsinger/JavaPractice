package main;

import java.math.BigDecimal;

public class Measurements {

    private BigDecimal heightCentimeters;
    private BigDecimal currentWeightKilograms;
    private BigDecimal goalWeightKilograms;

    public void validate(){
        if(heightCentimeters == null || currentWeightKilograms == null || goalWeightKilograms == null) {
            throw new NullPointerException("Height (cm), Current Weight (kg), and Goal Weight (kg) cannot be null.");
        }
    }

    public void setHeightCentimeters(BigDecimal heightCentimeters) {
        this.heightCentimeters = heightCentimeters;
    }

    public void setCurrentWeightKilograms(BigDecimal currentWeightKilograms) {
        this.currentWeightKilograms = currentWeightKilograms;
    }

    public void setGoalWeightKilograms(BigDecimal goalWeightKilograms) {
        this.goalWeightKilograms = goalWeightKilograms;
    }

    public BigDecimal getHeightCentimeters() {
        return heightCentimeters;
    }

    public BigDecimal getCurrentWeightKilograms() {
        return currentWeightKilograms;
    }

    public BigDecimal getGoalWeightKilograms() {
        return goalWeightKilograms;
    }

    public static class Builder {
        private BigDecimal heightCentimeters;
        private BigDecimal currentWeightKilograms;
        private BigDecimal goalWeightKilograms;

        public Builder heightCentimeters(final BigDecimal heightCentimeters){
            this.heightCentimeters = heightCentimeters;
            return this;
        }

        public Builder currentWeightKilograms(final BigDecimal currentWeightKilograms){
            this.currentWeightKilograms = currentWeightKilograms;
            return this;
        }

        public Builder goalWeightKilograms(final BigDecimal goalWeightKilograms){
            this.goalWeightKilograms = goalWeightKilograms;
            return this;
        }

        public Measurements build(){
            Measurements measurements = new Measurements();
            measurements.setHeightCentimeters(heightCentimeters);
            measurements.setCurrentWeightKilograms(currentWeightKilograms);
            measurements.setGoalWeightKilograms(goalWeightKilograms);
            measurements.validate();
            return measurements;
        }
    }
}
