import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

public class SubscriptionGUI extends JFrame {
    private ArrayList<AIModel> plans = new ArrayList<AIModel>();

    private JTextField modelNameField;
    private JTextField pricingField;
    private JTextField parameterCountField;
    private JTextField contextWindowField;
    private JTextField promptsQuotaField;
    private JTextField teamSlotsField;
    private JTextField promptTextField;
    private JTextField responseLengthField;
    private JTextField teamMemberNameField;
    private JTextField indexField;
    private JTextArea outputArea;

    public SubscriptionGUI() {
        this("ALL");
    }

    public SubscriptionGUI(String mode) {
        setTitle("AI Model Subscription Manager");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(6, 6));

        JLabel titleLabel = new JLabel("AI Model Subscription Dashboard", JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        add(titleLabel, BorderLayout.NORTH);

        modelNameField = new JTextField();
        pricingField = new JTextField();
        parameterCountField = new JTextField();
        contextWindowField = new JTextField();
        promptsQuotaField = new JTextField();
        teamSlotsField = new JTextField();
        promptTextField = new JTextField();
        responseLengthField = new JTextField();
        teamMemberNameField = new JTextField();
        indexField = new JTextField();

        JButton addPersonalButton = new JButton("Add Personal Plan");
        JButton addProButton = new JButton("Add Pro Plan");
        JButton displayAllButton = new JButton("Display All");
        JButton clearButton = new JButton("Clear");
        JButton givePromptButton = new JButton("Give a Prompt");
        JButton addTeamMemberButton = new JButton("Add Team Member");
        JButton removeTeamMemberButton = new JButton("Remove Team Member");
        JButton checkPlanTypeButton = new JButton("Check Plan Type");
        JButton exportButton = new JButton("Export to File");
        JButton backToMenuButton = new JButton("Back to Main Menu");

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Display Plans"));

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 6, 6));

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Add AI Subscription Plan"));
        GridBagConstraints leftGbc = new GridBagConstraints();
        leftGbc.insets = new Insets(6, 6, 6, 6);
        leftGbc.fill = GridBagConstraints.HORIZONTAL;
        leftGbc.weightx = 1.0;

        addFormRow(leftPanel, 0, "Model Name:", modelNameField);
        addFormRow(leftPanel, 1, "Pricing (NPR per 1L):", pricingField);
        addFormRow(leftPanel, 2, "Parameter Count (B):", parameterCountField);
        addFormRow(leftPanel, 3, "Context Window:", contextWindowField);
        addFormRow(leftPanel, 4, "Prompts Quota:", promptsQuotaField);
        addFormRow(leftPanel, 5, "Team Slots:", teamSlotsField);
        addFormRow(leftPanel, 6, "Plan Index:", indexField);

        JPanel addButtonRow = new JPanel(new GridLayout(1, 2, 8, 0));
        addButtonRow.add(addPersonalButton);
        addButtonRow.add(addProButton);
        GridBagConstraints addButtonsGbc = new GridBagConstraints();
        addButtonsGbc.gridx = 0;
        addButtonsGbc.gridy = 7;
        addButtonsGbc.gridwidth = 2;
        addButtonsGbc.insets = new Insets(10, 6, 4, 6);
        addButtonsGbc.fill = GridBagConstraints.HORIZONTAL;
        leftPanel.add(addButtonRow, addButtonsGbc);

        GridBagConstraints clearGbc = new GridBagConstraints();
        clearGbc.gridx = 0;
        clearGbc.gridy = 8;
        clearGbc.gridwidth = 2;
        clearGbc.insets = new Insets(2, 6, 6, 6);
        clearGbc.fill = GridBagConstraints.HORIZONTAL;
        leftPanel.add(clearButton, clearGbc);

        GridBagConstraints fillerGbc = new GridBagConstraints();
        fillerGbc.gridx = 0;
        fillerGbc.gridy = 9;
        fillerGbc.weighty = 1.0;
        leftPanel.add(Box.createVerticalGlue(), fillerGbc);

        JPanel rightPanel = new JPanel(new BorderLayout(8, 8));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Manage Subscriptions"));

        JPanel actionsContainer = new JPanel();
        actionsContainer.setLayout(new BoxLayout(actionsContainer, BoxLayout.Y_AXIS));

        JPanel promptPanel = new JPanel(new GridBagLayout());
        promptPanel.setBorder(BorderFactory.createTitledBorder("Give a Prompt (Personal Plan)"));
        addFormRow(promptPanel, 0, "Prompt Text:", promptTextField);
        addFormRow(promptPanel, 1, "Response Tokens:", responseLengthField);
        addButtonLine(promptPanel, 2, givePromptButton, 1);

        JPanel teamPanel = new JPanel(new GridBagLayout());
        teamPanel.setBorder(BorderFactory.createTitledBorder("Team Collaboration (Pro Plan)"));
        addFormRow(teamPanel, 0, "Team Member Name:", teamMemberNameField);
        JPanel teamButtons = new JPanel(new GridLayout(1, 2, 6, 0));
        teamButtons.add(addTeamMemberButton);
        teamButtons.add(removeTeamMemberButton);
        addButtonLine(teamPanel, 1, teamButtons, 1);

        JPanel typePanel = new JPanel(new GridBagLayout());
        typePanel.setBorder(BorderFactory.createTitledBorder("Check Plan Type"));
        addButtonLine(typePanel, 0, checkPlanTypeButton, 0);

        JPanel generalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        generalPanel.setBorder(BorderFactory.createTitledBorder("General Operations"));
        generalPanel.add(displayAllButton);
        generalPanel.add(exportButton);
        generalPanel.add(backToMenuButton);

        actionsContainer.add(promptPanel);
        actionsContainer.add(Box.createVerticalStrut(8));
        actionsContainer.add(teamPanel);
        actionsContainer.add(Box.createVerticalStrut(8));
        actionsContainer.add(typePanel);
        actionsContainer.add(Box.createVerticalStrut(8));
        actionsContainer.add(generalPanel);

        rightPanel.add(actionsContainer, BorderLayout.NORTH);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        add(mainPanel, BorderLayout.CENTER);

        if ("PERSONAL".equalsIgnoreCase(mode)) {
            setTitle("Personal Plan Membership");
            addProButton.setEnabled(false);
            teamSlotsField.setEnabled(false);
            addTeamMemberButton.setEnabled(false);
            removeTeamMemberButton.setEnabled(false);
        } else if ("PRO".equalsIgnoreCase(mode)) {
            setTitle("Pro Plan Membership");
            addPersonalButton.setEnabled(false);
            promptsQuotaField.setEnabled(false);
            givePromptButton.setEnabled(false);
        }

        addPersonalButton.addActionListener(e -> addPersonalPlan());
        addProButton.addActionListener(e -> addProPlan());
        displayAllButton.addActionListener(e -> displayAllPlans());
        clearButton.addActionListener(e -> clearFields());
        givePromptButton.addActionListener(e -> givePrompt());
        addTeamMemberButton.addActionListener(e -> addTeamMember());
        removeTeamMemberButton.addActionListener(e -> removeTeamMember());
        checkPlanTypeButton.addActionListener(e -> {
            int index = getDisplayNumber();
            if (index != -1) {
                checkPlanType(index);
            }
        });
        exportButton.addActionListener(e -> exportToFile());
        backToMenuButton.addActionListener(e -> {
            dispose();
            showWelcomeScreen();
        });
    }

    private void addFormRow(JPanel panel, int row, String labelText, JTextField field) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 6, 5, 6);
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        field.setPreferredSize(new Dimension(200, 24));
        panel.add(field, gbc);
    }

    private void addButtonLine(JPanel panel, int row, java.awt.Component component, int gridx) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 6, 5, 6);
        gbc.gridy = row;
        gbc.gridx = gridx;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, gbc);
    }

    private int getDisplayNumber() {
        int displayNumber = -1;
        try {
            displayNumber = Integer.parseInt(indexField.getText().trim());
            if (displayNumber < 0 || displayNumber >= plans.size()) {
                JOptionPane.showMessageDialog(this, "Index out of range. Enter value from 0 to " + (plans.size() - 1) + ".");
                return -1;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid index. Please enter an integer value.");
            return -1;
        }
        return displayNumber;
    }

    private void addPersonalPlan() {
        try {
            String modelName = modelNameField.getText().trim();
            double price = Double.parseDouble(pricingField.getText().trim());
            int parameterCount = Integer.parseInt(parameterCountField.getText().trim());
            String contextWindow = contextWindowField.getText().trim();
            int promptsQuota = Integer.parseInt(promptsQuotaField.getText().trim());

            if (modelName.isEmpty() || contextWindow.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Model name and context window cannot be empty.");
                return;
            }

            PersonalPlan plan = new PersonalPlan(modelName, price, parameterCount, contextWindow, promptsQuota);
            plans.add(plan);
            outputArea.append("Personal plan added at index " + (plans.size() - 1) + ".\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for price, parameters, and prompts quota.");
        }
    }

    private void addProPlan() {
        try {
            String modelName = modelNameField.getText().trim();
            double price = Double.parseDouble(pricingField.getText().trim());
            int parameterCount = Integer.parseInt(parameterCountField.getText().trim());
            String contextWindow = contextWindowField.getText().trim();
            int teamSlots = Integer.parseInt(teamSlotsField.getText().trim());

            if (modelName.isEmpty() || contextWindow.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Model name and context window cannot be empty.");
                return;
            }

            ProPlan plan = new ProPlan(modelName, price, parameterCount, contextWindow, teamSlots);
            plans.add(plan);
            outputArea.append("Pro plan added at index " + (plans.size() - 1) + ".\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for price, parameters, and team slots.");
        }
    }

    private void displayAllPlans() {
        if (plans.isEmpty()) {
            outputArea.setText("No plans available.\n");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plans.size(); i++) {
            sb.append("Index: ").append(i).append("\n");
            sb.append(plans.get(i).display()).append("\n");
            sb.append("----------------------------------------\n");
        }
        outputArea.setText(sb.toString());
    }

    private void clearFields() {
        modelNameField.setText("");
        pricingField.setText("");
        parameterCountField.setText("");
        contextWindowField.setText("");
        promptsQuotaField.setText("");
        teamSlotsField.setText("");
        promptTextField.setText("");
        responseLengthField.setText("");
        teamMemberNameField.setText("");
        indexField.setText("");
        outputArea.setText("");
    }

    private void givePrompt() {
        int index = getDisplayNumber();
        if (index == -1) {
            return;
        }
        AIModel selectedPlan = plans.get(index);
        if (selectedPlan instanceof PersonalPlan) {
            try {
                String promptText = promptTextField.getText().trim();
                int responseLength = Integer.parseInt(responseLengthField.getText().trim());
                PersonalPlan personalPlan = (PersonalPlan) selectedPlan;
                String result = personalPlan.givePrompt(promptText, responseLength);
                outputArea.append(result + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Response length must be an integer.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "This operation is only available for Personal Plan subscriptions.");
        }
    }

    private void addTeamMember() {
        int index = getDisplayNumber();
        if (index == -1) {
            return;
        }
        AIModel selectedPlan = plans.get(index);
        if (selectedPlan instanceof ProPlan) {
            String name = teamMemberNameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Team member name cannot be empty.");
                return;
            }
            ProPlan proPlan = (ProPlan) selectedPlan;
            String result = proPlan.addTeamMember(name);
            outputArea.append(result + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Team collaboration is only available for Pro Plan subscriptions.");
        }
    }

    private void removeTeamMember() {
        int index = getDisplayNumber();
        if (index == -1) {
            return;
        }
        AIModel selectedPlan = plans.get(index);
        if (selectedPlan instanceof ProPlan) {
            String name = teamMemberNameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Team member name cannot be empty.");
                return;
            }
            ProPlan proPlan = (ProPlan) selectedPlan;
            String result = proPlan.removeTeamMember(name);
            outputArea.append(result + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Team collaboration is only available for Pro Plan subscriptions.");
        }
    }

    private void checkPlanType(int index) {
        AIModel selectedPlan = plans.get(index);
        if (selectedPlan instanceof PersonalPlan) {
            outputArea.append("Index " + index + ": Personal Plan\n");
        } else if (selectedPlan instanceof ProPlan) {
            outputArea.append("Index " + index + ": Pro Plan\n");
        } else {
            outputArea.append("Index " + index + ": Unknown Plan Type\n");
        }
    }

    private void exportToFile() {
        if (plans.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No plans available to export.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ai_subscriptions_export.txt"))) {
            for (int i = 0; i < plans.size(); i++) {
                AIModel model = plans.get(i);
                writer.write("Index: " + i);
                writer.newLine();
                writer.write(model.display());
                writer.newLine();
                writer.write("========================================");
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Export completed: ai_subscriptions_export.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to export file: " + ex.getMessage());
        }
    }

    public static void showWelcomeScreen() {
        JFrame welcomeFrame = new JFrame("Welcome to AI Subscription");
        welcomeFrame.setSize(520, 360);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to AI Subscription!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));

        JButton proButton = new JButton("Pro Plan");
        JButton personalButton = new JButton("Personal Plan");
        proButton.setPreferredSize(new Dimension(220, 46));
        personalButton.setPreferredSize(new Dimension(220, 46));
        proButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        personalButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(228, 228, 242));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridy = 0;
        centerPanel.add(welcomeLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(28, 10, 12, 10);
        centerPanel.add(proButton, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(12, 10, 10, 10);
        centerPanel.add(personalButton, gbc);

        welcomeFrame.add(centerPanel, BorderLayout.CENTER);

        proButton.addActionListener(e -> {
            welcomeFrame.dispose();
            SubscriptionGUI gui = new SubscriptionGUI("PRO");
            gui.setVisible(true);
        });

        personalButton.addActionListener(e -> {
            welcomeFrame.dispose();
            SubscriptionGUI gui = new SubscriptionGUI("PERSONAL");
            gui.setVisible(true);
        });

        welcomeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                // Fall back to default look and feel.
            }
            showWelcomeScreen();
        });
    }
}
