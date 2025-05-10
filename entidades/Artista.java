package entidades;

public class Artista extends Pessoa {
    private String genero;

    public Artista() {}

    public Artista(int id, String nome, String genero) {
        super(id, nome);
        this.genero = genero;
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}