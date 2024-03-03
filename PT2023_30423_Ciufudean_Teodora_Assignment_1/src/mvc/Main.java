package mvc;

import mvc.controllers.Controller;
import mvc.models.Operations;
import mvc.models.Polynomial;
import mvc.views.View;

import java.sql.Connection;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //HashMap<Integer,Double> hashMap1 =new HashMap<>();
        //HashMap<Integer,Double> hashMap2 =new HashMap<>();
        //HashMap<Integer,Double> hashMapRes =new HashMap<>();

        //hashMap1.put(2,2.0); 2X^2-6X^1+3X^0
        //hashMap1.put(1,-6.0);
        //hashMap1.put(0,3.0);

        //hashMap2.put(1,1.0);  1X^1+2X^0
        //hashMap2.put(0,2.0);
        //Polynomial p1 = new Polynomial(hashMap1);
       // Polynomial p2 = new Polynomial(hashMap2);
        //Polynomial p3 = new Polynomial(hashMapRes);
        //Operations operations = new Operations();
        //p3=operations.integration(p1);
        //System.out.println(p3.toString());
        //p3.computePolynomial("2X^3+3X^2-1");
        //p3.transformStringToPolynomial("2X^3+3X^2-1X^0");
        //System.out.println(p3.toString());
        View view = new View();
        Controller controller = new Controller(view);
        //X^3-4X^2+2X^0
        //p3=p3.transformStringToPolynomial("2X^2-4X^0+12X^3");
        //System.out.println(p1.getDegree());
        //operations.division(p1,p2,p3);
    }
}
