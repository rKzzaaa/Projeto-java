package entidades;

public interface Autenticacao {
    boolean autenticar(String usuario, String senhaHash);
}