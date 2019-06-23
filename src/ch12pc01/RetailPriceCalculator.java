package ch12pc01;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Frank
 * 
 * Outer class that creates the GUI
 */
public class RetailPriceCalculator extends JFrame{
    //fields
    private JPanel panel;
    private JLabel lblWholeSale;
    private JLabel  lblMarkup;
    private JLabel lblRetailPrice;
    private JTextField txtWholeSale;
    private JTextField txtMarkup;
    private JTextField txtRetailPrice;
    private JButton btnCalculate;
    
    private final int width = 500;
    private final int height = 300;
    
    //Constructor
    public RetailPriceCalculator(){
        this.setTitle("Retail Calculator");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        this.add(panel);
        this.setVisible(true);
    }
    
    private void buildPanel() {
        panel = new JPanel();
        lblWholeSale = new JLabel("Please enter the wholesale price: ");
        lblMarkup = new JLabel("Please enter the markup percentage: ");
        lblRetailPrice = new JLabel("The total retail price is: ");
        txtWholeSale = new JTextField(10);
        txtMarkup = new JTextField(10);
        txtRetailPrice = new JTextField(10);
        btnCalculate = new JButton("Calculate the Retail Price");
        btnCalculate.addActionListener(new btnCalculateListener());
        
        //add items to panel
        panel.add(lblWholeSale);
        panel.add(txtWholeSale);
        panel.add(lblMarkup);
        panel.add(txtMarkup);
        panel.add(btnCalculate);
        panel.add(lblRetailPrice);
        panel.add(txtRetailPrice);
    }
    
    //inner class
    private class btnCalculateListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            String whole, mark;
            double wholesale, markup, retail;
            whole = txtWholeSale.getText();
            mark = txtMarkup.getText();
            
            wholesale = Double.parseDouble(whole);
            markup = (Double.parseDouble(mark)) / 100;

            retail = (wholesale * markup) + wholesale;
            txtRetailPrice.setText(Double.toString(retail));
                        
        }
    }
}
