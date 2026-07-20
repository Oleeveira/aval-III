package br.edu.ifba.inf011.model.temp_visitors;

import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.ItemComercial;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Video;

public class ReportVisitor implements PlaylistVisitor<String> {

    @Override
    public String visit(Filme filme) {
        return "- Filme: " + filme.getTitulo() + "\n";
    }

    @Override
    public String visit(Episodio episodio) {
        return "- Episódio: " + episodio.getTitulo() + " (Ep. " + episodio.getNumero() + ")\n";
    }

    @Override
    public String visit(Serie serie) {
        StringBuilder sb = new StringBuilder();
        sb.append("- Série: ").append(serie.getTitulo()).append(" (Temporada ").append(serie.getTemporada()).append(")\n");
        for (Episodio ep : serie.getEpisodios()) {
            sb.append("   ").append(ep.accept(this));
        }
        return sb.toString();
    }

  @Override
    public String visit(Pacote pacote) {
        StringBuilder sb = new StringBuilder();
        sb.append("- Pacote: ").append(pacote.getTitulo()).append("\n");
        for (ItemComercial item : pacote.getItens()) {
            String itemStr = item.accept(this);
            sb.append("   ").append(itemStr.trim().replace("\n", "\n   ")).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String visit(MP3 mp3) {
        return "- Áudio MP3: " + mp3.getNome() + "\n";
    }

    @Override
    public String visit(Video video) {
        return "- Vídeo Clipe: " + video.getNome() + "\n";
    }
}
