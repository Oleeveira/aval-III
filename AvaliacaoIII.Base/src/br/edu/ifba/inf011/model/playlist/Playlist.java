package br.edu.ifba.inf011.model.playlist;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.Visitors.BandwidthVisitor;
import br.edu.ifba.inf011.model.Visitors.ReportVisitor;
import br.edu.ifba.inf011.model.Visitors.XMLVisitor;

public class Playlist {
    private List<PlaylistItem> items;
    
    public Playlist() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(PlaylistItem item) {
        this.items.add(item);
    }
    
    public String toXML() {
        XMLVisitor visitor = new XMLVisitor();
        StringBuilder xml = new StringBuilder("<playlist>\n");
        for(PlaylistItem item : this.items) {
            xml.append(item.accept(visitor));
        }
        xml.append("</playlist>\n");
        return xml.toString();
    }

    public Double getBandaTotal() {
        BandwidthVisitor visitor = new BandwidthVisitor();
        return this.items.stream()
                         .mapToDouble(item -> item.accept(visitor))
                         .sum();
    }

	public String getRelatorioNomes() {
        ReportVisitor visitor = new ReportVisitor();
        StringBuilder relatorio = new StringBuilder("=== RELATÓRIO DE NOMES DA PLAYLIST ===\n");
        for(PlaylistItem item : this.items) {
            relatorio.append(item.accept(visitor));
        }
        return relatorio.toString();
    }
}