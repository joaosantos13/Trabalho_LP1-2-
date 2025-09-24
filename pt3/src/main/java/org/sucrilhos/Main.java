package org.sucrilhos;

import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        // ========== TAB SKATE ==========
        Tab tabSkate = new Tab("Skate", criarFormulario("Skate"));
        tabSkate.setClosable(false);

        // ========== TAB PULA PULA ==========
        Tab tabPulaPula = new Tab("Pula Pula", criarFormulario("Pula_Pula"));
        tabPulaPula.setClosable(false);

        // ========== TAB BICICLETA ==========
        Tab tabBicicleta = new Tab("Bicicleta", criarFormulario("Bicicleta"));
        tabBicicleta.setClosable(false);

        tabPane.getTabs().addAll(tabSkate, tabPulaPula, tabBicicleta);

        Scene scene = new Scene(tabPane, 400, 250);
        primaryStage.setTitle("Cadastro dos Objetos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane criarFormulario(String tipo) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label corLabel = new Label("Cor:");
        TextField corField = new TextField();

        Label tamanhoLabel = new Label("Tamanho:");
        TextField tamanhoField = new TextField();

        Label velocidadeLabel = new Label("Velocidade:");
        TextField velocidadeField = new TextField();

        Button salvarBtn = new Button("Salvar");

        // Ação do botão
        salvarBtn.setOnAction(e -> {
            String cor = corField.getText();
            int tamanho = Integer.parseInt(tamanhoField.getText());
            int velocidade = Integer.parseInt(velocidadeField.getText());

            // Instancia objeto conforme tipo
            switch (tipo) {
                case "Skate":
                    Skate skate = new Skate(cor, tamanho, velocidade);
                    salvarCSV("skate.csv", cor, tamanho, velocidade);
                    break;
                case "Pula_Pula":
                    Pula_Pula pp = new Pula_Pula(cor, tamanho, velocidade);
                    salvarCSV("pula_pula.csv", cor, tamanho, velocidade);
                    break;
                case "Bicicleta":
                    Bicicleta bike = new Bicicleta(cor, tamanho, velocidade);
                    salvarCSV("bicicleta.csv", cor, tamanho, velocidade);
                    break;
            }

            corField.clear();
            tamanhoField.clear();
            velocidadeField.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registro salvo em " + tipo);
            alert.showAndWait();
        });

        grid.add(corLabel, 0, 0);
        grid.add(corField, 1, 0);
        grid.add(tamanhoLabel, 0, 1);
        grid.add(tamanhoField, 1, 1);
        grid.add(velocidadeLabel, 0, 2);
        grid.add(velocidadeField, 1, 2);
        grid.add(salvarBtn, 1, 3);

        return grid;
    }

    private void salvarCSV(String nomeArquivo, String cor, int tamanho, int velocidade) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(cor + "," + tamanho + "," + velocidade + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
