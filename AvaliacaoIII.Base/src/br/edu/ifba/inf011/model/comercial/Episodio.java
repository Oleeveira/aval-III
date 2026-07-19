package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.model.Visitors.PlaylistVisitor;

public class Episodio implements ItemComercial {
	
	private String titulo;
    private Double preco;
    private Timeline timeline;
    private Integer numero;

	public Episodio(String titulo, Double preco, Integer numero, Timeline timeline) {
    	this.titulo = titulo;
        this.preco = preco;
        this.timeline = timeline;
        this.numero = numero;
	}
	
	@Override
    public Double getPreco() {
    	return this.preco; 
    }
    
	@Override
    public Double getDuracao() { 
        return this.timeline.getDurationInSeconds().doubleValue();
    }

	@Override
	public String getTitulo() {
		return this.titulo;
	}

	public Integer getNumero() {
		return this.numero;
	}
	
	@Override
    public <T> T accept(PlaylistVisitor<T> visitor) {
        return visitor.visit(this);
    }
}