package gui;

import javax.swing.*;
import controller.Controller;
import model.Utente;

public class LoginGUI extends JFrame {
    private JPanel panel1;
    private JLabel loginLabel;
    private JTextField loginTextField;
    private JLabel pswLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    private Controller controller;

    public LoginGUI() {
        setTitle("University Management System - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panel1);

        controller = new Controller();
        loginButton.addActionListener(e -> handleLogin());

        setVisible(true);
    }

    private void handleLogin() {
        String login = loginTextField.getText();
        String password = new String(passwordField.getPassword());

        Utente user = controller.login(login, password);

        if(user != null){
            JOptionPane.showMessageDialog(this,
                    "Login avvenuto con successo. Benvenuto, " + user.getNome(),
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Errore. Login o Password non validi.",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LoginGUI();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}