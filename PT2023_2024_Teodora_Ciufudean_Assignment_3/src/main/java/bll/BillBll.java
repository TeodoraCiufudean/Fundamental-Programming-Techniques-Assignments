package bll;

import dao.BillDAO;
import model.Bill;
import model.Order;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The BillBll class represents the business logic layer for managing Bill objects.
 * It provides methods to interact with the BillDAO and perform operations such as inserting bills,
 * retrieving bills, and generating a JTable representation of bills.
 */
public class BillBll {
    private BillDAO billDAO;

    /**
     * Constructs a BillBll object and initializes the BillDAO.
     */
    public BillBll() {
        billDAO = new BillDAO();
    }

    /**
     * Inserts a Bill object into the data store using the BillDAO.
     *
     * @param bill The Bill object to be inserted.
     */
    public void insertBill(Bill bill) {
        billDAO.insert(bill);
    }

    /**
     * Retrieves a list of all Bill objects from the data store using the BillDAO.
     *
     * @return A list of Bill objects.
     */
    public List<Bill> Billfind() {
        return billDAO.find();
    }

    /**
     * Generates a JTable representation of the given list of Bill objects using the BillDAO.
     *
     * @param bills The list of Bill objects to be represented as a JTable.
     * @return A JTable representation of the bills.
     */
    public JTable BillTable(ArrayList<Bill> bills) {
        return billDAO.jTable(bills);
    }
}
