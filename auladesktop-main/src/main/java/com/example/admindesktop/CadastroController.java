package com.example.admindesktop;

import com.example.admindesktop.model.DAO.UsuarioDAO;
import com.example.admindesktop.model.value.Email;
import com.example.admindesktop.model.Usuario;
import com.example.admindesktop.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtCodigo;

    @FXML
    private Label menssagemText;

    @FXML
    public void OnClickBtnSalvar(ActionEvent event) {
        try {
            EntityManager em = JPAUtils.getEntityManager();
            UsuarioDAO dao = new UsuarioDAO(em);

            Usuario usuario = new Usuario();

            usuario.setUsuario(txtNome.getText());

            Email email = new Email(txtEmail.getText());
            usuario.setEmail(email);

            // Exemplo para telefone, caso adicione um campo txtTelefone futuramente
            // Telefone telefone = new Telefone(txtTelefone.getText());
            // usuario.setTelefone(telefone);

            dao.salvar(usuario);

            new Alert(Alert.AlertType.INFORMATION, "Salvo com sucesso! ID: " + usuario.getId()).show();
            txtCodigo.setText(usuario.getId().toString());
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensagem("Erro ao salvar usuário: " + e.getMessage());
        }
    }


    @FXML
    public void OnClickBtnVoltar (ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo/menu.view.fxml"));
            Scene menuScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(menuScene);
        } catch (Exception e) {
            e.printStackTrace();
            menssagemText.setText("Erro ao carregar a tela de menu.");
        }
    }

    private void mostrarMensagem(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}