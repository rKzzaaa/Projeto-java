package database;

import entidades.Artista;
import java.sql.*;

public class ArtistaDAO {
    private final Connection conn;

    public ArtistaDAO(Connection conn) {
        this.conn = conn;
    }

    public int inserirArtista(Artista artista) throws SQLException {
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

    public Artista buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM artistas WHERE nome = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Artista(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("genero")
                );
            }
        }
        return null;
    }
}
