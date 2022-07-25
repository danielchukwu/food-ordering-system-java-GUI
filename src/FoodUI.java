import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FoodUI {

    ArrayList<String> order = new ArrayList<String>();

    FoodUI (){
        this.order.add("Nothing");
        this.order.add("chips");
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
    }

    void printOrders() {
        System.out.println(this.order);
    }
}
