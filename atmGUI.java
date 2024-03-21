import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class atmGUI extends JFrame implements ActionListener {
        private static double inBalance = 20000.0;
        JButton balance;
        JButton withdraw;
        JButton deposit;
        JButton exit;
        
        atmGUI () {
        
        balance = new JButton();
        balance.setBounds(130, 100, 100, 50);
        balance.addActionListener(this);
        balance.setText("BALANCE");
        balance.setFocusable(false);

        withdraw = new JButton();
        withdraw.setBounds (280, 100, 100, 50);
        withdraw.addActionListener(this);
        withdraw.setText("WITHDRAW");
        withdraw.setFocusable(false);

        deposit = new JButton();
        deposit.setBounds(130, 200, 100, 50);
        deposit.addActionListener(this);
        deposit.setText("DEPOSIT");
        deposit.setFocusable(false);

        exit = new JButton();
        exit.setBounds(280, 200, 100, 50);
        exit.addActionListener(this);
        exit.setText("EXIT");
        exit.setFocusable(false);

        this.setTitle("Paul's ATM");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true); 
        this.setResizable(false);
        this.setLayout(null);

                

        this.add(balance);
        this.add(withdraw);
        this.add(deposit);
        this.add(exit);

        ImageIcon img = new ImageIcon ("image.jpg");
        this.setIconImage(img.getImage());
    }

        @Override
        public void actionPerformed (ActionEvent e) {
            if (e.getSource()==balance) {
                JOptionPane.showMessageDialog(this, "Your current balance is P" +inBalance);
            }

            else if (e.getSource() == withdraw) {
                String am = JOptionPane.showInputDialog(this, "Enter withdrawal amount:");
                    if (am != null) {
                        try {
                            double amount = Double.parseDouble(am);
    
                            if (amount > inBalance) {
                                JOptionPane.showMessageDialog(this,"You only have P" + inBalance + " left!");
                                }       
                                else {
                                    inBalance -= amount;
                                    JOptionPane.showMessageDialog(this,"You have withdrawn P" + amount + ". Remaining money is P" + inBalance);
                                }
                            }  
                             
                            catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
                                }
                            }
                        }


            else if (e.getSource()==deposit) {
                String dep = JOptionPane.showInputDialog(this, "Enter the amount you want to deposit:");
                    if (dep != null) {
                        try {
                            double depAmount = Double.parseDouble(dep);
                            inBalance += depAmount;
                            JOptionPane.showMessageDialog(this, "You have deposit P" +depAmount+ ". Your new balance is P" +inBalance);
                        }

                        catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Invalid input. Enter a valid number.");
                        }
                    }
            }
            
            else if (e.getSource()==exit) {
                inBalance = 20000;
                JOptionPane.showMessageDialog(this, "Thank you for using the program. Your balance has restarted!");
            }

        }
    
}
