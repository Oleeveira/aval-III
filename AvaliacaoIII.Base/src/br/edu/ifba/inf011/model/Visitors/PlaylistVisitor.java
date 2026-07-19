package br.edu.ifba.inf011.model.Visitors;

import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Video;

public interface PlaylistVisitor<T> {
    T visit(Filme filme);
    T visit(Episodio episodio);
    T visit(Serie serie);
    T visit(Pacote pacote);
    T visit(MP3 mp3);
    T visit(Video video);
}
