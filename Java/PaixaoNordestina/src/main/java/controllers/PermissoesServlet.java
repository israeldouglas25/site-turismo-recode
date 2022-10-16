package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PermissaoDAO;
import model.Permissoes;

@WebServlet(urlPatterns = { "/permissoes", "/create-permissao", "/edit-permissao", "/update-permissao",
		"/delet-permissao" })
public class PermissoesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PermissaoDAO permissaoDAO = new PermissaoDAO();
	Permissoes permissoes = new Permissoes();

	public PermissoesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/permissoes":
			read(request, response);
			break;
		case "/create-permissao":
			create(request, response);
			break;
		case "/edit-permissao":
			edit(request, response);
			break;
		case "/update-permissao":
			update(request, response);
			break;
		case "/delet-permissao":
			delet(request, response);
			break;			
		default:
			response.sendRedirect("index.html");
			break;
		}}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Permissoes> lista = permissaoDAO.getPermissoes();

		request.setAttribute("permissoes", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/permissoes/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		permissoes.setTipo(request.getParameter("tipo"));
		permissaoDAO.save(permissoes);
		response.sendRedirect("permissoes");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		permissoes = permissaoDAO.getPermissaoById(id);

		request.setAttribute("id", permissoes.getId());
		request.setAttribute("tipo", permissoes.getTipo());

		RequestDispatcher rd = request.getRequestDispatcher("./views/permissoes/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		permissoes.setId(Integer.parseInt(request.getParameter("id")));
		permissoes.setTipo(request.getParameter("tipo"));

		permissaoDAO.update(permissoes);
		response.sendRedirect("permissoes");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		permissaoDAO.deleteById(id);
		response.sendRedirect("permissoes");
	}
}





/*
package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PermissaoDAO;
import model.Permissoes;

@WebServlet(urlPatterns = {"/permissoes", "/edite"})

public class PermissoesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PermissaoDAO permissaoDAO = new PermissaoDAO();
	Permissoes permissoes = new Permissoes();

	public PermissoesServlet() {
		super();
	}

	// READ
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Permissoes> lista = permissaoDAO.getPermissoes();

		request.setAttribute("permissoes", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/permissoes/index.jsp");
		rd.forward(request, response);

	}

	// CREATE
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		permissoes.setTipo(request.getParameter("tipo"));
		permissaoDAO.save(permissoes);
		response.sendRedirect("permissoes");
	}

	// UPDATE
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		permissoes.setId(Integer.parseInt(request.getParameter("id")));
		permissoes.setTipo(request.getParameter("tipo"));

		permissaoDAO.update(permissoes);
		response.sendRedirect("permissoes");
	}

	// DELETE
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		permissaoDAO.deleteById(id);
		response.sendRedirect("permissoes");
	}

	// READ BY ID
	protected void edite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		permissoes = permissaoDAO.getPermissaoById(id);

		request.setAttribute("id", permissoes.getId());
		request.setAttribute("tipo", permissoes.getTipo());

		RequestDispatcher rd = request.getRequestDispatcher("./views/permissoes/update.jsp");
		rd.forward(request, response);

	}

}
*/
