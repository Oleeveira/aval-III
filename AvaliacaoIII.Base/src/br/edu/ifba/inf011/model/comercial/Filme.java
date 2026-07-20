package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.model.temp_visitors.PlaylistVisitor;

public class Filme implements ItemComercial {
    private String titulo;
    private Double preco;
    private Timeline timeline;

    public Filme(String titulo, Double preco, Timeline timeline) {
        this.titulo = titulo;
        this.preco = preco;
        this.timeline = timeline;
    }
    
    @Override
    public Double getPreco() { return this.preco; }
    
    @Override
    public Double getDuracao() { return (double) this.timeline.getDurationInSeconds(); }

    @Override
    public String getTitulo() { return this.titulo; }

    @Override
    public <T> T accept(PlaylistVisitor<T> visitor) {
        return visitor.visit(this);
    }      
}