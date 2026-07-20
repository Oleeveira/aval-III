package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.temp_visitors.PlaylistVisitor;

public class Serie implements ItemComercial {

    protected String titulo;
    protected Integer temporada;
    protected List<Episodio> episodios;

    public Serie(String titulo, Integer temporada) {
        this.titulo = titulo;
        this.temporada = temporada;
        this.episodios = new ArrayList<Episodio>();
    }
    
    public Serie(String titulo, Integer temporada, List<Episodio> episodios) {
        this.titulo = titulo;
        this.temporada = temporada;
        this.episodios = episodios;
    }
    
    public void addEpisodio(Episodio episodio) {
    	this.episodios.add(episodio);
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public Double getPreco() {
        double soma = this.episodios.stream().mapToDouble(Episodio::getPreco).sum();
        return soma * 0.9;
    }

    @Override
    public Double getDuracao() {
        return this.episodios.stream().mapToDouble(Episodio::getDuracao).sum();
    }

    public Integer getTemporada() {
        return this.temporada;
    }

    @Override
    public <T> T accept(PlaylistVisitor<T> visitor) {
        return visitor.visit(this);
    }

   public List<Episodio> getEpisodios() {
        return this.episodios;
    }
}