package database;

import entidades.Playlist;
import java.sql.*;

public class PlaylistDAO {
    private final Connection conn;

    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }

    public int criarPlaylist(String nome, int usuarioId) throws SQLException {
        String sql = "INSERT INTO playlists (nome_playlist, usuario_id) VALUES (?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, usuarioId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
            return -1;
        }
    }

    public Playlist buscarPorNomeEUsuario(String nome, int usuarioId) throws SQLException {
        String sql = "SELECT * FROM playlists WHERE nome_playlist = ? AND usuario_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, usuarioId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Playlist(
                    rs.getInt("id"),
                    rs.getString("nome_playlist"),
                    rs.getInt("usuario_id")
                );
            }
            return null;
        }
    }
}