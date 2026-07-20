# Avaliação III — INF011 Padrões de Projeto

## Questão I — Catálogo Promocional (Pacotes Aninhados)
**Padrões aplicados: Composite + Builder**

### Justificativas:
#### Composite
    O padrão Composite foi utilizado para permitir que Filmes,
    Séries e Pacotes sejam tratados de maneira uniforme
    através da interface `ComercialComponent`.
    Dessa forma, o carrinho calcula preço e duração sem precisar 
    distinguir se o item é simples ou composto.

###### Papéis
    Classe | Papel:
        ComercialComponent | Component
        Filme  | Leaf
        Serie  | Composite
        Pacote | Composite

##### Builder
    O Builder foi utilizado para facilitar a criação de pacotes complexos 
    contendo filmes, séries e outros pacotes. A construção incremental torna 
    o código mais legível e elimina construtores extensos e difíceis de manter.

###### Papel
    Classe | Papel:
        PacoteBuilder  | Builder
        Pacote         | Product
        Código cliente | Director (implícito)

## Questão II — Operações Analíticas sobre Playlists
**Padrão aplicado: Visitor**

### Justificativa
#### Visitor
    O Visitor foi utilizado para separar as operações analíticas dos elementos da playlist.
    Novas funcionalidades, como cálculo de largura de banda, exportação para XML ou geração
    de relatórios, podem ser adicionadas criando novos Visitors, sem modificar as classes existentes.

### Papéis
    Classe | Papel:
        PlaylistVisitor   | Visitor
        BandaTotalVisitor | ConcreteVisitor
        RelatorioVisitor  | ConcreteVisitor
        XMLVisitor | ConcreteVisitor
        MP3        | ConcreteElement
        VideoClipe | ConcreteElement
        Filme      | ConcreteElement
        Episodio   | ConcreteElement
        Serie      | Composite que encaminha a visita aos filhos
        Pacote     | Composite que encaminha a visita aos filhos

Com isso, o projeto torna-se mais modular, reutilizável e de fácil manutenção.

`   ~by: Lis Maria Silva Oliveira & Henrique Cardoso dos Santos Passos `