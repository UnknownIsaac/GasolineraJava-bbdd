package com.example.gasolinerajava;

public class SQLconnection extends BBDD {

    public SQLconnection(String host, String port, String db, String user, String password){
        super("com.mysql.cj.jdbc.Driver","jdbc:mysql://" + host + ":" + "/" + db, user, password);
    }
}
