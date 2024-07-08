package com.prj.albumdefigurinhas.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmAlbum extends JFrame {

    public FrmAlbum() {
        super("Álbum de Figurinhas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        // Simulando as páginas do álbum com botões de figurinhas
        JPanel pnlPaginas = new JPanel(new GridLayout(2, 3, 10, 10)); // 2 linhas, 3 colunas
        panel.add(pnlPaginas, BorderLayout.CENTER);

        // Simulação de botões de figurinhas nas páginas do álbum
        for (int i = 1; i <= 6; i++) {
            JButton btnFigurinha = new JButton("Figurinha " + i);
            pnlPaginas.add(btnFigurinha);

            // Evento de duplo clique para abrir detalhes da figurinha
            btnFigurinha.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        // Abrir tela FrmFigurinha com detalhes da figurinha clicada
                        abrirFrmFigurinha(btnFigurinha.getText());
                    }
                }
            });
        }

        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    private void abrirFrmFigurinha(String nomeFigurinha) {
        FrmFigurinha frmFigurinha = new FrmFigurinha(nomeFigurinha);
        frmFigurinha.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FrmAlbum frame = new FrmAlbum();
                frame.setVisible(true);
            }
        });
    }
}
