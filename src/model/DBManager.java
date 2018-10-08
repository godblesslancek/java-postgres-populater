package model;

import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DBManager {

    private static DBManager instance = null ;
    private DBManager(){

    }

    public static DBManager getInstance(){
        if (instance==null){
            instance = new DBManager();
        }
        return instance;
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void printAllBases() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Example","postgres","newPassword");
            PreparedStatement stmt = con.prepareStatement("SELECT datname FROM pg_database WHERE datistemplate = false");
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                System.out.println(res.getString(1));}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> arrayAllBases() {
        ArrayList<String> tables = new ArrayList<String>();
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Example","postgres","newPassword");
            PreparedStatement stmt = con.prepareStatement("SELECT datname FROM pg_database WHERE datistemplate = false");
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                tables.add(res.getString(1));}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return tables;
    }

    public ArrayList<String> arraySpecTables(String base) {
        ArrayList<String> tables = new ArrayList<String>();
        try { // essayer de mettre un listener!!
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+base,"postgres","newPassword");
            PreparedStatement stmt = con.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema='public'");
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                tables.add(res.getString(1));}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return tables;
    }

    public void printBCP() {//connexion, imprime 2 colonnes de la table public.bank_card_people
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Example","postgres","newPassword");
            PreparedStatement stmt = con.prepareStatement("select * from public.bank_card_people");
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                System.out.println(res.getString(1)+ " " + res.getString(2)+ " " + res.getString(3));}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertIntoBCP(String firstName, String lastName, String cardNumber){   //insère une ligne dans la table bankcardpeople
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Example","postgres","newPassword");
            String SQL = "insert into public.bank_card_people (\"first-name\", \"last-name\", \"card-number\") VALUES (?,?,?)";

            PreparedStatement stmt2 = con.prepareStatement(SQL);
            stmt2.setString(1,firstName);
            stmt2.setString(2,lastName);
            stmt2.setString(3,cardNumber);
            stmt2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertInto(String table, ArrayList<String> datas){
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Example","postgres","newPassword");
            //queries qui vont chercher les noms des colonnes
            String SQL = "insert into public."+table+" (\"first-name\", \"last-name\", \"card-number\") VALUES (?,?,?)";

            PreparedStatement stmt2 = con.prepareStatement(SQL);
            stmt2.setString(1,table);
            int i=1;
            for(String data : datas){
                stmt2.setString(i,data);
                i++;
            }
            stmt2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet arrayCertainTable(String base, String table){
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+base,"postgres","newPassword");
            String SQL = "select * from public."+table;
            PreparedStatement stmt = con.prepareStatement(SQL);
            ResultSet res = stmt.executeQuery();
            return res;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


}