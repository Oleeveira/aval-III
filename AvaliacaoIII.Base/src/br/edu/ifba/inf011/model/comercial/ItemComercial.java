package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.model.playlist.PlaylistItem;

public interface ItemComercial extends PlaylistItem {
    public Double getPreco();
    public Double getDuracao(); 
    public String getTitulo();
}