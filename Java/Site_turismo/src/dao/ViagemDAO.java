package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import connection.ConnectionMySQL;
import model.Viagem;

public class ViagemDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	//Metodo salvar
	public void save(Viagem viagem) {
		String sql = "INSERT INTO viagem(origem, destino, data_ida, data_volta, qtd_viajantes, qtd_quartos, id_viajante)"
				+ "values(?, ?, ?, ?, ?, ?, ?)";

		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, viagem.getOrigem());
			pstm.setString(2, viagem.getDestino());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(3, new Date(formatter.parse(viagem.getDataIda()).getTime()));
			pstm.setDate(4, new Date(formatter.parse(viagem.getDataVolta()).getTime()));
			pstm.setInt(5, viagem.getQtdViajantes());
			pstm.setInt(6, viagem.getQtdQuartos());
			pstm.setInt(7, viagem.getViajante().getId());
			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
