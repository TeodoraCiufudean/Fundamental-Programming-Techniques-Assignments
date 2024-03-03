package mvc.controllers;

import mvc.models.Monomial;
import mvc.models.Operations;
import mvc.models.Polynomial;
import mvc.views.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
        private View view;
        private HashMap<Integer,Double> hashMap1 =new HashMap<>();
        private HashMap<Integer,Double> hashMap2 =new HashMap<>();
        private HashMap<Integer,Double> hashResult =new HashMap<>();
        private Polynomial P1 = new Polynomial(hashMap1);
        private Polynomial P2 = new Polynomial(hashMap2);
        private Polynomial result = new Polynomial(hashResult);
        private Operations operation = new Operations();

        public Controller(View view){
            this.view = view;
            this.view.addAdditionButton(new AdditionListener());
            this.view.addSubstractionButton(new SubtractionListener());
            this.view.addDerivationButton(new DerivativeListener());
            this.view.addMultiplycationButton(new MultiplicationListener());
            this.view.addIntegrationButton(new IntegrationListener());
            this.view.addDivisionButton(new DivisionListener());
        }

        class AdditionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputString1 = view.getP1textField();
                String inputString2 = view.getP2textField();
                P1 = P1.transformStringToPolynomial(inputString1);
                P2 = P2.transformStringToPolynomial(inputString2);
                if (P1.toString().length()>=inputString1.length() && P2.toString().length()>=inputString2.length()) {
                    result = operation.addition(P1, P2);
                    view.setResultField(result.toString());
                }else {
                    view.showErrorMessage("Invalid input.");

                }
            }
        }

        class SubtractionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputString1 = view.getP1textField();
                String inputString2 = view.getP2textField();
                P1 = P1.transformStringToPolynomial(inputString1);
                P2 = P2.transformStringToPolynomial(inputString2);
                if (P1.toString().length()>=inputString1.length() && P2.toString().length()>=inputString2.length()) {
                    result = operation.subtraction(P1, P2);
                    view.setResultField(result.toString());
                }else{
                    view.showErrorMessage("Invalid input.");
                }

            }
        }

        class MultiplicationListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputString1 = view.getP1textField();
                String inputString2 = view.getP2textField();
                P1 = P1.transformStringToPolynomial(inputString1);
                P2 = P2.transformStringToPolynomial(inputString2);
                if (P1.toString().length()>=inputString1.length() && P2.toString().length()>=inputString2.length()) {
                    result = operation.multiplication(P1, P2);
                    view.setResultField(result.toString());
                }else{
                    view.showErrorMessage("Invalid input.");
                }

            }
        }

        class DerivativeListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputString1 = view.getP1textField();
                P1 = P1.transformStringToPolynomial(inputString1);
                if(P1.toString().length()>=inputString1.length()){
                    result = operation.derivative(P1);
                    view.setResultField(result.toString());
                }else {
                    view.showErrorMessage("Bad input.");
                }
            }
        }

        class IntegrationListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputString1 = view.getP1textField();
                P1 = P1.transformStringToPolynomial(inputString1);
                if(P1.toString().length()>=inputString1.length()) {
                    result = operation.integration(P1);
                    view.setResultField(result.toString());
                }else{
                    view.showErrorMessage("Bad input.");
                }
            }

        }

        class DivisionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputString1 = view.getP1textField();
                String inputString2 = view.getP2textField();
                P1 = P1.transformStringToPolynomial(inputString1);
                P2 = P2.transformStringToPolynomial(inputString2);
                if (P1.toString().length()>=inputString1.length() && P2.toString().length()>=inputString2.length() && P1.getDegree()>= P2.getDegree()) {
                    HashMap<Integer, Double> hashMapQuotient = new HashMap<>();
                    Polynomial quotient = new Polynomial(hashMapQuotient);
                    view.setResultField(operation.division(P1, P2, quotient));
                }else{
                    view.showErrorMessage("Bad input.");
                }
            }
        }

}
