package com.example.gasolinerajava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Stage primaryStage;
    private String combustible;
    private String litros;
    private String importe;
    private String metodoPago;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        SQLconnection sqlconnection = new SQLconnection("localhost", "3306", "gasolinera", "isaacYalex", "12345678Gasolinera");
        sqlconnection.createTables();
        sqlconnection.insertData();
        showPantallaInicial();
    }

    public void showPantallaInicial() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();
        SeleccionCombustibleController controller = loader.getController();
        controller.setMain(this);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Gasolinera Autoservicio");
        primaryStage.show();
    }

    public void showPantallaCantidad() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("importe.fxml"));
        Parent root = loader.load();
        SeleccionCantidadController controller = loader.getController();
        controller.setMain(this);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showPantallaMetodoPago() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pago.fxml"));
        Parent root = loader.load();
        MetodoPagoController controller = loader.getController();
        controller.setMain(this);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showIntroducirBilletes() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("efectivo.fxml"));
        Parent root = loader.load();
        IntroducirBilletesController controller = loader.getController();
        controller.setMain(this);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showIntroducirDatosTarjeta() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tarjeta.fxml"));
        Parent root = loader.load();
        DatosTarjetaController controller = loader.getController();
        controller.setMain(this);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showTicket() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tiket.fxml"));
        Parent root = loader.load();
        TicketController controller = loader.getController();
        controller.setMain(this);
        controller.setTicketInfo(combustible, litros, importe, metodoPago);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showGraciasCompra() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gracias.fxml"));
        Parent root = loader.load();
        GraciasCompraController controller = loader.getController();
        controller.setMain(this);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setLitros(String litros) {
        this.litros = litros;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}