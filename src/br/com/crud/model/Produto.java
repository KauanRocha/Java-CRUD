package br.com.crud.model;

public class Produto {
    private int id;
    private String name;
    private String category;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String categoria) {
        this.category = categoria;
    }

    public String getCategory() {
        return category;
    }

}
