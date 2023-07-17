package br.com.crud.dao;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void save(Produto produto){
        String sql = "INSERT INTO produtos(name, category) VALUES (?, ?)";

        Connection conn = null;

        PreparedStatement pstm = null;

        try{
            // cria uma conexão com o DB
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, produto.getName());
            pstm.setString(2, produto.getCategory());

            pstm.execute();

            System.out.println("Produto cadastrado com sucesso!");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // fechar as conexões
            try{
                if (pstm!=null){
                    pstm.close();
                }

                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        }

    public List<Produto> getProdutos() {

        String sql = "SELECT * FROM produtos";

        List<Produto> produtos = new ArrayList<Produto>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;

        try {
            // cria uma conexão com o DB
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while (rst.next()) {
                Produto produto = new Produto();

                produto.setId(rst.getInt("id"));
                produto.setName(rst.getString("name"));
                produto.setCategory(rst.getString("category"));

                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                if (rst != null) {
                    rst.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return produtos;

    }

    public void update(Produto produto){
        String sql = "UPDATE produtos SET name= ?, category= ?"+
                "WHERE id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getName());
            pstm.setString(2, produto.getCategory());

            pstm.setInt(3, produto.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByID(int id){
        String sql = "DELETE FROM produtos where id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try{
            // cria uma conexão com o DB
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

            System.out.println("Produto deletado com sucesso!");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // fechar as conexões
            try{
                if (pstm!=null){
                    pstm.close();
                }

                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

