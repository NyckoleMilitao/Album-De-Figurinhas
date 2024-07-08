package com.prj.albumdefigurinhas.view;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class LoginSwing extends JFrame {

    private static final String BASE_URL = "http://localhost:8080/api/login/login";

    private static JFrame frame;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JComboBox<String> perfilComboBox;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginSwing::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JLabel perfilLabel = new JLabel("Perfil:");
        String[] perfis = {"Administrador", "Autor", "Colecionador"};
        perfilComboBox = new JComboBox<>(perfis);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String perfil = (String) perfilComboBox.getSelectedItem();

                if (performLogin(username, password, perfil)) {
                    JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    // Aqui você pode abrir a próxima tela ou executar outras ações após o login
                } else {
                    JOptionPane.showMessageDialog(frame, "Falha ao fazer login!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(perfilLabel);
        panel.add(perfilComboBox);
        panel.add(new JLabel()); // Espaço em branco
        panel.add(loginButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static boolean performLogin(String username, String password, String perfil) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(BASE_URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String input = "{ \"nome\": \"" + username + "\", \"senha\": \"" + password + "\", \"perfil\": \"" + perfil + "\" }";
            conn.getOutputStream().write(input.getBytes());

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response = in.readLine();
            in.close();

            return response.contains("Login realizado com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
