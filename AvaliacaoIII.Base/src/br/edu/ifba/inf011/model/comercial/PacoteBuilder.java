package br.edu.ifba.inf011.model.comercial;

public class PacoteBuilder {
    private Pacote pacote;

    public PacoteBuilder(String titulo) {
        this.pacote = new Pacote(titulo);
    }

    public PacoteBuilder addItem(ItemComercial item) {
        this.pacote.addItem(item);
        return this;
    }

    public Pacote build() {
        return this.pacote;
    }

    public PacoteBuilder reset(String novoTitulo) {
        this.pacote = new Pacote(novoTitulo);
        return this;
    }
}
