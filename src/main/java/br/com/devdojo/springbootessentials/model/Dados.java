package br.com.devdojo.springbootessentials.model;

public class Dados {
    private String name;

    public Dados(String name) {
        this.name = name;
    }

    public Dados() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
