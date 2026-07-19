package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.CinemaTimelineBuilder;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.TimelineBuilder;
import br.edu.ifba.inf011.model.comercial.Episodio;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Serie;
import br.edu.ifba.inf011.model.comercial.PacoteBuilder;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Playlist;
import br.edu.ifba.inf011.model.playlist.Video;

public class ClienteAval3 {

    public void run() {
        
        // 1. Motor Técnico
        TimelineBuilder tBuilder = new CinemaTimelineBuilder();
        Timeline cinemaTimeline = tBuilder.reset().addClassAdapterVideo("MainShot_4K.mov").build();
        
        // 2. Construindo Componentes Base
        Pacote trilogiaMatrix = new PacoteBuilder("Trilogia Matrix")
                .addItem(new Filme("Matrix", 20.0, cinemaTimeline))
                .addItem(new Filme("Matrix Reloaded", 25.0, cinemaTimeline))
                .addItem(new Filme("Matrix Revolutions", 15.0, cinemaTimeline))
                .build();
                
        Pacote pacoteStarWars = new PacoteBuilder("Star Wars Clássicos")
                .addItem(new Filme("Uma Nova Esperança", 20.0, cinemaTimeline))
                .addItem(new Filme("O Império Contra-Ataca", 20.0, cinemaTimeline))
                .build();
                
        Serie blackMirror = new Serie("Black Mirror", 1);
        blackMirror.addEpisodio(new Episodio("Hino Nacional", 5.0, 1, cinemaTimeline));
        blackMirror.addEpisodio(new Episodio("Quinze Milhões de Méritos", 5.0, 2, cinemaTimeline));

        // 3. Padrão Builder + Composite em Ação (Coleção Sci-Fi)
        Pacote colecaoSciFi = new PacoteBuilder("Coleção Sci-Fi")
                .addItem(trilogiaMatrix)
                .addItem(pacoteStarWars)
                .addItem(blackMirror)
                .addItem(new Filme("Blade Runner", 30.0, cinemaTimeline))
                .build();

        // 4. Montando a Playlist Mista
        Playlist playlist = new Playlist();
        playlist.addItem(colecaoSciFi);
        playlist.addItem(new MP3("Tema Matrix", 15.0));
        playlist.addItem(new Video("Trailer Black Mirror", 50.0, "http://link.com"));

        // 5. Acionando as Operações Analíticas (Padrão Visitor)
        System.out.println("=== DADOS COMERCIAIS DA COLEÇÃO ===");
        System.out.println("Preço Final (com descontos compostos): R$ " + colecaoSciFi.getPreco());
        System.out.println("Duração Total (Segundos): " + colecaoSciFi.getDuracao() + "\n");
        
        System.out.println("=== OPERAÇÕES DA CIÊNCIA DE DADOS ===");
        System.out.println("Consumo Total de Banda: " + playlist.getBandaTotal() + " MB\n");
        
        System.out.println(playlist.getRelatorioNomes());
        
        System.out.println("=== EXPORTAÇÃO XML ===");
        System.out.println(playlist.toXML());
    }       

    public static void main(String[] args) {
        new ClienteAval3().run();
    }
}