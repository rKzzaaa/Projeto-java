package entidades;

public class Adm extends Pessoa implements Autenticacao {
    private String nomeUsuario;
    private String senhaHash;

    public Adm() {}

    public Adm(int id, String nome, String nomeUsuario, String senhaHash) {
        super(id, nome);
        this.nomeUsuario = nomeUsuario;
        this.senhaHash = senhaHash;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    @Override
    public boolean autenticar(String usuario, String senhaHash) {
        return this.nomeUsuario.equals(usuario) && this.senhaHash.equals(senhaHash);
    }
}
