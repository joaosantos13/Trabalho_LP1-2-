package org.deftones;

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

        // Tab Bateria
        Tab tabBateria = new Tab("Bateria", criarFormulario("Bateria"));
        tabBateria.setClosable(false);

        // Tab Guitarra
        Tab tabGuitarra = new Tab("Guitarra", criarFormulario("Guitarra"));
        tabGuitarra.setClosable(false);

        // Tab Tubarao
        Tab tabTubarao = new Tab("Tubarao", criarFormulario("Tubarao"));
        tabTubarao.setClosable(false);

        tabPane.getTabs().addAll(tabBateria, tabGuitarra, tabTubarao);

        Scene scene = new Scene(tabPane, 400, 250);
        primaryStage.setTitle("Cadastro Bateria, Guitarra e Tubarão");
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

        salvarBtn.setOnAction(e -> {
            try {
                String cor = corField.getText();
                int tamanho = Integer.parseInt(tamanhoField.getText());
                int velocidade = Integer.parseInt(velocidadeField.getText());

                switch (tipo) {
                    case "Bateria":
                        Bateria bateria = new Bateria(cor, tamanho, velocidade);
                        salvarCSV("bateria.csv", cor, tamanho, velocidade);
                        break;
                    case "Guitarra":
                        Guitarra guitarra = new Guitarra(cor, tamanho, velocidade);
                        salvarCSV("guitarra.csv", cor, tamanho, velocidade);
                        break;
                    case "Tubarao":
                        Tubarao tubarao = new Tubarao(cor, tamanho, velocidade);
                        salvarCSV("tubarao.csv", cor, tamanho, velocidade);
                        break;
                }

                corField.clear();
                tamanhoField.clear();
                velocidadeField.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registro salvo em " + tipo);
                alert.showAndWait();

            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Tamanho e Velocidade devem ser números.");
                alert.showAndWait();
            }
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
