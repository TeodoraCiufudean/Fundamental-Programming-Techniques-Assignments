package presentation;

import bll.BillBll;
import bll.ClientBll;
import bll.OrderBll;
import bll.ProductBll;
import model.Bill;
import model.Client;
import model.Order;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * The controller class that manages the interaction between the views and the business logic.
 */
public class Controller {
    private MainView mainView;
    private ClientView clientView;
    private ProductView productView;
    private OrderView orderView;
    private ClientBll clientBll = new ClientBll();
    private ProductBll productBll = new ProductBll();
    private OrderBll orderBll = new OrderBll();
    private BillBll billBll = new BillBll();

    /**
     * Constructs a new Controller with the specified views.
     *
     * @param mainView    The main view.
     * @param clientView  The client view.
     * @param productView The product view.
     * @param orderView   The order view.
     */
    public Controller(MainView mainView, ClientView clientView, ProductView productView, OrderView orderView) {
        this.mainView = mainView;
        this.clientView = clientView;
        this.productView = productView;
        this.orderView = orderView;

        // Register event listeners for the main view buttons
        this.mainView.addClientButtonListener(new ClientListener());
        this.mainView.addProductButtonListener(new ProductListener());
        this.mainView.addOrderButtonListener(new OrderListener());

        // Register event listeners for the client view buttons
        this.clientView.addAddButtonListener(new ClientAddListener());
        this.clientView.addDeleteButtonListener(new ClientDeleteListener());
        this.clientView.addEditButtonListener(new ClientUpdateListener());
        this.clientView.addViewAllButtonListener(new ClientViewAllListener());
        this.clientView.addBackButtonListener(new ClientBackListener());

        // Register event listeners for the product view buttons
        this.productView.addAddButtonListener(new ProductAddListener());
        this.productView.addDeleteButtonListener(new ProductDeleteListener());
        this.productView.addEditButtonListener(new ProductUpdateListener());
        this.productView.addViewAllButtonListener(new ProductViewAllListener());
        this.productView.addBackButtonListener(new ProductBackListener());

        // Register event listeners for the order view buttons
        this.orderView.addAddButtonListener(new OrderAddListener());
        this.orderView.addViewAllButtonListener(new OrderViewAllListener());
        this.orderView.addBackButtonListener(new OrderBackListener());
        this.orderView.addBillButtonListener(new BillListener());
    }

    // Event listener classes for the main view buttons

    /**
     * Event listener for the Client button in the main view.
     */
    class ClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the client view and hide other views
            clientView.setVisible(true);
            mainView.setVisible(false);
            productView.setVisible(false);
            orderView.setVisible(false);
        }
    }

    /**
     * Event listener for the Product button in the main view.
     */
    class ProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the product view and hide other views
            productView.setVisible(true);
            clientView.setVisible(false);
            mainView.setVisible(false);
            orderView.setVisible(false);
        }
    }

    /**
     * Event listener for the Order button in the main view.
     */
    class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the order view and hide other views
            orderView.setVisible(true);
            productView.setVisible(false);
            clientView.setVisible(false);
            mainView.setVisible(false);
        }
    }

    // Event listener classes for the client view buttons

    /**
     * Event listener for the Back button in the client view.
     */
    class ClientBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the main view and hide the client view
            mainView.setVisible(true);
            clientView.setVisible(false);
        }
    }

    /**
     * Event listener for the Add button in the client view.
     */
    class ClientAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new Client object from the client view input fields
            Client client = new Client(clientView.getIdTextField(), clientView.getNameTextField(), clientView.getAgeTextField(), clientView.getAddressTextField());
            try {
                // Insert the client into the database
                clientBll.insertClient(client);
                clientView.showInfoMessage("Client was added.");
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Event listener for the Delete button in the client view.
     */
    class ClientDeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Delete the client with the specified ID
            clientBll.deleteClient(clientView.getIdTextField());
            clientView.showInfoMessage("Client was deleted.");
        }
    }

    /**
     * Event listener for the Edit button in the client view.
     */
    class ClientUpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new Client object from the client view input fields
            Client client = new Client(clientView.getIdTextField(), clientView.getNameTextField(), clientView.getAgeTextField(), clientView.getAddressTextField());
            try {
                // Update the client with the specified ID
                clientBll.updateClient(client, clientView.getIdTextField());
                clientView.showInfoMessage("Client was updated.");
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Event listener for the View All button in the client view.
     */
    class ClientViewAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Retrieve all clients from the database
            ArrayList<Client> clientsList = new ArrayList<>();
            clientsList.addAll(clientBll.viewAllClients());
            // Create a JTable from the client list and set it in the client view
            JTable table = clientBll.ClientTable(clientsList);
            clientView.getScrollPane().setViewportView(table);
        }
    }

    // Event listener classes for the product view buttons

    /**
     * Event listener for the Back button in the product view.
     */
    class ProductBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the main view and hide the product view
            mainView.setVisible(true);
            productView.setVisible(false);
        }
    }

    /**
     * Event listener for the Add button in the product view.
     */
    class ProductAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new Product object from the product view input fields
            Product product = new Product(productView.getIdTextField(), productView.getNameTextField(), productView.getStockTextField());
            try {
                // Insert the product into the database
                productBll.insertProduct(product);
                productView.showInfoMessage("Product was added.");
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Event listener for the Delete button in the product view.
     */
    class ProductDeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Delete the product with the specified ID
            productBll.deleteProduct(productView.getIdTextField());
            productView.showInfoMessage("Product was deleted.");
        }
    }

    /**
     * Event listener for the Edit button in the product view.
     */
    class ProductUpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a new Product object from the product view input fields
            Product product = new Product(productView.getIdTextField(), productView.getNameTextField(), productView.getStockTextField());
            try {
                // Update the product with the specified ID
                productBll.updateProduct(product, clientView.getIdTextField());
                productView.showInfoMessage("Product was updated.");
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Event listener for the View All button in the product view.
     */
    class ProductViewAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Retrieve all products from the database
            List<Product> productsList = new ArrayList<>();
            productsList.addAll(productBll.viewAllProducts());
            // Create a JTable from the product list and set it in the product view
            JTable table = productBll.ProductTable((ArrayList<Product>) productsList);
            productView.getScrollPane().setViewportView(table);
        }
    }

    // Event listener classes for the order view buttons

    /**
     * Event listener for the Back button in the order view.
     */
    class OrderBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the main view and hide the order view
            mainView.setVisible(true);
            orderView.setVisible(false);
        }
    }

    /**
     * Event listener for the Add button in the order view.
     */
    class OrderAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the selected client and product IDs from the order view combo boxes
            int clientId = (int) orderView.getClientComboBox().getSelectedItem();
            int productId = (int) orderView.getProductComboBox().getSelectedItem();
            // Create a new Order object from the order view input fields
            Order order = new Order(orderView.getOrderNoTextField(), clientId, productId, orderView.getQuantityTextField());
            // Create a new Bill object from the order view input fields and client/product information
            Bill bill = new Bill(orderView.getOrderNoTextField(), clientBll.findClientById(clientId).getName(), clientBll.findClientById(clientId).getAddress(), productBll.findProductById(productId).getName(), orderView.getQuantityTextField());
            try {
                // Insert the order and bill into the database
                orderBll.insertOrder(order);
                billBll.insertBill(bill);
                orderView.showInfoMessage("Order was created.");
                //} catch (IllegalAccessException ex) {
            }catch (Exception ex){
                orderView.showInfoMessage("Negative quantity");
                throw new RuntimeException(ex);

            }
        }
    }

    /**
     * Event listener for the View All button in the order view.
     */
    class OrderViewAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Retrieve all orders from the database
            List<Order> orderList = new ArrayList<>();
            orderList.addAll(orderBll.viewAllOrders());
            // Create a JTable from the order list and set it in the order view
            JTable table = orderBll.OrderTable((ArrayList<Order>) orderList);
            orderView.getScrollPane().setViewportView(table);
        }
    }

    /**
     * Event listener for the Bill button in the order view.
     */
    class BillListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Bill> billList = new ArrayList<>();
            billList.addAll(billBll.Billfind());
            JTable tableBll = billBll.BillTable((ArrayList<Bill>) billList);
            orderView.getScrollPane().setViewportView(tableBll);
            try {
                FileWriter fileWriter = new FileWriter("bill.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for(Bill bill : billList){
                    printWriter.println(bill.toString());
                }
                fileWriter.close();
                printWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
