package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CardDAO;
import model.Card;

@WebServlet(urlPatterns = { "/card", "/create-card", "/edit-card", "/update-card", "/delet-card" })
public class CardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Card card = new Card();
	CardDAO cardDAO = new CardDAO();

	public CardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/card":
			read(request, response);
			break;
		case "/create-card":
			create(request, response);
			break;
		case "/edit-card":
			edit(request, response);
			break;
		case "/update-card":
			update(request, response);
			break;
		case "/delet-card":
			delet(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Card> lista = cardDAO.getCard();

		request.setAttribute("card", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/promocoes/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		card.setNome(request.getParameter("nome"));
		card.setNome(request.getParameter("precoPromocao"));
		cardDAO.save(card);
		response.sendRedirect("card");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		card = cardDAO.getCardById(id);

		request.setAttribute("id", card.getId());
		request.setAttribute("nome", card.getNome());
		request.setAttribute("precoPromocao", card.getPrecoPromocao());

		RequestDispatcher rd = request.getRequestDispatcher("./views/card/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		card.setId(Integer.parseInt(request.getParameter("id")));
		card.setNome(request.getParameter("nome"));

		cardDAO.update(card);
		response.sendRedirect("card");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		cardDAO.getCardById(id);
		response.sendRedirect("card");
	}

}
