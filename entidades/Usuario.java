package model;

public class Usuario {
    private int id;
    private String nome;
    private String nomeUsuario;
    private String senhaHash;

    public Usuario() {}

    public Usuario(int id, String nome, String nomeUsuario, String senhaHash) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senhaHash = senhaHash;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }

    @Override
    public String toString() {
        return "Usuario{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", nomeUsuario='" + nomeUsuario + '\'' +
               '}';
    }
}