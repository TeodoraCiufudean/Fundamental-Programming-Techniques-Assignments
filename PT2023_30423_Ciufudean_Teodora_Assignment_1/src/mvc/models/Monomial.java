package mvc.models;

import java.util.HashMap;

public class Monomial {
    Double coefficient;
    int power;

    public Monomial(double coefficient, int power){
        this.coefficient = coefficient;
        this.power = power;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
