package entidades;

public class Playlist {
    private int id;
    private String nome;
    private int usuarioId;

    public Playlist() {}

    public Playlist(String nome, int usuarioId) {
        this.nome = nome;
        this.usuarioId = usuarioId;
    }

    public Playlist(int id, String nome, int usuarioId) {
        this(nome, usuarioId);
        this.id = id;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getUsuarioId() { return usuarioId; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
}
