package br.com.crud.app;

import br.com.crud.dao.ProdutoDAO;
import br.com.crud.model.Produto;

public class main {
    public static void main(String[] args){

        ProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setName("Sabão");
        produto.setCategory("Limpeza");

        // produtoDAO.save(produto);

        /*
        Produto produtoAlterado = new Produto();
        produtoAlterado.setName("Caixa de 12 ovos");
        produtoAlterado.setCategory("Ovos");
        produtoAlterado.setId(3);


        produtoDAO.update(produtoAlterado);
        */

        produtoDAO.deleteByID(5);

        System.out.println("Seus produtos são:");

        for(Produto p : produtoDAO.getProdutos()){
            System.out.println(("id:"+p.getId()+" nome:"+p.getName()+" nategoria: "+p.getCategory()));
        }
    }
}
