module com.example.admindesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires static lombok;

    opens com.example.admindesktop to javafx.fxml;
    opens com.example.admindesktop.model to org.hibernate.orm.core;

    exports com.example.admindesktop;
    opens com.example.admindesktop.model.value to org.hibernate.orm.core;
    exports com.example.admindesktop.model.controller;
    opens com.example.admindesktop.model.controller to javafx.fxml;
}