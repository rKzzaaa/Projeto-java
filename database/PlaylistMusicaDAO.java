package database;

import java.sql.*;

public class PlaylistMusicaDAO {
    private final Connection conn;

    public PlaylistMusicaDAO(Connection conn) {
        this.conn = conn;
    }

    public void adicionarMusica(int playlistId, int musicaId) throws SQLException {
        String sql = "INSERT INTO playlist_musicas (playlist_id, musica_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }

    public void removerMusica(int playlistId, int musicaId) throws SQLException {
        String sql = "DELETE FROM playlist_musicas WHERE playlist_id = ? AND musica_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }
}