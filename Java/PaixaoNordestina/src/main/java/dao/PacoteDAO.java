package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Pacote;
import model.Usuario;

public class PacoteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Pacote pacote) {
		String sql = "insert into pacote(data_pacote, valor, id_usuario) values(?, ?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setDate(1, new Date(formatter.parse(pacote.getData()).getTime()));
			pstm.setDouble(2, pacote.getValor());
			pstm.setInt(3, pacote.getUsuario().getId());

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

	public List<Pacote> getPacote() {
		String sql = "select * from pacote";

		List<Pacote> listaPacote = new ArrayList<Pacote>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");

			while (rset.next()) {
				Pacote pacote = new Pacote();
				Usuario usuario = new Usuario();

				pacote.setId(rset.getInt("id_pacote"));
				pacote.setData(dataFormat.format(rset.getDate("data_pacote")));
				pacote.setValor(rset.getDouble("valor"));

				usuario.setId(rset.getInt("id_usuario"));
				pacote.setUsuario(usuario);

				listaPacote.add(pacote);
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

		return listaPacote;
	}

	public void update(Pacote pacote) {
		String sql = "update pacote set data_pacote = ?, valor = ?, id_usuario = ? where id_pacote = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setDate(1, new Date(formatter.parse(pacote.getData()).getTime()));
			pstm.setDouble(2, pacote.getValor());
			pstm.setInt(3, pacote.getUsuario().getId());
			pstm.setInt(4, pacote.getId());

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
		String sql = "DELETE FROM pacote WHERE id_pacote = ?";

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

	public Pacote getPacoteById(int id) {
		String sql = "SELECT * FROM pacote WHERE id_pacote = ?";

		Usuario usuario = new Usuario();
		Pacote pacote = new Pacote();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			pacote.setId(rset.getInt("id_pacote"));
			pacote.setData(dataFormat.format(rset.getDate("data_pacote")));
			pacote.setValor(rset.getDouble("valor"));

			usuario.setId(rset.getInt("id_usuario"));
			pacote.setUsuario(usuario);

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
		return pacote;
	}

}
