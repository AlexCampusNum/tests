package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Additionner 2 nombres")
    void add() {
        assertEquals(4, calculator.add(2,2));
        assertEquals(4463, calculator.add(1245,3218));
    }

    @Test
    @DisplayName("Soustraire 2 nombres")
    void subtract() {
        assertEquals(0, calculator.subtract(2, 2));
        assertEquals(50208, calculator.subtract(51564, 1356));
    }

    @Test
    @DisplayName("Multiplier 2 nombres")
    void multiply() {
        assertEquals(20, calculator.multiply(5, 4));
        assertEquals(249804, calculator.multiply(514, 486));
//        assertEquals(999999998, calculator.multiply(9999, 9999));
    }

    @Test
    @DisplayName("Diviser 2 nombres")
    void divide() {
        assertEquals(4, calculator.divide(20, 5));
        assertEquals(101, calculator.divide(321584, 3184));
//        assertEquals(101.0, calculator.divide(321684, 3184));    pour le float il ne met qu'un chiffre après la virgule, après on passe en double
        assertEquals(101.0314070351759, calculator.divide(321684, 3184), 0.0000000000001);
        assertEquals(101.03140703517587, calculator.divide(321684, 3184), 0.00000000000001);
//        assertEquals(101.0314070351758712346, calculator.divide(321684, 3184), 0.0000000000000000001);    pour que ce test soit vraiment concluant il faut passer à la classe BigDecimal qu'il faut importer
        assertEquals(101.03141, calculator.divide(321684, 3184), 0.00001);
//        assertEquals(100, calculator.divide(321684, 3184));  fonctionne si on reste en int pour typer la fonction divide dans Calculator


    }

    @Test
    @DisplayName("Diviser par zéro")
    void divideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0), "Division par zéro non autorisée.");
    }


}