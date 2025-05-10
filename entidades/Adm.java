package entidades;

public class Administrador extends Pessoa implements Autenticacao {
    private String email;
    private String senha;

    public Administrador() {}

    public Administrador(int id, String nome, String email, String senha) {
        super(id, nome);
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public boolean autenticar(String usuario, String senhaHash) {
        return this.email.equals(usuario) && this.senha.equals(senhaHash);
    }
}