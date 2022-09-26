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
import dao.UsuarioDAO;
import model.Permissoes;
import model.Usuario;



@WebServlet(urlPatterns = { "/usuarios", "/create-usuario", "/edit-usuario", "/update-usuario",
		"/delet-usuario" })
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PermissaoDAO permissaoDAO = new PermissaoDAO();
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
			create(request, response);
			break;
		case "/edit-usuario":
			edit(request, response);
			break;
		case "/update-usuario":
			update(request, response);
			break;
		case "/delet-usuario":
			delet(request, response);
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

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Permissoes permissao = permissaoDAO.getPermissaoById(Integer.parseInt(request.getParameter("tipoPermissao")));

		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setPermissoes(permissao);
		
		usuarioDAO.save(usuario);
		response.sendRedirect("usuarios");

	}

	// READ BY ID
		protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		usuario = usuarioDAO.getUsuarioById(id);

		request.setAttribute("id", usuario.getId());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("senha", usuario.getSenha());
		request.setAttribute("tipoPermissao", usuario.getPermissoes());

		RequestDispatcher rd = request.getRequestDispatcher("./views/usuarios/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Permissoes permissao = permissaoDAO.getPermissaoById(Integer.parseInt(request.getParameter("tipoPermissao")));
		
		usuario.setId(Integer.parseInt(request.getParameter("id")));

		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setPermissoes(permissao);

		usuarioDAO.update(usuario);
		response.sendRedirect("usuarios");
	}
		

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		usuarioDAO.deleteById(id);
		response.sendRedirect("usuarios");
	}

}
