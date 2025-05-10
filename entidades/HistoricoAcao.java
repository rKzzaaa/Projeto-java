package entidades;

public class HistoricoAcao {
    private int id;
    private int usuarioId;
    private Integer musicaId;
    private String termo;
    private String tipo;
    private String data;

    public HistoricoAcao() {}

    public HistoricoAcao(int id, int usuarioId, Integer musicaId, String termo, String tipo, String data) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.musicaId = musicaId;
        this.termo = termo;
        this.tipo = tipo;
        this.data = data;
    }

    public int getId() { return id; }
    public int getUsuarioId() { return usuarioId; }
    public Integer getMusicaId() { return musicaId; }
    public String getTermo() { return termo; }
    public String getTipo() { return tipo; }
    public String getData() { return data; }

    public void setId(int id) { this.id = id; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public void setMusicaId(Integer musicaId) { this.musicaId = musicaId; }
    public void setTermo(String termo) { this.termo = termo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setData(String data) { this.data = data; }
}
