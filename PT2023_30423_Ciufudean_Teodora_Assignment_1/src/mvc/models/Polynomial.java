package mvc.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    HashMap<Integer,Double> polynomial;

    public Polynomial(HashMap<Integer,Double> hashMap){
        this.polynomial = hashMap;
    }

    public HashMap<Integer, Double> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(HashMap<Integer, Double> polynomial) {
        this.polynomial = polynomial;
    }

    public Polynomial transformStringToPolynomial(String s){
        Double c;
        int e;
        Pattern pattern = Pattern.compile("(-?\\b\\d+)X\\^(-?\\d+\\b)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            c = Double.parseDouble(matcher.group(1));
            e= Integer.valueOf(matcher.group(2));
            this.polynomial.put(e,c);
        }
        Polynomial computedPolynomial = new Polynomial(polynomial);
        return computedPolynomial;
    }

    public int getDegree(){
        int deg=-1;
        for(Map.Entry<Integer, Double> P : this.getPolynomial().entrySet()){
            if(P.getValue()!=0)deg=P.getKey();
        }
        return deg;
    }

    public Polynomial getMonomWithMaxDegree(){
        HashMap<Integer,Double> hashMapMonom = new HashMap<>();
        Polynomial monom = new Polynomial(hashMapMonom);
        int degree = this.getDegree();
        this.getPolynomial().forEach((key,value)-> {
            if(key==degree){
                monom.getPolynomial().put(key,value);
            }
        });
        return monom;
    }

    @Override
    public String toString() {
        String[] s = {""};
        this.getPolynomial().forEach((key,value)-> {
            if(value>=0){
                if(!s[0].equals("")) s[0] = s[0] + "+" + value;
                else s[0] = s[0]+value;
            } else{
                if(!s[0].equals("")) s[0] = s[0] + value;
                else s[0] = s[0]+value;
            }
            s[0] = s[0] + "x^" + key;
        });
        return s[0];
    }
}
