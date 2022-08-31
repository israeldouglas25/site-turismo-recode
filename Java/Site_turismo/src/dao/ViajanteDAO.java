package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
