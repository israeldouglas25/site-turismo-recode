package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Contato;

@WebServlet(urlPatterns = { "/contatos", "/create-contato", "/edit-contato", "/update-contato", "/delet-contato" })
public class ContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ContatoDAO contatoDAO = new ContatoDAO();
	Contato contato = new Contato();

	public ContatoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/contatos":
			read(request, response);
			break;
		case "/create-contato":
			create(request, response);
			break;
		/*
		 * case "/edit-contato": edit(request, response); break; case "/update-contato":
		 * update(request, response); break;
		 */
		case "/delet-contato":
			delet(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contato> lista = contatoDAO.getContato();

		request.setAttribute("contatos", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/contato/listaMensagem.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setMensagem(request.getParameter("mensagem"));

		contatoDAO.save(contato);
		response.sendRedirect("contatos");

	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		contatoDAO.deleteById(id);
		response.sendRedirect("contatos");
	}

}
