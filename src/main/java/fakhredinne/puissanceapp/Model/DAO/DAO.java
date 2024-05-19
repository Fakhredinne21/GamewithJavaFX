package fakhredinne.puissanceapp.Model.DAO;

import fakhredinne.puissanceapp.config.MyConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO <T> {
    public abstract T create(T a) throws SQLException, ClassNotFoundException;


    public abstract T find(T a) throws SQLException, ClassNotFoundException;

   public abstract List<T> findAll() throws SQLException, ClassNotFoundException;

   public abstract T update(T a) throws SQLException, ClassNotFoundException;

   public abstract T delete(T a) throws SQLException, ClassNotFoundException;
    public static Connection connection() throws SQLException, ClassNotFoundException {
        return MyConnection.getInstance();
    }
}
