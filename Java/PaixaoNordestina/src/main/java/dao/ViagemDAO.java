package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Viagem;

public class ViagemDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Viagem viagem) {
		String sql = "INSERT INTO viagem(origem, destino, data_ida, data_volta, qtd_viajantes, qtd_quartos, preco, total, dias)"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setString(1, viagem.getOrigem());
			pstm.setString(2, viagem.getDestino());
			pstm.setDate(3, new Date(formatter.parse(viagem.getDataIda()).getTime()));
			pstm.setDate(4, new Date(formatter.parse(viagem.getDataVolta()).getTime()));
			pstm.setInt(5, viagem.getQtdViajantes());
			pstm.setInt(6, viagem.getQtdQuartos());
			pstm.setDouble(7, viagem.getPreco());
			pstm.setDouble(8, viagem.getTotal());
			pstm.setInt(9, viagem.getDias());

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

	public List<Viagem> getViagem() {

		String sql = "SELECT * FROM viagem";

		List<Viagem> listaViagem = new ArrayList<Viagem>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");

			while (rset.next()) {
				Viagem viagem = new Viagem();

				viagem.setId(rset.getInt("id_viagem"));
				viagem.setOrigem(rset.getString("origem"));
				viagem.setDestino(rset.getString("destino"));
				viagem.setDataIda(dataFormat.format(rset.getDate("data_ida")));
				viagem.setDataVolta(dataFormat.format(rset.getDate("data_volta")));
				viagem.setQtdViajantes(rset.getInt("qtd_viajantes"));
				viagem.setQtdQuartos(rset.getInt("qtd_quartos"));
				viagem.setPreco(rset.getDouble("preco"));
				viagem.setTotal(rset.getDouble("total"));
				viagem.setDias(rset.getInt("dias"));

				listaViagem.add(viagem);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
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

		return listaViagem;
	}

	public void update(Viagem viagem) {
		String sql = "UPDATE viagem SET origem = ?, destino = ?, data_ida = ?, data_volta = ?, qtd_viajantes = ?, "
				+ "qtd_quartos = ?, preco = ?, total = ?, dias = ? WHERE id_viagem = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setString(1, viagem.getOrigem());
			pstm.setString(2, viagem.getDestino());
			pstm.setDate(3, new Date(formatter.parse(viagem.getDataIda()).getTime()));
			pstm.setDate(4, new Date(formatter.parse(viagem.getDataVolta()).getTime()));
			pstm.setInt(5, viagem.getQtdViajantes());
			pstm.setInt(6, viagem.getQtdQuartos());
			pstm.setDouble(7, viagem.getPreco());
			pstm.setDouble(8, viagem.getTotal());
			pstm.setInt(9, viagem.getDias());
			pstm.setInt(10, viagem.getId());

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

	public void deleteById(int id) {
		String sql = "DELETE FROM viagem WHERE id_viagem = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

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

	public Viagem getViagemById(int id) {
		String sql = "SELECT * FROM viagem WHERE id_viagem = ?";

		Viagem viagem = new Viagem();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			viagem.setId(rset.getInt("id_viagem"));
			viagem.setOrigem(rset.getString("origem"));
			viagem.setDestino(rset.getString("destino"));
			viagem.setDataIda(dataFormat.format(rset.getDate("data_ida")));
			viagem.setDataVolta(dataFormat.format(rset.getDate("data_volta")));
			viagem.setQtdViajantes(rset.getInt("qtd_viajantes"));
			viagem.setQtdQuartos(rset.getInt("qtd_quartos"));
			viagem.setPreco(rset.getDouble("preco"));
			viagem.setTotal(rset.getDouble("total"));
			viagem.setDias(rset.getInt("dias"));

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
		return viagem;
	}
}
