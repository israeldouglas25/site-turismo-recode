package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Permissoes;
import model.Usuario;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {
		String sql = "INSERT INTO usuario(nome, email, senha, tipo_permissao) " + "values(?, ?, ?, ?)";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			pstm.setInt(4, usuario.getPermissoes().getId());

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

	public List<Usuario> getUsuario() {
		String sql = "SELECT * FROM usuario";

		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();
				Permissoes permissao = new Permissoes();

				usuario.setId(rset.getInt("id_usuario"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));

				permissao.setId(rset.getInt("tipo_permissao"));

				usuario.setPermissoes(permissao);

				listaUsuario.add(usuario);
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
		return listaUsuario;
	}

	public void update(Usuario usuario) {
		String sql = "UPDATE usuario set nome = ?, email = ?, senha = ?, tipo_permissao = ? WHERE id_usuario = ?";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			pstm.setInt(4, usuario.getPermissoes().getId());
			pstm.setInt(5, usuario.getId());

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
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";

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

	public Usuario getUsuarioById(int id) {
		String sql = "SELECT * FROM usuario WHERE id_usuario = ?";

		Usuario usuario = new Usuario();
		Permissoes permissao = new Permissoes();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			usuario.setId(rset.getInt("id_usuario"));
			usuario.setNome(rset.getString("nome"));
			usuario.setEmail(rset.getString("email"));
			usuario.setSenha(rset.getString("senha"));

			permissao.setId(rset.getInt("tipo_permissao"));
			usuario.setPermissoes(permissao);

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
		return usuario;
	}
}
