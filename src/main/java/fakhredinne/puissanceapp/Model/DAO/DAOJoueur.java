package fakhredinne.puissanceapp.Model.DAO;

import fakhredinne.puissanceapp.Model.Joueur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOJoueur extends DAO<Joueur>{
    @Override
   public Joueur create(Joueur a) {
        return null;
    }

    @Override
  public  Joueur find(Joueur j1) throws SQLException, ClassNotFoundException {
        Connection conn= null;
        conn= DAO.connection();
        int idj1=j1.getId();
        String requete = "SELECT * FROM Joueur WHERE id = ?" ;
        ResultSet rs;
        PreparedStatement ps=conn.prepareStatement(requete);
        ps.setInt(1,idj1);
        rs = ps.executeQuery(requete);
        return new Joueur( rs.getInt("id"),rs.getString("Nom"),rs.getInt("score"));
    }
    public  Joueur findById(int idj) throws SQLException, ClassNotFoundException {
        Connection conn= null;
        conn= DAO.connection();
        String requete = "SELECT * FROM joueur WHERE id = ?";
        ResultSet rs;
        PreparedStatement ps=conn.prepareStatement(requete);
        ps.setInt(1,idj);
        rs = ps.executeQuery();
        if (rs.next()) {
            return new Joueur( rs.getInt("id"),rs.getString("Nom"),rs.getInt("score"));
        } else {
            return null; // or throw an exception, depending on your use case
        }
    }

    @Override
   public List<Joueur> findAll() throws SQLException, ClassNotFoundException {
        Connection conn= null;
        conn= DAO.connection();

        String requete = "select * from joueur ";
        Statement ps;
        ResultSet rs;
        ps= conn.createStatement();
        rs = ps.executeQuery(requete);
        List<Joueur> list = new ArrayList<>();
        while (rs.next()) {
            Joueur j=new Joueur( rs.getInt("id"),rs.getString("Nom"),rs.getInt("score"));
            list.add(j);
        }
        return  list;

    }

    @Override
    public Joueur update(Joueur a) throws SQLException, ClassNotFoundException {
        Connection conn= null;
        conn= DAO.connection();
        int idj1=a.getId();
        int scorej1=a.getScore();
        String requete = "update Joueur set score = ? WHERE id = ?" ;
        PreparedStatement ps=conn.prepareStatement(requete);
        ps.setInt(1, scorej1); // set score
        ps.setInt(2, idj1); // set id
        ps.executeUpdate();
        return a;
    }


    @Override
    public Joueur delete(Joueur a) throws SQLException, ClassNotFoundException {
        Connection conn= null;
        conn= DAO.connection();
        int idj1=a.getId();
        String requete = "DELETE FROM Joueur WHERE id = ?" ;
        PreparedStatement ps=conn.prepareStatement(requete);
        ps.setString(idj1,"id");
        ps.executeUpdate();
        return a;

    }


}
