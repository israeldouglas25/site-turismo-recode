package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Destino;
import model.Permissoes;
import model.Usuario;
import model.Viagem;

public class ViagemDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Viagem viagem) {
		String sql = "INSERT INTO viagem(dataIda, dataVolta, total, dias, id_usuario, id_destino)"
				+ "values(?, ?, ?, ?, ?, ?)";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viagem.getDataIda());
			pstm.setString(2, viagem.getDataVolta());
			pstm.setDouble(3, viagem.getTotal());
			pstm.setLong(4, viagem.getDias());
			pstm.setInt(5, viagem.getUsuario().getId());
			pstm.setInt(6, viagem.getDestino().getId());

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

			while (rset.next()) {
				Viagem viagem = new Viagem();
				Usuario usuario = new Usuario();
				Destino destino = new Destino();
				Permissoes permissao = new Permissoes();

				viagem.setId(rset.getInt("id_viagem"));
				viagem.setDataIda(rset.getString("dataIda"));
				viagem.setDataVolta(rset.getString("dataVolta"));
				viagem.setTotal(rset.getDouble("total"));
				viagem.setDias(rset.getLong("dias"));
				
				usuario.setId(rset.getInt("id_usuario"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				
				permissao.setId(rset.getInt("id_permissao"));
				permissao.setTipo(rset.getString("tipo"));
				usuario.setPermissoes(permissao);
				
				viagem.setUsuario(usuario);
				
				destino.setId(rset.getInt("id_destino"));
				destino.setDestino(rset.getString("destino"));
				destino.setPreco(rset.getDouble("preco"));
				
				viagem.setDestino(destino);
			

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
		String sql = "UPDATE viagem SET dataIda = ?, dataVolta = ?, total = ?, dias = ?, id_usuario, id_senha = ? WHERE id_viagem = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viagem.getDataIda());
			pstm.setString(2, viagem.getDataVolta());
			pstm.setDouble(3, viagem.getTotal());
			pstm.setLong(4, viagem.getDias());
			pstm.setInt(5, viagem.getUsuario().getId());
			pstm.setInt(6, viagem.getDestino().getId());
			pstm.setInt(7, viagem.getId());

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
		Usuario usuario = new Usuario();
		Destino destino = new Destino();
		Permissoes permissao = new Permissoes();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			viagem.setId(rset.getInt("id_viagem"));
			viagem.setDataIda(rset.getString("dataIda"));
			viagem.setDataVolta(rset.getString("dataVolta"));
			viagem.setTotal(rset.getDouble("total"));
			viagem.setDias(rset.getLong("dias"));
			
			usuario.setId(rset.getInt("id_usuario"));
			usuario.setNome(rset.getString("nome"));
			usuario.setEmail(rset.getString("email"));
			usuario.setSenha(rset.getString("senha"));
			
			permissao.setId(rset.getInt("id_permissao"));
			permissao.setTipo(rset.getString("tipo"));
			usuario.setPermissoes(permissao);
			
			viagem.setUsuario(usuario);
			
			destino.setId(rset.getInt("id_destino"));
			destino.setDestino(rset.getString("destino"));
			destino.setPreco(rset.getDouble("preco"));
			
			viagem.setDestino(destino);

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