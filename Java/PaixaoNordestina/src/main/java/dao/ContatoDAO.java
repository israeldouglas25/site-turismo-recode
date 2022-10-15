package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Contato;

public class ContatoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Contato contato) {
		String sql = "INSERT INTO contato(nome, email, telefone, mensagem) values(?,?,?,?)";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getTelefone());
			pstm.setString(4, contato.getMensagem());
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

	public List<Contato> getContato() {
		String sql = "SELECT * FROM contato";

		List<Contato> contatos = new ArrayList<Contato>();
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Contato contato = new Contato();

				contato.setId(rset.getInt("id_contato"));
				contato.setNome(rset.getString("nome"));
				contato.setEmail(rset.getString("email"));
				contato.setTelefone(rset.getString("telefone"));
				contato.setMensagem(rset.getString("mensagem"));

				contatos.add(contato);
			}

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
		return contatos;
	}

	public void update(Contato contato) {
		String sql = "UPDATE contato set nome = ?, email = ?, telefone = ?, mensagem = ? WHERE id_contato = ?";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getTelefone());
			pstm.setString(4, contato.getMensagem());
			pstm.setInt(5, contato.getId());
			
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
		String sql = "DELETE FROM contato WHERE id_contato = ?";
		
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

	public Contato getContatoById(int id) {
		String sql = "SELECT * FROM contato WHERE id_contato = ?";
		
		Contato contato = new Contato();
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			rset.next();
			
			contato.setId(rset.getInt("id_contato"));
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setTelefone(rset.getString("telefone"));
			contato.setMensagem(rset.getString("mensagem"));
			
		}catch (Exception e) {
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
		
		return contato;
	}
}
