package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.ItensPacote;
import model.Pacote;
import model.Destino;

public class ItensPacoteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(ItensPacote itensPacote) {
		String sql = "INSERT INTO item_pacote(qtd_viajantes, valor, id_pacote, id_viagem) values(?, ?, ?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, itensPacote.getQtdViajantes());
			pstm.setDouble(2, itensPacote.getValor());
			pstm.setInt(3, itensPacote.getPacote().getId());
			pstm.setInt(4, itensPacote.getViagem().getId());

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

	public List<ItensPacote> getItensPacote() {
		String sql = "SELECT * FROM item_pacote";

		List<ItensPacote> listaItens = new ArrayList<>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				ItensPacote item = new ItensPacote();
				Pacote pacote = new Pacote();
				Destino viagem = new Destino();

				item.setId(rset.getInt("id_item"));
				item.setQtdViajantes(rset.getInt("qtd_viajantes"));
				item.setValor(rset.getDouble("valor"));

				pacote.setId(rset.getInt("id_pacote"));
				item.setPacote(pacote);

				viagem.setId(rset.getInt("id_viagem"));
				item.setViagem(viagem);

				listaItens.add(item);
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

		return listaItens;
	}

	public void update(ItensPacote itensPacote) {
		String sql = "update item_pacote set qtd_viajantes = ?, valor = ?, id_pacote = ?, id_viagem = ? where id_item = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, itensPacote.getQtdViajantes());
			pstm.setDouble(2, itensPacote.getValor());
			pstm.setInt(3, itensPacote.getPacote().getId());
			pstm.setInt(4, itensPacote.getViagem().getId());
			pstm.setInt(5, itensPacote.getId());

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
		String sql = "DELETE FROM item_pacote WHERE id_item = ?";

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

	public ItensPacote getItemById(int id) {
		String sql = "SELECT * FROM item_pacote WHERE id_item = ?";

		ItensPacote item = new ItensPacote();
		Destino viagem = new Destino();
		Pacote pacote = new Pacote();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			item.setId(rset.getInt("id_item"));
			item.setQtdViajantes(rset.getInt("qtd_viajantes"));
			item.setValor(rset.getDouble("valor"));

			pacote.setId(rset.getInt("id_pacote"));
			item.setPacote(pacote);

			viagem.setId(rset.getInt("id_viagem"));
			item.setViagem(viagem);

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
		return item;
	}

}
