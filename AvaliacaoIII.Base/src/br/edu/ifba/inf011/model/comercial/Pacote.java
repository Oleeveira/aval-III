package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.Visitors.PlaylistVisitor;

public class Pacote implements ItemComercial {
    protected String titulo;
    protected List<ItemComercial> itens;
        
    public Pacote(String titulo) {
        this.titulo = titulo;
        this.itens = new ArrayList<>();
    }
        
    // Construtor mantido para retrocompatibilidade com o ClienteAval3
    public Pacote(String titulo, List<Filme> filmes) {
        this.titulo = titulo;
        this.itens = new ArrayList<>(filmes);
    }       
        
    public void addItem(ItemComercial item) {
        this.itens.add(item);
    }
    
    public List<ItemComercial> getItens() {
        return this.itens;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
            
    @Override
    public Double getPreco() {
        double soma = this.itens.stream().mapToDouble(ItemComercial::getPreco).sum();
        return soma * 0.9;
    }
            
    @Override
    public Double getDuracao() {
        return this.itens.stream().mapToDouble(ItemComercial::getDuracao).sum();
    }   
        
    @Override
    public <T> T accept(PlaylistVisitor<T> visitor) {
        return visitor.visit(this);
    }
}