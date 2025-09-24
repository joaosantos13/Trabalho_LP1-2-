package org.vikmuniz;

/**
 * Hello world!
 *
 */
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

        // ----------- BARCO -----------
        GridPane gpBarco = new GridPane();
        gpBarco.setPadding(new Insets(10));
        gpBarco.setVgap(8);
        gpBarco.setHgap(10);

        TextField barcoCor = new TextField();
        TextField barcoTamanho = new TextField();
        TextField barcoVelocidade = new TextField();
        Button barcoSalvar = new Button("Salvar Barco");

        gpBarco.add(new Label("Cor:"), 0, 0);
        gpBarco.add(barcoCor, 1, 0);
        gpBarco.add(new Label("Tamanho:"), 0, 1);
        gpBarco.add(barcoTamanho, 1, 1);
        gpBarco.add(new Label("Velocidade:"), 0, 2);
        gpBarco.add(barcoVelocidade, 1, 2);
        gpBarco.add(barcoSalvar, 1, 3);

        Tab tabBarco = new Tab("Barco", gpBarco);
        tabBarco.setClosable(false);

        barcoSalvar.setOnAction(e -> {
            try {
                Barco b = new Barco(barcoCor.getText(),
                        Integer.parseInt(barcoTamanho.getText()),
                        Integer.parseInt(barcoVelocidade.getText()));
                try (FileWriter w = new FileWriter("barco.csv", true)) {
                    w.write(b.getCor() + "," + b.getTamanho() + "," + b.getVelocidade() + "\n");
                }
                showAlert("Sucesso", "Barco salvo!");
            } catch (Exception ex) {
                showAlert("Erro", ex.getMessage());
            }
        });

        // ----------- CARRO -----------
        GridPane gpCarro = new GridPane();
        gpCarro.setPadding(new Insets(10));
        gpCarro.setVgap(8);
        gpCarro.setHgap(10);

        TextField carroCor = new TextField();
        TextField carroVelocidade = new TextField();
        TextField carroPreco = new TextField();
        Button carroSalvar = new Button("Salvar Carro");

        gpCarro.add(new Label("Cor:"), 0, 0);
        gpCarro.add(carroCor, 1, 0);
        gpCarro.add(new Label("Velocidade:"), 0, 1);
        gpCarro.add(carroVelocidade, 1, 1);
        gpCarro.add(new Label("Preço:"), 0, 2);
        gpCarro.add(carroPreco, 1, 2);
        gpCarro.add(carroSalvar, 1, 3);

        Tab tabCarro = new Tab("Carro", gpCarro);
        tabCarro.setClosable(false);

        carroSalvar.setOnAction(e -> {
            try {
                Carro c = new Carro(carroCor.getText(),
                        Integer.parseInt(carroVelocidade.getText()),
                        Integer.parseInt(carroPreco.getText()));
                try (FileWriter w = new FileWriter("carro.csv", true)) {
                    w.write(c.getCor() + "," + c.getVelocidade() + "," + c.getPreco() + "\n");
                }
                showAlert("Sucesso", "Carro salvo!");
            } catch (Exception ex) {
                showAlert("Erro", ex.getMessage());
            }
        });

        // ----------- JORNAL -----------
        GridPane gpJornal = new GridPane();
        gpJornal.setPadding(new Insets(10));
        gpJornal.setVgap(8);
        gpJornal.setHgap(10);

        TextField jornalTamanho = new TextField();
        TextField jornalPreco = new TextField();
        CheckBox jornalAberto = new CheckBox("Aberto");
        Button jornalSalvar = new Button("Salvar Jornal");

        gpJornal.add(new Label("Tamanho:"), 0, 0);
        gpJornal.add(jornalTamanho, 1, 0);
        gpJornal.add(new Label("Preço:"), 0, 1);
        gpJornal.add(jornalPreco, 1, 1);
        gpJornal.add(jornalAberto, 1, 2);
        gpJornal.add(jornalSalvar, 1, 3);

        Tab tabJornal = new Tab("Jornal", gpJornal);
        tabJornal.setClosable(false);

        jornalSalvar.setOnAction(e -> {
            try {
                Jornal j = new Jornal(Integer.parseInt(jornalTamanho.getText()),
                        Integer.parseInt(jornalPreco.getText()),
                        jornalAberto.isSelected());
                try (FileWriter w = new FileWriter("jornal.csv", true)) {
                    w.write(j.getTamanho() + "," + j.getPreco() + "," + (jornalAberto.isSelected() ? "Aberto" : "Fechado") + "\n");
                }
                showAlert("Sucesso", "Jornal salvo!");
            } catch (Exception ex) {
                showAlert("Erro", ex.getMessage());
            }
        });

        // ----------- PONTE -----------
        GridPane gpPonte = new GridPane();
        gpPonte.setPadding(new Insets(10));
        gpPonte.setVgap(8);
        gpPonte.setHgap(10);

        TextField ponteMaterial = new TextField();
        TextField ponteLargura = new TextField();
        TextField ponteLocalizacao = new TextField();
        Button ponteSalvar = new Button("Salvar Ponte");

        gpPonte.add(new Label("Material:"), 0, 0);
        gpPonte.add(ponteMaterial, 1, 0);
        gpPonte.add(new Label("Largura:"), 0, 1);
        gpPonte.add(ponteLargura, 1, 1);
        gpPonte.add(new Label("Localização:"), 0, 2);
        gpPonte.add(ponteLocalizacao, 1, 2);
        gpPonte.add(ponteSalvar, 1, 3);

        Tab tabPonte = new Tab("Ponte", gpPonte);
        tabPonte.setClosable(false);

        ponteSalvar.setOnAction(e -> {
            try {
                Ponte p = new Ponte(ponteMaterial.getText(),
                        Integer.parseInt(ponteLargura.getText()),
                        ponteLocalizacao.getText());
                try (FileWriter w = new FileWriter("ponte.csv", true)) {
                    w.write(p.getMaterial() + "," + p.getLargura() + "," + p.getLocalizacao() + "\n");
                }
                showAlert("Sucesso", "Ponte salva!");
            } catch (Exception ex) {
                showAlert("Erro", ex.getMessage());
            }
        });

        // ----------- PRÉDIO -----------
        GridPane gpPredio = new GridPane();
        gpPredio.setPadding(new Insets(10));
        gpPredio.setVgap(8);
        gpPredio.setHgap(10);

        TextField predioCor = new TextField();
        CheckBox predioPorta = new CheckBox("Porta Principal");
        TextField predioPessoas = new TextField();
        Button predioSalvar = new Button("Salvar Prédio");

        gpPredio.add(new Label("Cor:"), 0, 0);
        gpPredio.add(predioCor, 1, 0);
        gpPredio.add(predioPorta, 1, 1);
        gpPredio.add(new Label("Qtd Pessoas:"), 0, 2);
        gpPredio.add(predioPessoas, 1, 2);
        gpPredio.add(predioSalvar, 1, 3);

        Tab tabPredio = new Tab("Prédio", gpPredio);
        tabPredio.setClosable(false);

        predioSalvar.setOnAction(e -> {
            try {
                Predio p = new Predio(predioCor.getText(),
                        predioPorta.isSelected(),
                        Integer.parseInt(predioPessoas.getText()));
                try (FileWriter w = new FileWriter("predio.csv", true)) {
                    w.write(p.getCor() + "," + (predioPorta.isSelected() ? "Porta Principal" : "Sem Porta Principal") + "," + p.getQntdpessoas() + "\n");
                }
                showAlert("Sucesso", "Prédio salvo!");
            } catch (Exception ex) {
                showAlert("Erro", ex.getMessage());
            }
        });

        // ----------- TORRE EIFFEL -----------
        GridPane gpTorre = new GridPane();
        gpTorre.setPadding(new Insets(10));
        gpTorre.setVgap(8);
        gpTorre.setHgap(10);

        TextField torreMaterial = new TextField();
        TextField torreTamanho = new TextField();
        CheckBox torreLuzes = new CheckBox("Luzes Ligadas");
        Button torreSalvar = new Button("Salvar Torre Eiffel");

        gpTorre.add(new Label("Material:"), 0, 0);
        gpTorre.add(torreMaterial, 1, 0);
        gpTorre.add(new Label("Tamanho:"), 0, 1);
        gpTorre.add(torreTamanho, 1, 1);
        gpTorre.add(torreLuzes, 1, 2);
        gpTorre.add(torreSalvar, 1, 3);

        Tab tabTorre = new Tab("Torre Eiffel", gpTorre);
        tabTorre.setClosable(false);

        torreSalvar.setOnAction(e -> {
            try {
                TorreEiffel t = new TorreEiffel(torreMaterial.getText(),
                        torreTamanho.getText(),
                        torreLuzes.isSelected());
                try (FileWriter w = new FileWriter("torreeiffel.csv", true)) {
                    w.write(t.getMaterial() + "," + t.getTamanho() + "," + (torreLuzes.isSelected() ? "Luzes Ligadas" : "Luzes Desligadas") + "\n");
                }
                showAlert("Sucesso", "Torre Eiffel salva!");
            } catch (Exception ex) {
                showAlert("Erro", ex.getMessage());
            }
        });

        // ----------- ADD TABS -----------
        tabPane.getTabs().addAll(tabBarco, tabCarro, tabJornal, tabPonte, tabPredio, tabTorre);

        Scene scene = new Scene(tabPane, 450, 320);
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
