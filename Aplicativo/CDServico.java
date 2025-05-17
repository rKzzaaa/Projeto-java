package Aplicativo;

import entidades.HistoricoAcao;
import entidades.Playlist;
import java.sql.Connection;
import java.sql.SQLException;

public class CDServico {
    private final PlaylistDAO playlistDAO;
    private final PlaylistMusicaDAO playlistMusicaDAO;
    private final HistoricoAcaoDAO historicoDAO;

    public CurtirService(Connection conn) {
        this.playlistDAO = new PlaylistDAO(conn);
        this.playlistMusicaDAO = new PlaylistMusicaDAO(conn);
        this.historicoDAO = new HistoricoAcaoDAO(conn);
    }

    public void curtirMusica(int usuarioId, int musicaId) throws SQLException {
        Playlist curtidas = playlistDAO.buscarPorNomeEUsuario("Curtidas", usuarioId);
        Playlist descurtidas = playlistDAO.buscarPorNomeEUsuario("Descurtidas", usuarioId);

        if (curtidas != null) playlistMusicaDAO.adicionarMusica(curtidas.getId(), musicaId);
        if (descurtidas != null) playlistMusicaDAO.removerMusica(descurtidas.getId(), musicaId);

        historicoDAO.registrarAcao(new HistoricoAcao(0, usuarioId, musicaId, null, "curtir", null));
    }

    public void descurtirMusica(int usuarioId, int musicaId) throws SQLException {
        Playlist curtidas = playlistDAO.buscarPorNomeEUsuario("Curtidas", usuarioId);
        Playlist descurtidas = playlistDAO.buscarPorNomeEUsuario("Descurtidas", usuarioId);

        if (descurtidas != null) playlistMusicaDAO.adicionarMusica(descurtidas.getId(), musicaId);
        if (curtidas != null) playlistMusicaDAO.removerMusica(curtidas.getId(), musicaId);

        historicoDAO.registrarAcao(new HistoricoAcao(0, usuarioId, musicaId, null, "descurtir", null));
    }
}