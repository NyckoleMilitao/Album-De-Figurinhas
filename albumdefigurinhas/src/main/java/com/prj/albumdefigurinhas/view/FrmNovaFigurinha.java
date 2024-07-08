package com.prj.albumdefigurinhas.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.prj.albumdefigurinhas.dto.FigurinhaResponseDTO;
import com.prj.albumdefigurinhas.service.FigurinhaService;
import com.prj.albumdefigurinhas.service.impl.FigurinhaServiceImpl;

public class FrmNovaFigurinha extends JFrame{

    private JTextField txtTag;
    private JTextArea txtAreaInfo;
    private FigurinhaService figurinhaService;

    public FrmNovaFigurinha() {
        super("Nova Figurinha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        figurinhaService = new FigurinhaServiceImpl(); // Inicializa o serviço de figurinhas

        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        JPanel pnlCampos = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.add(pnlCampos, BorderLayout.NORTH);

        pnlCampos.add(new JLabel("Tag da Figurinha:"));
        txtTag = new JTextField();
        pnlCampos.add(txtTag);

       /*  JButton btnAdquirir = new JButton("Adquirir Figurinha");
        btnAdquirir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adquirirFigurinha();
            }
        });
        pnlCampos.add(btnAdquirir);*/

        txtAreaInfo = new JTextArea(10, 30);
        txtAreaInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaInfo);
        panel.add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    /*private void adquirirFigurinha() {
        String tag = txtTag.getText();
        //FigurinhaResponseDTO figurinhaResponseDTO = figurinhaService.adicionarfigurinha(tag);

        if (figurinhaResponseDTO != null) {
            txtAreaInfo.setText("Figurinha adquirida com sucesso!\n");
            txtAreaInfo.append("Nome: " + figurinhaResponseDTO.getNomeFigurinha() + "\n");
            txtAreaInfo.append("Descrição: " + figurinhaResponseDTO.getDescricao() + "\n");
            // Outras informações conforme necessário
        } else {
            txtAreaInfo.setText("Não foi possível adquirir a figurinha com a tag '" + tag + "'.");
        }
    }*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FrmNovaFigurinha frame = new FrmNovaFigurinha();
                frame.setVisible(true);
            }
        });
    }
}
