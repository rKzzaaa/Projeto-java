package database;

import entidades.HistoricoAcao;
import java.sql.*;
import java.util.*;

public class HistoricoAcaoDAO {
    private final Connection conn;

    public HistoricoAcaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void registrarAcao(HistoricoAcao acao) throws SQLException {
        String sql = "INSERT INTO historico_acoes (usuario_id, musica_id, termo_buscado, tipo_acao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, acao.getUsuarioId());
            if (acao.getMusicaId() != null) stmt.setInt(2, acao.getMusicaId()); else stmt.setNull(2, Types.INTEGER);
            stmt.setString(3, acao.getTermo());
            stmt.setString(4, acao.getTipo());
            stmt.executeUpdate();
        }
    }

    public List<HistoricoAcao> ultimasBuscas(int usuarioId) throws SQLException {
        List<HistoricoAcao> historico = new ArrayList<>();
        String sql = "SELECT * FROM historico_acoes WHERE usuario_id = ? AND tipo_acao = 'buscar' ORDER BY data_acao DESC LIMIT 10";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                historico.add(new HistoricoAcao(
                    rs.getInt("id"),
                    rs.getInt("usuario_id"),
                    rs.getObject("musica_id", Integer.class),
                    rs.getString("termo_buscado"),
                    rs.getString("tipo_acao"),
                    rs.getString("data_acao")
                ));
            }
        }
        return historico;
    }
}