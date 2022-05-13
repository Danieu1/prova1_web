package prova.com.prova.DAO;
import prova.com.prova.model.Livro;
import prova.com.prova.DAO.Conecxao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public static  void criacaoTabela(){

        PreparedStatement stm = null;
        Connection con = null;

        try {

        /*
        private String Nome;
        private String Autor;
        private int ISBN;   //id
        private  float Preco;
        private String Editora;
        private String Genero;
        */
      
            con = BD.getConnection();
            stm = con.prepareStatement(
                    "CREATE TABLE `Livro` (\n" +
                            "  `Nome` varchar(45) DEFAULT NULL,\n" +
                            "  `Autor` varchar(45) DEFAULT NULL,\n" +
                            "  `ISBN` int NOT NULL,\n" +
                            "  `Preco` real DEFAULT NULL,\n" +
                            "  `Editora` varchar(45) DEFAULT NULL,\n" +
                            "  `Genero` int DEFAULT NULL,\n" +
                            "  PRIMARY KEY (`ISBN`)\n" +
                            ");");
            stm.executeUpdate();
        }catch ( Exception e){

        }

    }

    public static List<Livro> buscarLivros() {
        PreparedStatement stm= null;
        ResultSet result= null;
        Connection con = null;
        try {
            List<Livro> livros = new ArrayList<>() ;

            con = BD.getConnection();//CONECTANDO
            stm = con.prepareStatement(
                    "SELECT * FROM Livro");
            result = stm.executeQuery();
            while (result.next()) {

            /*
            private String Nome;
            private String Autor;
            private int ISBN;   //id
            private  float Preco;
            private String Editora;
            private String Genero;
            */

                Livro l = new Livro();
                l.setNome(result.getString("Nome"));
                l.setAutor(result.getString("Autor"));
                l.setISBN(result.getInt("ISBN"));
                l.setPreco(result.getFloat("Preco"));
                l.setEditora(result.getString("Editora"));
                l.setGenero(result.getString("Genero"));

                System.out.println(l);

                livros.add(l);
            }

            return  livros;
        }
        catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

        finally {
            BD.closeStatement(stm);
            BD.closeResultSet(result);
        }
    }
//-------------------- INSERIR

    public static void inserir (Livro livro){
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = BD.getConnection();

        
            stm = con.prepareStatement(
                    "INSERT INTO Livro "
                            + "(Nome, Autor, ISBN, Preco, Editora, Genero)"
                            + "VALUES "
                            + "(?, ?, ?, ?, ?, ?)"
                  );

                    stm.setString(1, livro.getNome());
            
    
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.closeStatement(stm);
            BD.closeConnection();

        }

    }


}