package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Destino;

public class DestinoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destino destino) {
		String sql = "INSERT INTO destino(destino, preco)" + "values(?, ?)";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getDestino());
			pstm.setDouble(2, destino.getPreco());

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

	public List<Destino> getdestino() {

		String sql = "SELECT * FROM destino";

		List<Destino> listadestino = new ArrayList<Destino>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Destino destino = new Destino();

				destino.setId(rset.getInt("id_destino"));
				destino.setDestino(rset.getString("destino"));
				destino.setPreco(rset.getDouble("preco"));

				listadestino.add(destino);
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

		return listadestino;
	}

	public void update(Destino destino) {
		String sql = "UPDATE destino SET destino = ?, preco = ? WHERE id_destino = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getDestino());
			pstm.setDouble(2, destino.getPreco());
			pstm.setInt(3, destino.getId());

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
		String sql = "DELETE FROM destino WHERE id_destino = ?";

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

	public Destino getdestinoById(int id) {
		String sql = "SELECT * FROM destino WHERE id_destino = ?";

		Destino destino = new Destino();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			destino.setId(rset.getInt("id_destino"));
			destino.setDestino(rset.getString("destino"));
			destino.setPreco(rset.getDouble("preco"));

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
		return destino;
	}

}