import java.util.ArrayList;
import javax.swing.*;

public class GymGUI {
    public static void main(String[] args) {
        ArrayList<Membership> list = new ArrayList<>(); // arraylist

        JFrame frame = new JFrame("GYM Membership Management System");
        frame.setSize(700, 700);
        frame.setResizable(false); // mimimize ra maximize button hide garako
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);// frame lai center garako
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name : ");
        nameLabel.setBounds(50, 50, 100, 25);
        frame.add(nameLabel);

        JTextField namTextField = new JTextField();
        namTextField.setBounds(150, 50, 200, 25);
        frame.add(namTextField);

        JLabel feeLabel = new JLabel("Fee : ");
        feeLabel.setBounds(50, 100, 100, 25);
        frame.add(feeLabel);

        JTextField feeTextField = new JTextField();
        feeTextField.setBounds(150, 100, 200, 25);
        frame.add(feeTextField);

        JLabel durationLabel = new JLabel("Duration : ");
        durationLabel.setBounds(50, 150, 100, 25);
        frame.add(durationLabel);

        JTextField durationTextField = new JTextField();
        durationTextField.setBounds(150, 150, 200, 25);
        frame.add(durationTextField);

        JLabel typeLabel = new JLabel("Type : ");
        typeLabel.setBounds(50, 200, 100, 25);
        frame.add(typeLabel);

        JTextField typeTextField = new JTextField();
        typeTextField.setBounds(150, 200, 200, 25);
        frame.add(typeTextField);

        JLabel sessionLabel = new JLabel("Session : ");
        sessionLabel.setBounds(50, 250, 100, 25);
        frame.add(sessionLabel);

        JTextField sessionTextField = new JTextField();
        sessionTextField.setBounds(150, 250, 200, 25);
        frame.add(sessionTextField);

        JLabel slotLabel = new JLabel("Trainer slot : ");
        slotLabel.setBounds(50, 300, 100, 25);
        frame.add(slotLabel);

        JTextField slotTextField = new JTextField();
        slotTextField.setBounds(150, 300, 200, 25);
        frame.add(slotTextField);

        JButton basicButton = new JButton("Add Basic");
        basicButton.setBounds(400, 100, 200, 25);
        frame.add(basicButton);

        JButton premiumButton = new JButton("Add Premium");
        premiumButton.setBounds(400, 150, 200, 25);
        frame.add(premiumButton);

        JButton displayButton = new JButton("Display");
        displayButton.setBounds(400, 200, 200, 25);
        frame.add(displayButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(400, 250, 200, 25);
        frame.add(clearButton);

        JTextArea area = new JTextArea();
        JScrollPane pane = new JScrollPane(area);
        pane.setBounds(100, 350, 500, 200);
        frame.add(pane);

        // add basic button
        basicButton.addActionListener(e -> {
            String name = namTextField.getText();
            double fee = Double.parseDouble(feeTextField.getText());// convert String to double
            int duration = Integer.parseInt(durationTextField.getText()); // convert String to int
            String type = typeTextField.getText();
            int session = Integer.parseInt(sessionTextField.getText());
            BasicMembership basic = new BasicMembership(name, fee, duration, type, session); // object creation
            list.add(basic);

            JOptionPane.showMessageDialog(frame, "Name : " + basic.getName() +
                    "\nFee : " + basic.getFee() +
                    "\nDuration : " + basic.getDuration() +
                    "\nType : " + basic.getDuration() +
                    "\nSession : " + basic.getSessions());
        });

        // add premium
        premiumButton.addActionListener(e -> {
            String name = namTextField.getText();
            double fee = Double.parseDouble(feeTextField.getText());// convert String to double
            int duration = Integer.parseInt(durationTextField.getText()); // convert String to int
            String type = typeTextField.getText();
            int trainerSlots = Integer.parseInt(slotTextField.getText());

            PremiumMembership premium = new PremiumMembership(name, fee, duration, type, trainerSlots); // object creation
            list.add(premium);

            JOptionPane.showMessageDialog(frame, "Name : " + premium.getName() +
                    "\nFee : " + premium.getFee() +
                    "\nDuration : " + premium.getDuration() +
                    "\nType : " + premium.getDuration() +
                    "\nTrainer Slot : " + premium.getTrainerSlot());
        });
        //clear button
        clearButton.addActionListener(e -> {
            namTextField.setText("");
            feeTextField.setText("");
            durationTextField.setText("");
            typeTextField.setText("");
            sessionTextField.setText("");
            slotTextField.setText("");4
        });

        // display button
        displayButton.addActionListener(e -> {
            area.setText("");

            for (int i = 0; i < list.size(); i++) {
                area.append(i + " " + list.get(i).display() + "\n");
            }
        });

        // at last
        frame.setVisible(true);
    }

}