package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Viajante;

public class ViajanteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Viajante viajante) {
		String sql = "INSERT INTO viajante (nome, email, idade, logradouro, bairro, cidade, estado, telefone) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viajante.getNome());
			pstm.setString(2, viajante.getEmail());
			pstm.setInt(3, viajante.getIdade());
			pstm.setString(4, viajante.getLogradouro());
			pstm.setString(5, viajante.getBairro());
			pstm.setString(6, viajante.getCidade());
			pstm.setString(7, viajante.getEstado());
			pstm.setString(8, viajante.getTelefone());

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

	public List<Viajante> getViajante() {

		String sql = "SELECT * FROM viajante";

		List<Viajante> listaViajante = new ArrayList<Viajante>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Viajante viajante = new Viajante();

				viajante.setId(rset.getInt("id_viajante"));
				viajante.setNome(rset.getString("nome"));
				viajante.setEmail(rset.getString("email"));
				viajante.setIdade(rset.getInt("idade"));
				viajante.setLogradouro(rset.getString("logradouro"));
				viajante.setBairro(rset.getString("bairro"));
				viajante.setCidade(rset.getString("cidade"));
				viajante.setEstado(rset.getString("estado"));
				viajante.setTelefone(rset.getString("telefone"));

				listaViajante.add(viajante);
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

		return listaViajante;
	}

	public void update(Viajante viajante) {

		String sql = "UPDATE viajante SET nome = ?, email = ?, idade = ?, logradouro = ?, bairro = ?, cidade = ?, estado = ?, telefone = ? WHERE id_viajante = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viajante.getNome());
			pstm.setString(2, viajante.getEmail());
			pstm.setInt(3, viajante.getIdade());
			pstm.setString(4, viajante.getLogradouro());
			pstm.setString(5, viajante.getBairro());
			pstm.setString(6, viajante.getCidade());
			pstm.setString(7, viajante.getEstado());
			pstm.setString(8, viajante.getTelefone());
			pstm.setInt(9, viajante.getId());

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
		String sql = "DELETE FROM viajante WHERE id_viajante = ?";
		
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

	public Viajante getViajanteById(int id) {

		String sql = "SELECT * FROM viajante WHERE id_viajante = ?";

		Viajante viajante = new Viajante();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			viajante.setId(rset.getInt("id_viajante"));
			viajante.setNome(rset.getString("nome"));

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
		return viajante;
	}
}
