package database;

import entidades.Usuario;
import entidades.Playlist;
import java.sql.*;

public class UsuarioDAO {
    private final Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public int cadastrarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, nome_usuario, senha_hash) VALUES (?, ?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getNomeUsuario());
            stmt.setString(3, usuario.getSenhaHash());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("id");
                criarPlaylistsFixas(userId);
                return userId;
            }
            return -1;
        }
    }

    private void criarPlaylistsFixas(int usuarioId) throws SQLException {
        PlaylistDAO playlistDAO = new PlaylistDAO(conn);
        playlistDAO.criarPlaylist("Curtidas", usuarioId);
        playlistDAO.criarPlaylist("Descurtidas", usuarioId);
    }

    public Usuario buscarPorNomeUsuario(String nomeUsuario) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE nome_usuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("nome_usuario"),
                    rs.getString("senha_hash")
                );
            }
            return null;
        }
    }
}