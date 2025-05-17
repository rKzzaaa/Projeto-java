package database;

import entidades.Administrador;
import entidades.Artista;
import entidades.Musica;
import java.sql.*;

public class AdministradorDAO {
    private final Connection conn;

    public AdministradorDAO(Connection conn) {
        this.conn = conn;
    }

    public int cadastrarAdministrador(Administrador admin) throws SQLException {
        String sql = "INSERT INTO administradores (nome, nome_usuario, senha_hash) VALUES (?, ?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getNomeUsuario());
            stmt.setString(3, admin.getSenhaHash());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    public Administrador autenticar(String nomeUsuario, String senhaHash) throws SQLException {
        String sql = "SELECT * FROM administradores WHERE nome_usuario = ? AND senha_hash = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeUsuario);
            stmt.setString(2, senhaHash);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Administrador(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("nome_usuario"),
                    rs.getString("senha_hash")
                );
            }
        }
        return null;
    }

    public int adicionarArtista(Artista artista) throws SQLException {
        String sql = "INSERT INTO artistas (nome, genero) VALUES (?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, artista.getNome());
            stmt.setString(2, artista.getGenero());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    public int adicionarMusica(Musica musica) throws SQLException {
        String sql = "INSERT INTO musicas (titulo, artista_id, genero, duracao_segundos) VALUES (?, ?, ?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, musica.getTitulo());
            stmt.setInt(2, musica.getArtistaId());
            stmt.setString(3, musica.getGenero());
            stmt.setInt(4, musica.getDuracao());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }
}
