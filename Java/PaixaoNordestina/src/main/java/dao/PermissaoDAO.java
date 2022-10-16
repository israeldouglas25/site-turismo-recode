package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Permissoes;

public class PermissaoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Permissoes permissao) {
		String sql = "INSERT INTO permissao(tipo) values(?)";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, permissao.getTipo());
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

	public List<Permissoes> getPermissoes() {
		String sql = "SELECT * FROM permissao";

		List<Permissoes> permissoes = new ArrayList<Permissoes>();
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Permissoes permissao = new Permissoes();

				permissao.setId(rset.getInt("id_permissao"));
				permissao.setTipo(rset.getString("tipo"));

				permissoes.add(permissao);
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
		return permissoes;
	}

	public void update(Permissoes permissao) {
		String sql = "UPDATE permissao set tipo = ? WHERE id_permissao = ?";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, permissao.getTipo());
			pstm.setInt(2, permissao.getId());
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
		String sql = "DELETE FROM permissao WHERE id_permissao = ?";
		
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

	public Permissoes getPermissaoById(int id) {
		String sql = "SELECT * FROM permissao WHERE id_permissao = ?";
		
		Permissoes permissoes = new Permissoes();
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			rset.next();
			
			permissoes.setId(rset.getInt("id_permissao"));
			permissoes.setTipo(rset.getString("tipo"));
			
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
		
		return permissoes;
	}
}
