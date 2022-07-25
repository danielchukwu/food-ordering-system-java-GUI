import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

public class FoodUI {

    ArrayList<String> order = new ArrayList<String>();

    FoodUI (){
        System.out.println("FoodUI CREATED!");
    }

    void home() {

        JFrame homeFrame = new JFrame("Food Ordering System");
        homeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        homeFrame.setSize(400, 600);
        homeFrame.setLayout(new GridLayout(2, 1));

        // Add label
        JButton label = new JButton("The Wisdom");


        // Button
        Icon arrow = new ImageIcon(new ImageIcon("C:\\arrows\\double.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JButton seeMenuBtn = new JButton("see menu", arrow);

        // Adding
        homeFrame.add(label);
        homeFrame.add(seeMenuBtn);

        // make visible
        homeFrame.setVisible(true);

        seeMenuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.setVisible(false);
                menu();
            }
        });
    }

    void menu() {

        // Setup frame, size, layout, close operation
        JFrame menuFrame = new JFrame("Food Ordering System");
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setSize(400, 600);
        menuFrame.setLayout(new GridLayout(7, 2));

        // create buttons
        JButton friedRice = new JButton("fried rice");
        JButton jollofRice = new JButton("jollof rice");
        JButton beans = new JButton("beans");
        JButton plantain = new JButton("plantain");
        JButton spaghetti = new JButton("spaghetti");
        JButton sausage = new JButton("sausage");
        JButton meat = new JButton("meat");
        JButton chicken = new JButton("chicken");
        JButton eba = new JButton("eba");
        JButton semovita = new JButton("semovita");
        JButton egusi = new JButton("egusi");
        JButton vegetableSoup = new JButton("vegetable soup");
        JButton whiteRiceAndStew = new JButton("white rice & stew");
        JButton placeorder = new JButton("ORDER");

        // add buttons
        menuFrame.add(friedRice);
        menuFrame.add(jollofRice);
        menuFrame.add(beans);
        menuFrame.add(plantain);
        menuFrame.add(spaghetti);
        menuFrame.add(sausage);
        menuFrame.add(meat);
        menuFrame.add(chicken);
        menuFrame.add(eba);
        menuFrame.add(semovita);
        menuFrame.add(egusi);
        menuFrame.add(vegetableSoup);
        menuFrame.add(whiteRiceAndStew);
        menuFrame.add(placeorder);

        // make visible
        menuFrame.setVisible(true);

        // Set Button Listeners
        addOrder(friedRice, "fried rice");
        addOrder(jollofRice, "jollof rice");
        addOrder(beans, "beans");
        addOrder(plantain, "plantain");
        addOrder(spaghetti, "spaghetti");
        addOrder(sausage, "sausage");
        addOrder(meat, "meat");
        addOrder(chicken, "chicken");
        addOrder(eba, "eba");
        addOrder(semovita, "semovita");
        addOrder(egusi, "egusi");
        addOrder(vegetableSoup, "vegetable soup");
        addOrder(whiteRiceAndStew, "white rice & stew");

        // Place Order
        placeorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printOrders();
                if (order.size() > 0){
                    menuFrame.setVisible(false);
                    placeOrder();
                }
            }
        });
    }

    void placeOrder() {
        try {
            FileWriter file = new FileWriter("food orders.txt");

//            System.out.println("ORDER SIZE: " + order.size());
            for (int i=0; i < order.size(); i++){
                file.append(order.get(i) + "\n");
            }
            file.append("\nOrders: " + order.size());
            file.close();

            successfulOrder();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void successfulOrder() {
        // defaults, frame, close, frame size, frame layout
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new GridLayout(1, 1));

        // components
        JButton successfulBtn = new JButton("Order Placed Successfully!");

        // add
        frame.add(successfulBtn);

        // set visible
        frame.setVisible(true);
    }

    void addOrder(JButton foodBtn, String food) {
        foodBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (order.contains(food)){
                    System.out.println("already added");;
                } else {
                    order.add(food);
                }
            }
        });
    }

    void printOrders() {
        System.out.println(this.order);
    }
}
