package com.prj.albumdefigurinhas.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prj.albumdefigurinhas.dto.UsuarioRequestDTO;
import com.prj.albumdefigurinhas.dto.UsuarioResponseDTO;
import com.prj.albumdefigurinhas.model.Perfil;



public class AdministradorSwing extends JFrame {
     private static final String BASE_URL = "http://localhost:8080/api/usuarios/";

    private JTextField txtNome;
    private JTextField txtSenha;
    private JComboBox<Perfil> cmbPerfil;
    private JTextArea txtAreaUsuarios;
    private JButton btnInserir;
    private JButton btnExcluir;
    private JButton btnEditar;
    private JTextField txtFiltro;

    public AdministradorSwing() {
        super("Gerenciamento de Usuários - Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridLayout(5, 2));
        panel.add(pnlForm, BorderLayout.NORTH);

        pnlForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        pnlForm.add(txtNome);

        pnlForm.add(new JLabel("Senha:"));
        txtSenha = new JTextField();
        pnlForm.add(txtSenha);

        pnlForm.add(new JLabel("Perfil:"));
        cmbPerfil = new JComboBox<>(Perfil.values());
        pnlForm.add(cmbPerfil);

        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserirUsuario();
            }
        });
        pnlForm.add(btnInserir);

        btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirUsuario();
            }
        });
        pnlForm.add(btnExcluir);

        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarUsuario();
            }
        });
        pnlForm.add(btnEditar);

        JPanel pnlFiltro = new JPanel();
        pnlFiltro.setLayout(new FlowLayout());
        panel.add(pnlFiltro, BorderLayout.CENTER);

        pnlFiltro.add(new JLabel("Filtrar por nome:"));
        txtFiltro = new JTextField(20);
        pnlFiltro.add(txtFiltro);

        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filtro = txtFiltro.getText();
                filtrarUsuarios(filtro);
            }
        });
        pnlFiltro.add(btnFiltrar);

        txtAreaUsuarios = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(txtAreaUsuarios);
        panel.add(scrollPane, BorderLayout.SOUTH);
    }

    private void inserirUsuario() {
        String nome = txtNome.getText();
        String senha = txtSenha.getText();
        Perfil perfil = (Perfil) cmbPerfil.getSelectedItem();

        UsuarioRequestDTO requestDTO = new UsuarioRequestDTO();
        requestDTO.setNome(nome);
        requestDTO.setSenha(senha);
        requestDTO.setPerfil(perfil);

        try {
            ResponseEntity<UsuarioResponseDTO> responseEntity = HttpClientUtils.doPost(BASE_URL, requestDTO, UsuarioResponseDTO.class);
    
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                UsuarioResponseDTO usuarioDTO = responseEntity.getBody();
                txtAreaUsuarios.append("Usuário inserido com sucesso: " + usuarioDTO + "\n");
            } else {
                txtAreaUsuarios.append("Erro ao inserir usuário: " + responseEntity.getBody() + "\n");
            }
        } catch (IOException ex) {
            txtAreaUsuarios.append("Erro de comunicação com o servidor: " + ex.getMessage() + "\n");
        }
    }

    private void excluirUsuario() {
        String idUsuarioParaExcluir = ""; // aqui você deve obter o ID do usuário a ser excluído
    
        try {
            ResponseEntity<UsuarioResponseDTO> responseEntity = HttpClientUtils.doDelete(BASE_URL + "/" + idUsuarioParaExcluir);
    
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                txtAreaUsuarios.append("Usuário excluído com sucesso\n");
            } else {
                txtAreaUsuarios.append("Erro ao excluir usuário: " + responseEntity.getBody() + "\n");
            }
        } catch (IOException ex) {
            txtAreaUsuarios.append("Erro de comunicação com o servidor: " + ex.getMessage() + "\n");
        }
    }
    

    private void editarUsuario() {
        String idUsuarioParaEditar = ""; // aqui você deve obter o ID do usuário a ser editado
        String nomeNovo = ""; // aqui você deve obter o novo nome do usuário
        String senhaNova = ""; // aqui você deve obter a nova senha do usuário
        Perfil perfilNovo = Perfil.ADMINISTRADOR; // aqui você deve obter o novo perfil do usuário
    
        UsuarioRequestDTO requestDTO = new UsuarioRequestDTO();
        requestDTO.setNome(nomeNovo);
        requestDTO.setSenha(senhaNova);
        requestDTO.setPerfil(perfilNovo);
    
        try {
            ResponseEntity<UsuarioResponseDTO> responseEntity = HttpClientUtils.doPut(BASE_URL + "/" + idUsuarioParaEditar, requestDTO);
    
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                txtAreaUsuarios.append("Usuário atualizado com sucesso\n");
            } else {
                txtAreaUsuarios.append("Erro ao atualizar usuário: " + responseEntity.getBody() + "\n");
            }
        } catch (IOException ex) {
            txtAreaUsuarios.append("Erro de comunicação com o servidor: " + ex.getMessage() + "\n");
        }
    }
    

    private void filtrarUsuarios(String filtro) {
        try {
            ResponseEntity<List<UsuarioResponseDTO>> responseEntity = HttpClientUtils.doGet(BASE_URL + "?filtro=" + filtro);
    
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                List<UsuarioResponseDTO> usuariosFiltrados = responseEntity.getBody();
                txtAreaUsuarios.setText(""); // Limpa o texto atual da área de texto
    
                for (UsuarioResponseDTO usuario : usuariosFiltrados) {
                    txtAreaUsuarios.append(usuario.toString() + "\n");
                }
            } else {
                txtAreaUsuarios.append("Nenhum usuário encontrado com o filtro: " + filtro + "\n");
            }
        } catch (IOException ex) {
            txtAreaUsuarios.append("Erro de comunicação com o servidor: " + ex.getMessage() + "\n");
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AdministradorSwing frame = new AdministradorSwing();
                frame.setVisible(true);
            }
        });
    }
}