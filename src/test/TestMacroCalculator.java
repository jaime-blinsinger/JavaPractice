package test;

import main.MacroCalculator;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class TestMacroCalculator {

    MacroCalculator macroCalculator = new MacroCalculator();
    TestPerson testPerson = new TestPerson();

    @Test
    //gramsProtein = (goal calories * protein ratio) / 4
    public void testCalculateGramsProtein(){
        //jaime goal calories = 1705; defaulted protein ratio = 0.3
        assertEquals(new BigDecimal("128"), macroCalculator.calculateGramsProtein(testPerson.jaime));
    }

    @Test
    //gramsFat = (goal calories * fat ratio) / 9
    public void testCalculateGramsFat(){
        //jaime goal calories = 1705; defaulted fat ratio = 0.3
        assertEquals(new BigDecimal("57"), macroCalculator.calculateGramsFat(testPerson.jaime));
    }

    @Test
    //gramsCarb = (goal calories * carb ratio) / 4
    public void testCalculateGramsCarb(){
        //jaime goal calories = 1705; defaulted carb ratio = 0.4
        assertEquals(new BigDecimal("171"), macroCalculator.calculateGramsCarb(testPerson.jaime));
    }
}
