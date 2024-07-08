package com.prj.albumdefigurinhas.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class FrmAlbumPaginaCapa extends JFrame {


    public FrmAlbumPaginaCapa() {
        super("Página Capa - Álbum de Figurinhas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        getContentPane().add(panel);

        JButton btnTrocarSenha = new JButton("1 - Trocar Senha");
        btnTrocarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação de trocar senha
                JOptionPane.showMessageDialog(FrmAlbumPaginaCapa.this, "Ação de trocar senha não implementada ainda.");
            }
        });
        panel.add(btnTrocarSenha);

        JButton btnAdquirirFigurinha = new JButton("2 - Adquirir uma Nova Figurinha");
        btnAdquirirFigurinha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação de adquirir nova figurinha
                JOptionPane.showMessageDialog(FrmAlbumPaginaCapa.this, "Ação de adquirir nova figurinha não implementada ainda.");
            }
        });
        panel.add(btnAdquirirFigurinha);

        JButton btnSobre = new JButton("3 - Sobre");
        btnSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação de exibir informações sobre o sistema
                JOptionPane.showMessageDialog(FrmAlbumPaginaCapa.this, "Sistema de Álbum de Figurinhas\nVersão: 1.0.4.1\nData: 12/06/2024");
            }
        });
        panel.add(btnSobre);

        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FrmAlbumPaginaCapa frame = new FrmAlbumPaginaCapa() {
                    
                };
                frame.setVisible(true);
            }
        });
    }
}
