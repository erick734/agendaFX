package com.example.admindesktop.model.controller;

import com.example.admindesktop.model.DAO.UsuarioDAO;
import com.example.admindesktop.model.Usuario;
import com.example.admindesktop.model.value.Email;
import com.example.admindesktop.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroController {

    @FXML private PasswordField txtSenha;
    @FXML private TextField txtEmail;
    @FXML private Label menssagemText;

    @FXML
    public void OnClickBtnSalvar(ActionEvent event) {
        if (txtEmail.getText().isBlank() || txtSenha.getText().isBlank()) {
            mostrarMensagem(Alert.AlertType.ERROR, "Erro", "E-mail e Senha são obrigatórios.");
            return;
        }

        EntityManager em = null;
        try {
            em = JPAUtils.getEntityManager();
            UsuarioDAO dao = new UsuarioDAO(em);
            Usuario usuario = new Usuario();

            usuario.setUsuario("admin");
            usuario.setNome("administrador");
            usuario.setSobrenome("ADM");
            usuario.setSenha(txtSenha.getText());
            usuario.setPerfil("a");
            usuario.setEmail(new Email(txtEmail.getText()));

            em.getTransaction().begin();
            dao.salvar(usuario);
            em.getTransaction().commit();

            carregarTelaDeSucesso(event);

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            mostrarMensagem(Alert.AlertType.ERROR, "Erro", "Erro ao salvar usuário: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private void carregarTelaDeSucesso(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/admindesktop/sucesso-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    private void mostrarMensagem(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}