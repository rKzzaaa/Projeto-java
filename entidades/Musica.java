package entidades;

public class Musica {
    private int id;
    private String titulo;
    private int artistaId;
    private String genero;
    private int duracao;

    public Musica() {}

    public Musica(String titulo, int artistaId, String genero, int duracao) {
        this.titulo = titulo;
        this.artistaId = artistaId;
        this.genero = genero;
        this.duracao = duracao;
    }

    public Musica(int id, String titulo, int artistaId, String genero, int duracao) {
        this(titulo, artistaId, genero, duracao);
        this.id = id;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getArtistaId() { return artistaId; }
    public String getGenero() { return genero; }
    public int getDuracao() { return duracao; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setArtistaId(int artistaId) { this.artistaId = artistaId; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setDuracao(int duracao) { this.duracao = duracao; }
}