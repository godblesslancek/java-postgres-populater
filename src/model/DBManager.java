package model;

import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DBManager(){
    }

    public void printAllBases() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Benerator","postgres","newPassword");
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
        ArrayList<String> bases = new ArrayList<String>();
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Benerator","postgres","newPassword");
            PreparedStatement stmt = con.prepareStatement("SELECT datname FROM pg_database WHERE datistemplate = false");
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                bases.add(res.getString(1));}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bases;
    }

    public void printBCP() {//connexion, imprime 2 colonnes de la table public.bank_card_people
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Benerator","postgres","newPassword");
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
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Benerator","postgres","newPassword");
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


}