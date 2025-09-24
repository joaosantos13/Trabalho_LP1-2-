package org.katyperry;


import java.io.FileWriter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cadastro de Objetos");

        TabPane tabPane = new TabPane();

        // ---- Fireworks Tab ----
        GridPane gpFireworks = new GridPane();
        gpFireworks.setPadding(new Insets(10));
        gpFireworks.setVgap(8);
        gpFireworks.setHgap(10);

        TextField fwCor = new TextField();
        TextField fwTamanho = new TextField();
        TextField fwPotencia = new TextField();
        Button fwSalvar = new Button("Salvar Fireworks");

        gpFireworks.add(new Label("Cor:"), 0, 0);
        gpFireworks.add(fwCor, 1, 0);

        gpFireworks.add(new Label("Tamanho:"), 0, 1);
        gpFireworks.add(fwTamanho, 1, 1);

        gpFireworks.add(new Label("Potência:"), 0, 2);
        gpFireworks.add(fwPotencia, 1, 2);

        gpFireworks.add(fwSalvar, 1, 3);

        Tab tabFireworks = new Tab("Fireworks", gpFireworks);
        tabFireworks.setClosable(false);

        fwSalvar.setOnAction(e -> {
            try {
                String cor = fwCor.getText();
                int tamanho = Integer.parseInt(fwTamanho.getText());
                int potencia = Integer.parseInt(fwPotencia.getText());
                Fireworks f = new Fireworks(cor, tamanho, potencia);
                try (FileWriter writer = new FileWriter("fireworks.csv", true)) {
                    writer.write(f.getCor() + "," + f.getTamanho() + "," + f.getPotencia() + "\n");
                }
                showAlert("Sucesso", "Fireworks salvo!");
            } catch (Exception ex) {
                showAlert("Erro", "Erro ao salvar Fireworks: " + ex.getMessage());
            }
        });

        // ---- Porta Tab ----
        GridPane gpPorta = new GridPane();
        gpPorta.setPadding(new Insets(10));
        gpPorta.setVgap(8);
        gpPorta.setHgap(10);

        TextField portaCor = new TextField();
        TextField portaTamanho = new TextField();
        CheckBox portaAberta = new CheckBox("Aberta");
        Button portaSalvar = new Button("Salvar Porta");

        gpPorta.add(new Label("Cor:"), 0, 0);
        gpPorta.add(portaCor, 1, 0);

        gpPorta.add(new Label("Tamanho:"), 0, 1);
        gpPorta.add(portaTamanho, 1, 1);

        gpPorta.add(portaAberta, 1, 2);
        gpPorta.add(portaSalvar, 1, 3);

        Tab tabPorta = new Tab("Porta", gpPorta);
        tabPorta.setClosable(false);

        portaSalvar.setOnAction(e -> {
            try {
                String cor = portaCor.getText();
                String tamanho = portaTamanho.getText();
                boolean aberta = portaAberta.isSelected();
                Porta p = new Porta(cor, tamanho, aberta);
                try (FileWriter writer = new FileWriter("porta.csv", true)) {
                    writer.write(p.getCor() + "," + p.getTamanho() + "," + (aberta ? "Aberta" : "Fechada") + "\n");
                }
                showAlert("Sucesso", "Porta salva!");
            } catch (Exception ex) {
                showAlert("Erro", "Erro ao salvar Porta: " + ex.getMessage());
            }
        });

        // ---- Sacola Tab ----
        GridPane gpSacola = new GridPane();
        gpSacola.setPadding(new Insets(10));
        gpSacola.setVgap(8);
        gpSacola.setHgap(10);

        TextField sacolaCor = new TextField();
        TextField sacolaTamanho = new TextField();
        CheckBox sacolaRasgada = new CheckBox("Rasgada");
        Button sacolaSalvar = new Button("Salvar Sacola");

        gpSacola.add(new Label("Cor:"), 0, 0);
        gpSacola.add(sacolaCor, 1, 0);

        gpSacola.add(new Label("Tamanho:"), 0, 1);
        gpSacola.add(sacolaTamanho, 1, 1);

        gpSacola.add(sacolaRasgada, 1, 2);
        gpSacola.add(sacolaSalvar, 1, 3);

        Tab tabSacola = new Tab("Sacola Plástica", gpSacola);
        tabSacola.setClosable(false);

        sacolaSalvar.setOnAction(e -> {
            try {
                String cor = sacolaCor.getText();
                int tamanho = Integer.parseInt(sacolaTamanho.getText());
                boolean rasgada = sacolaRasgada.isSelected();
                Sacola_Plastica s = new Sacola_Plastica(cor, tamanho, rasgada);
                try (FileWriter writer = new FileWriter("sacola.csv", true)) {
                    writer.write(s.getCor() + "," + s.getTamanho() + "," + (rasgada ? "Rasgada" : "Inteira") + "\n");
                }
                showAlert("Sucesso", "Sacola salva!");
            } catch (Exception ex) {
                showAlert("Erro", "Erro ao salvar Sacola: " + ex.getMessage());
            }
        });

        // ---- Add Tabs ----
        tabPane.getTabs().addAll(tabFireworks, tabPorta, tabSacola);

        Scene scene = new Scene(tabPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
