package br.com.devdojo.springbootessentials.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Dados {
    private int id;
    private String name;
    public static List<Dados> dadosList;

    static {
        dadosRepository();
    }

    public Dados(int id, String name) {
        this(name);
        this.id = id;
    }

    public Dados(String name) {
        this.name = name;
    }

    public Dados() {

    }

    private static void dadosRepository() {
        dadosList = new ArrayList<>(asList(new Dados(1, "Samsung"), new Dados(2,"Apple")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dados dados = (Dados) o;
        return id == dados.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
