import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

public class FoodUI {

    ArrayList<String> order = new ArrayList<String>();
    String [] foods = {"fried rice", "jollof rice", "beans", "plantain", "spaghetti", "saussage", "meat", "chicken", "eba", "semovita", "egusi", "vegetable soup", "white rice & stew"};

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

        for (int i = 0; i < foods.length; i++) {
            String foodName = foods[i];
            JButton foodBtn = new JButton(foodName);
            menuFrame.add(foodBtn);

            foodBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (order.contains(foodName)){
                        System.out.println("already added");;
                    } else {
                        order.add(foodName);
                    }
                }
            });
        }

        // create order button and add
        JButton orderBtn = new JButton("Order Button");
        menuFrame.add(orderBtn);

        // Add event listener on orderBtn
        orderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printOrders();
                if (order.size() > 0){
                    menuFrame.setVisible(false);
                    placeOrder();
                }
            }
        });

        // make visible
        menuFrame.setVisible(true);
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

    void printOrders() {
        System.out.println(this.order);
    }
}
