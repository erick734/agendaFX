package com.example.admindesktop.model.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SucessoController {

    @FXML
    public void onFecharButtonClick(ActionEvent event) {
        Platform.exit();
    }
}