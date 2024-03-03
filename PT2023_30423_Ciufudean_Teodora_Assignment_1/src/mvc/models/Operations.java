package mvc.models;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Operations {

    public Polynomial addition (Polynomial polynomial1, Polynomial polynomial2){
        HashMap<Integer,Double> hashMapResult = new HashMap<>();
        Polynomial result = new Polynomial(hashMapResult);
        Double c;
        int e;
        for (Map.Entry<Integer,Double> P: polynomial1.getPolynomial().entrySet()){
            c = P.getValue();
            e = P.getKey();
            result.getPolynomial().put(e,c);
        }
        for (Map.Entry<Integer,Double> Q: polynomial2.getPolynomial().entrySet()){
            c=Q.getValue();
            e=Q.getKey();
            if(result.getPolynomial().containsKey(e)){
                Double cr =result.getPolynomial().get(e);
                if(c+cr!=0)result.getPolynomial().put(e,c+cr);
                else result.getPolynomial().remove(e);
            } else {
                result.getPolynomial().put(e,c);
            }
        }
        return result;
    }

    public Polynomial subtraction (Polynomial polynomial1,Polynomial polynomial2){
        HashMap<Integer,Double> hashMapResult = new HashMap<>();
        Polynomial result = new Polynomial(hashMapResult);
        Double c;
        int e;
        for (Map.Entry<Integer,Double> P: polynomial1.getPolynomial().entrySet()){
            c = P.getValue();
            e = P.getKey();
            result.getPolynomial().put(e,c);
        }
        for (Map.Entry<Integer,Double> Q: polynomial2.getPolynomial().entrySet()){
            c=Q.getValue();
            e=Q.getKey();
            if(result.getPolynomial().containsKey(e)){
                Double cr =result.getPolynomial().get(e);
                if(cr-c!=0)result.getPolynomial().put(e,cr-c);
                else result.getPolynomial().remove(e);
            } else {
                result.getPolynomial().put(e,c*(-1));
            }
        }
        return result;
    }

    public Polynomial multiplication (Polynomial polynomial1, Polynomial polynomial2) {
        HashMap<Integer, Double> hashMapResult = new HashMap<>();
        Polynomial result = new Polynomial(hashMapResult);
        Double c;
        int e;
        for (Map.Entry<Integer, Double> P : polynomial1.getPolynomial().entrySet()) {
            for (Map.Entry<Integer, Double> Q : polynomial2.getPolynomial().entrySet()) {
                c = P.getValue() * Q.getValue();
                e = P.getKey() + Q.getKey();
                if (result.getPolynomial().containsKey(e)) {
                    c = c + result.getPolynomial().get(e);
                }
                if(c!=0) hashMapResult.put(e, c);
            }
        }
        return result;
    }

    public Polynomial derivative (Polynomial polynomial){
        HashMap<Integer,Double> hashMapResult = new HashMap<>();
        Polynomial result = new Polynomial(hashMapResult);
        Double c;
        int e;
        for (Map.Entry<Integer,Double> P: polynomial.getPolynomial().entrySet()){
            c = P.getValue();
            e = P.getKey();
            if(e!=0) {
                result.getPolynomial().put(e - 1, c * e);
            }else{
                result.getPolynomial().put(e,c);
            }

        }
        return result;
    }

    public Polynomial integration (Polynomial polynomial) {
        HashMap<Integer, Double> hashMapResult = new HashMap<>();
        Polynomial result = new Polynomial(hashMapResult);
        Double c;
        int e;
        for (Map.Entry<Integer, Double> P : polynomial.getPolynomial().entrySet()) {
            c = P.getValue();
            e = P.getKey();
            result.getPolynomial().put(e+1,c/(e+1));
        }
        return result;
    }

    public String division (Polynomial polynomial1, Polynomial polynomial2, Polynomial quotient){
        HashMap<Integer, Double> hashMapAux = new HashMap<>();
        HashMap<Integer, Double> hashMapmonom1 = new HashMap<>();
        HashMap<Integer, Double> hashMapmonom2 = new HashMap<>();
        Polynomial aux = new Polynomial(hashMapAux);
        Polynomial monom1 = new Polynomial(hashMapmonom1);
        Polynomial monom2 = new Polynomial(hashMapmonom2);
        while (polynomial1.getDegree()!=-1 && polynomial1.getDegree()>= polynomial2.getDegree()){
            monom1 = polynomial1.getMonomWithMaxDegree();
            monom2 = polynomial2.getMonomWithMaxDegree();
            aux.getPolynomial().put(monom1.getDegree()- monom2.getDegree(),monom1.getPolynomial().get(monom1.getDegree())/monom2.getPolynomial().get(monom2.getDegree()));
            quotient = addition(quotient,aux);
            polynomial1 = subtraction(polynomial1,multiplication(aux,polynomial2));
            aux.getPolynomial().clear();
        }
        String res = "";
        res = "Q: " + quotient.toString() + " ,  R: " + polynomial1.toString();
        return res;
    }
}

