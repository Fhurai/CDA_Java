package model;

import exception.CalculException;

public class Calculatrice {

    public static char PLUS = '+';
    public static char MINUS = '-';
    public static char MULTIPLY = '*';
    public static char DIVIDE = '/';

    public double calculer(char operateur, double var1, double var2) {

        switch (operateur) {
            case '+':
                return var1 + var2;
            case '-':
                return var1 - var2;
            case '*':
                return var1 * var2;
            case '/':
                if(var2 == 0) {
                    throw new CalculException("Division par zéro impossible");
                }else{
                    return var1 / var2;
                }
            default:
                throw new CalculException(operateur);
        }
    }
}
