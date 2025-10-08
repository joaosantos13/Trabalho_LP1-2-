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

    int row = 0;

    Label corLabel = new Label("Cor:");
    TextField corField = new TextField();
    grid.add(corLabel, 0, row);
    grid.add(corField, 1, row++);
    
    TextField tamanhoField = null;
    TextField qntdPratosField = null;
    TextField marcaField = null;
    TextField qntdCordasField = null;
    TextField especieField = null;

    if (tipo.equals("Bateria")) {
        Label qntdPratosLabel = new Label("Quantidade Pratos:");
        qntdPratosField = new TextField();
        grid.add(qntdPratosLabel, 0, row);
        grid.add(qntdPratosField, 1, row++);

        Label marcaLabel = new Label("Marca:");
        marcaField = new TextField();
        grid.add(marcaLabel, 0, row);
        grid.add(marcaField, 1, row++);
        
    } else if (tipo.equals("Guitarra")) {
        Label marcaLabel = new Label("Marca:");
        marcaField = new TextField();
        grid.add(marcaLabel, 0, row);
        grid.add(marcaField, 1, row++);

        Label qntdCordasLabel = new Label("Quantidade Cordas:");
        qntdCordasField = new TextField();
        grid.add(qntdCordasLabel, 0, row);
        grid.add(qntdCordasField, 1, row++);

    } else if (tipo.equals("Tubarao")) {
        Label tamanhoLabel = new Label("Tamanho:");
        tamanhoField = new TextField();
        grid.add(tamanhoLabel, 0, row);
        grid.add(tamanhoField, 1, row++);

        Label especieLabel = new Label("Espécie:");
        especieField = new TextField();
        grid.add(especieLabel, 0, row);
        grid.add(especieField, 1, row++);
    }

    Button salvarBtn = new Button("Salvar");
    grid.add(salvarBtn, 1, row);

    // Lógica de salvamento
    TextField finalTamanhoField = tamanhoField;
    TextField finalQntdPratosField = qntdPratosField;
    TextField finalMarcaField = marcaField;
    TextField finalQntdCordasField = qntdCordasField;
    TextField finalEspecieField = especieField;

    salvarBtn.setOnAction(e -> {
        try {
            String cor = corField.getText();

            switch (tipo) {
                case "Bateria":
                    int qntdPratos = Integer.parseInt(finalQntdPratosField.getText());
                    String marcaBateria = finalMarcaField.getText();
                    Bateria bateria = new Bateria(cor, qntdPratos, marcaBateria);
                    salvarCSVBateria("bateria.csv", cor, qntdPratos, marcaBateria);
                    break;
                case "Guitarra":
                    String marcaGuitarra = finalMarcaField.getText();
                    int qntdCordas = Integer.parseInt(finalQntdCordasField.getText());
                    Guitarra guitarra = new Guitarra(cor, marcaGuitarra, qntdCordas);
                    salvarCSVGuitarra("guitarra.csv", cor, marcaGuitarra, qntdCordas);
                    break;
                case "Tubarao":
                    String tamanho = finalTamanhoField.getText();
                    String especie = finalEspecieField.getText();
                    Tubarao tubarao = new Tubarao(cor, tamanho, especie);
                    salvarCSVTubarao("tubarao.csv", cor, tamanho, especie);
                    break;
            }

            corField.clear();
            if (finalTamanhoField != null) finalTamanhoField.clear();
            if (finalQntdPratosField != null) finalQntdPratosField.clear();
            if (finalMarcaField != null) finalMarcaField.clear();
            if (finalQntdCordasField != null) finalQntdCordasField.clear();
            if (finalEspecieField != null) finalEspecieField.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registro salvo em " + tipo);
            alert.showAndWait();

        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Campos numéricos devem conter apenas números.");
            alert.showAndWait();
        }
    });

    return grid;
}


    private void salvarCSVBateria(String nomeArquivo, String cor, int qntdPratos, String marca) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(cor + "," + qntdPratos + "," + marca + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

     private void salvarCSVGuitarra(String nomeArquivo, String cor, String marca,  int qntdPratos) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(cor + "," + qntdPratos + "," + marca + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

     private void salvarCSVTubarao(String nomeArquivo, String cor, String tamanho, String especie) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(cor + "," + tamanho + "," + especie + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
