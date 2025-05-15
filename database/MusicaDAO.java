package database;

import entidades.Musica;
import java.sql.*;
import java.util.*;

public class MusicaDAO {
    private final Connection conn;

    public MusicaDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Musica> buscarPorTermo(String termo) throws SQLException {
        List<Musica> musicas = new ArrayList<>();
        String sql = "SELECT * FROM musicas WHERE titulo ILIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            String like = "%" + termo + "%";
            stmt.setString(1, like);
            stmt.setString(2, like);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                musicas.add(new Musica(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getInt("artista_id"),
                    rs.getString("genero"),
                    rs.getInt("duracao_segundos")
                ));
            }
        }
        return musicas;
    }
}