package br.edu.ifba.inf011.model.visitors;

import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.ItemComercial;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.PlaylistItem;
import br.edu.ifba.inf011.model.playlist.Video;

public class BandwidthVisitor implements PlaylistVisitor<Double> {

    @Override
    public Double visit(Filme filme) {
        return filme.getDuracao() * PlaylistItem.BAND_PER_SECOND;
    }

    @Override
    public Double visit(Episodio episodio) {
        return episodio.getDuracao() * PlaylistItem.BAND_PER_SECOND;
    }

    @Override
    public Double visit(Serie serie) {
        return serie.getDuracao() * PlaylistItem.BAND_PER_SECOND;
    }

    @Override
    public Double visit(Pacote pacote) {
        double bandaTotal = 0.0;
        for (ItemComercial item : pacote.getItens()) {
            bandaTotal += item.accept(this);
        }
        return bandaTotal;
    }

    @Override
    public Double visit(MP3 mp3) {
        return mp3.getTamanhoMegaBytes();
    }

    @Override
    public Double visit(Video video) {
        return video.getTamanhoMegaBytes();
    }
    
}