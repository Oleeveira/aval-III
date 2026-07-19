package br.edu.ifba.inf011.model.Visitors;

import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.ItemComercial;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.PlaylistItem;
import br.edu.ifba.inf011.model.playlist.Video;

public class XMLVisitor implements PlaylistVisitor<String> {

    @Override
    public String visit(Filme filme) {
        return "<filme titulo=\"" + filme.getTitulo() + "\"/>\n";
    }

    @Override
    public String visit(MP3 mp3) {
        return "<mp3 nome=\"" + mp3.getNome() + "\"/>\n";
    }

    @Override
    public String visit(Pacote pacote) {
        // Como o Pacote tem itens internos, iteramos sobre eles
        StringBuilder filmesXML = new StringBuilder();
        for(ItemComercial item : pacote.getItens()) { // Assuma a criação do getter getItens()
            if (item instanceof PlaylistItem) {
                filmesXML.append(((PlaylistItem) item).accept(this));
            }
        }
        return "<pacote titulo=\"" + pacote.getTitulo() + "\">\n" 
             + filmesXML.toString() 
             + "</pacote>\n";
    }

    @Override
    public String visit(Episodio episodio) {
       StringBuilder epXML = new StringBuilder();
       return "<episodio titulo=\"" + episodio.getTitulo() + "\">\n" 
            + epXML.toString() 
            + "</episodio>\n";
    }

    @Override
    public String visit(Serie serie) {
        StringBuilder serieXML = new StringBuilder();
        for(Episodio ep : serie.getEpisodios()) {
            serieXML.append(ep.accept(this));
        }
        return "<serie titulo=\"" + serie.getTitulo() + "\">\n" 
             + serieXML.toString() 
             + "</serie>\n";
    }

    @Override
    public String visit(Video video) {
        return "<video nome=\"" + video.getNome() + "\"/>\n";
    }
    
    
}