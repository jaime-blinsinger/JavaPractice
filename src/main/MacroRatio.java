package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MacroRatio {

    public static final BigDecimal DEFAULT_PROTEIN_RATIO = new BigDecimal("0.3");
    public static final BigDecimal DEFAULT_FAT_RATIO = new BigDecimal("0.3");
    public static final BigDecimal DEFAULT_CARB_RATIO = new BigDecimal("0.4");

    private BigDecimal proteinRatio = DEFAULT_PROTEIN_RATIO;
    private BigDecimal fatRatio = DEFAULT_FAT_RATIO;
    private BigDecimal carbRatio = DEFAULT_CARB_RATIO;

    public void validate(){
        if (proteinRatio == null || fatRatio == null || carbRatio == null){
            throw new NullPointerException("Protein, Fat, and Carb ratios cannot be null.");
        }

        BigDecimal totalRatio = proteinRatio.add(fatRatio).add(carbRatio).setScale(1, RoundingMode.HALF_UP);
        if (!totalRatio.equals(new BigDecimal("1.0"))) {
            throw new ArithmeticException("Protein, carb, and fat ratio values must add to 1 (100%).");
        }

        //if protein, carb, or fat ratios are negative
        if (proteinRatio.compareTo(new BigDecimal("0")) < 0 ||
                fatRatio.compareTo(new BigDecimal("0")) < 0 ||
                carbRatio.compareTo(new BigDecimal("0")) < 0) {

            throw new IllegalArgumentException("Protein, Carb, and Fat ratio values cannot be negative");
        }
    }

    public void setProteinRatio(BigDecimal proteinRatio) {
        this.proteinRatio = proteinRatio;
    }

    public void setFatRatio(BigDecimal fatRatio) {
        this.fatRatio = fatRatio;
    }

    public void setCarbRatio(BigDecimal carbRatio) {
        this.carbRatio = carbRatio;
    }

    public BigDecimal getProteinRatio() {
        return proteinRatio;
    }

    public BigDecimal getFatRatio() {
        return fatRatio;
    }

    public BigDecimal getCarbRatio() {
        return carbRatio;
    }

    public static class Builder {

        //TODO: FEEDBACK LEFT HERE TO SET PROTEIN/FAT/CARB DEFAULTS IN MacroRatio - BUT THEN IT THROWS A NULL
        // POINTER EXCEPTION IF NOT SET IN BUILDER. WHY SWITCH IT? OR HOW TO AVOID EXCEPTION AND SET TO DEFAULT INSTEAD?

        private MacroRatio macroRatio = new MacroRatio();

        public Builder proteinRatio (final BigDecimal proteinRatio){
            this.macroRatio.setProteinRatio(proteinRatio);
            return this;
        }

        public Builder fatRatio (final BigDecimal fatRatio){
            this.macroRatio.setFatRatio(fatRatio);

            return this;
        }

        public Builder carbRatio (final BigDecimal carbRatio){
            this.macroRatio.setCarbRatio(carbRatio);
            return this;
        }

        public MacroRatio build () {
            macroRatio.validate();
            return macroRatio;
        }
    }
}
