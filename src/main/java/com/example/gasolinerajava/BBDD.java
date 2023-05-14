package com.example.gasolinerajava;

import java.math.BigDecimal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BBDD {

    protected Connection connected;
    protected Statement sentence;
    protected ResultSet result;

    // Constructor para establecer conexión
    public BBDD(String className, String connectionChain, String username, String password){
        try{
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName(className);
            connected = DriverManager.getConnection(connectionChain, username, password);
            connected.setAutoCommit(false);
            System.out.println("Conexión ha sido establecida");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // Getters
    public Connection getConnected() {
        return connected;
    }

    public Statement getSentence() {
        return sentence;
    }

    public ResultSet getResult() {
        return result;
    }



    public void createTables() throws SQLException {
        try (Statement statement = connected.createStatement()) {
            String tablaCombustible = "CREATE TABLE IF NOT EXISTS Combustible" +
                    "(tipo_combustible ENUM('diesel', 'gasolina') PRIMARY KEY NOT NULL, " +
                    "precio DECIMAL(10, 2) not null)";
            statement.executeUpdate(tablaCombustible);
        }
    }

    public void insertData() throws SQLException {


    }

    public void executeQuery(String query) throws SQLException {
        try{
            sentence = connected.createStatement();
            result = sentence.executeQuery(query);
        }catch (SQLException e){
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    // Cerrar conexión
    public void closeResult(){
        try{
            result.close();
        }catch (SQLException e){
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void closeSentence(){
        try {
            sentence.close();
        }
        catch (SQLException e){
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void closeConnection(){
        try{
            if (result != null){
                closeResult();
            }
            if (sentence != null){
                closeSentence();
            }
        } catch (Exception e) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}