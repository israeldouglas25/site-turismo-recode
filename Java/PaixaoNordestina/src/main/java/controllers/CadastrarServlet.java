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

@WebServlet(urlPatterns = { "/cadastro", "/create-cadastro", "/edit-cadastro", "/update-cadastro",
		"/delet-cadastro" })
public class CadastrarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UsuarioDAO  usuarioDAO = new UsuarioDAO();
	Usuario usuario = new Usuario();

	public CadastrarServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/cadastro":
			read(request, response);
			break;
		case "/create-cadastro":
			create(request, response);
			break;
		case "/edit-cadastro":
			edit(request, response);
			break;
		case "/update-cadastro":
			update(request, response);
			break;
		case "/delet-cadastro":
			delet(request, response);
			break;			
		default:
			response.sendRedirect("index.html");
			break;
		}}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listaUsuarios = usuarioDAO.getUsuario();

		request.setAttribute("cadastro", listaUsuarios);

		RequestDispatcher rd = request.getRequestDispatcher("./views/cadastrar/cadastros.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuarioDAO.save(usuario);
		response.sendRedirect("cadastro");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		usuario = usuarioDAO.getUsuarioById(id);

		request.setAttribute("id", usuario.getId());
		request.setAttribute("tipo", usuario.getNome());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("senha", usuario.getSenha());

		RequestDispatcher rd = request.getRequestDispatcher("./views/cadastrar/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));

		usuarioDAO.update(usuario);
		response.sendRedirect("cadastro");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		usuarioDAO.deleteById(id);
		response.sendRedirect("cadastro");
	}
}
