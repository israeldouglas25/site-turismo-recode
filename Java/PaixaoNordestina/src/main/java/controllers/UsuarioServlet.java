package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;



@WebServlet(urlPatterns = { "/usuarios", "/create-usuario", "/edit-usuario", "/update-usuario",
		"/delet-usuario" })
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	Usuario usuario = new Usuario();
	

	public UsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/usuarios":
			read(request, response);
			break;
		case "/create-usuario":
			//create(request, response);
			break;
		case "/edit-usuario":
			//edit(request, response);
			break;
		case "/update-usuario":
			//update(request, response);
			break;
		case "/delet-usuario":
			//delet(request, response);
			break;			
		default:
			response.sendRedirect("index.html");
			break;
		}}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = usuarioDAO.getUsuario();

		request.setAttribute("usuarios", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/usuarios/index.jsp");
		rd.forward(request, response);
	}
/*
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
	*/
}
