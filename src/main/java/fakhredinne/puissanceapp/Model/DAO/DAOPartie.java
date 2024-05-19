package fakhredinne.puissanceapp.Model.DAO;

import fakhredinne.puissanceapp.Model.DAO.DAO;
import fakhredinne.puissanceapp.Model.Joueur;
import fakhredinne.puissanceapp.Model.Partie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPartie extends DAO<Partie> {
    @Override
    public Partie create(Partie a) throws SQLException, ClassNotFoundException {
        Connection conn= null;
        conn= DAO.connection();
        String requete = "INSERT INTO partie (joueur1,joueur2,winner) VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(requete);
        ps.setInt(1, a.getJ1().getId());
        ps.setInt(2, a.getJ2().getId());
        ps.setInt(3, a.getWinner().getId() );
        ps.executeUpdate();
        return a;
    }

    @Override
 public   Partie find(Partie p) throws SQLException, ClassNotFoundException {
        Connection conn= null;
        conn= DAO.connection();

        String requete = "SELECT * FROM partie WHERE joueur1 =? and joueur2=?";
        PreparedStatement ps=conn.prepareStatement(requete);
        ResultSet rs;
        ps.setInt(1, p.getJ1().getId());
        ps.setInt(2, p.getJ2().getId());
        rs=ps.executeQuery(requete);
        return new Partie( rs.getInt("id"),rs.getString("Nom"),rs.getInt("score"));

    }

    @Override
  public  List<Partie> findAll() throws SQLException, ClassNotFoundException {
        Connection conn= null;
        conn= DAO.connection();
        DAOJoueur daoJoueur=new DAOJoueur();
        String requete = "select * from partie ";
        Statement ps;
        ResultSet rs;
        ps= conn.createStatement();
        rs = ps.executeQuery(requete);
        List<Partie> list = new ArrayList<>();
        while (rs.next()) {
            Partie p=new Partie( daoJoueur.findById(rs.getInt("joueur1")),daoJoueur.findById(rs.getInt("joueur2")),daoJoueur.findById(rs.getInt("winner")));
            list.add(p);
        }
        return  list;
    }

    @Override
  public  Partie update(Partie a) {
        return null;
    }

    @Override
   public Partie delete(Partie p) throws SQLException {
        Connection conn=null;
        String requete = "SELECT * FROM Partie WHERE joueur1 =? and joueur2=?";
        PreparedStatement ps=conn.prepareStatement(requete);
        ResultSet rs;
        ps.setInt(1, p.getJ1().getId());
        ps.setInt(2, p.getJ2().getId());
        rs = ps.executeQuery(requete);
        return null;
    }
}
