package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.model.Visitors.PlaylistVisitor;

public class MP3 implements PlaylistItem {
    public String nome;
    public double tamanhoMegaBytes;

    public MP3(String nome, double tamanho) { 
        this.nome = nome; 
        this.tamanhoMegaBytes = tamanho; 
    }
    
    public double getTamanhoMegaBytes() { return this.tamanhoMegaBytes; }
    public String getNome() { return this.nome; }

    @Override
    public <T> T accept(PlaylistVisitor<T> visitor) {
        return visitor.visit(this);
    }
}