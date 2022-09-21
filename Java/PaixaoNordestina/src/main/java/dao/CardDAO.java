package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Card;

public class CardDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Card card) {
		String sql = "INSERT INTO card(nome, precoPromocao) VALUES (?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, card.getNome());
			pstm.setDouble(2, card.getPrecoPromocao());

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

	public List<Card> getCard() {
		String sql = "SELECT * FROM card";

		List<Card> listaCard = new ArrayList<Card>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Card card = new Card();

				card.setId(rset.getInt("id_card"));
				card.setNome(rset.getString("nome"));
				card.setPrecoPromocao(rset.getDouble("precoPromocao"));

				listaCard.add(card);
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

		return listaCard;
	}

	public void update(Card card) {
		String sql = "UPDATE card set nome = ?, precoPromocao = ? WHERE id_card = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, card.getNome());
			pstm.setDouble(2, card.getPrecoPromocao());
			pstm.setInt(3, card.getId());

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
		String sql = "DELETE FROM card WHERE id_card = ?";

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

	public Card getCardById(int id) {
		String sql = "SELECT * FROM card WHERE id_card = ?";

		Card card = new Card();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			rset.next();
			
			card.setId(rset.getInt("id_card"));
			card.setNome(rset.getString("nome"));
			card.setPrecoPromocao(rset.getDouble("precoPromocao"));

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

		return card;
	}

}
