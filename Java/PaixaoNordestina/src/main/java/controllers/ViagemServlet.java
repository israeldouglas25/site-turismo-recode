package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import dao.PermissaoDAO;
import dao.UsuarioDAO;
import dao.ViagemDAO;
import model.Destino;
import model.Usuario;
import model.Viagem;

@WebServlet(urlPatterns = { "/viagens", "/create-viagem", "/edit-viagem", "/update-viagem", "/delet-viagem" })
public class ViagemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PermissaoDAO permissaoDAO = new PermissaoDAO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	DestinoDAO destinoDAO = new DestinoDAO();
	ViagemDAO viagemDAO = new ViagemDAO();
	Viagem viagem = new Viagem();

	public ViagemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/viagens":
			read(request, response);
			break;
		case "/create-viagem":
			 create(request, response);
			break;
		case "/edit-viagem":
			// edit(request, response);
			break;
		case "/update-viagem":
			// update(request, response);
			break;
		case "/delet-viagem":
			 delet(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Viagem> lista = viagemDAO.getViagem();

		request.setAttribute("viagens", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/viagem/index.jsp");
		rd.forward(request, response);
	}

	protected void pagCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Usuario> usuario = usuarioDAO.getUsuario();
		request.setAttribute("usuarios", usuario);

		List<Destino> destino = destinoDAO.getdestino();
		request.setAttribute("carros", destino);

		RequestDispatcher rd = request.getRequestDispatcher("./views/viagem/create.jsp");
		rd.forward(request, response);
	}

	//CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = usuarioDAO.getUsuarioById(Integer.parseInt(request.getParameter("usuario")));
		Destino destino = destinoDAO.getdestinoById(Integer.parseInt(request.getParameter("destino")));
		
		String dataIda = request.getParameter("dataIda");
		String dataVolta = request.getParameter("dataVolta");
		
		viagem = new Viagem(dataIda, dataVolta, destino, usuario);

		usuarioDAO.save(usuario);
		response.sendRedirect("viagens");

	}
	/*
	 * // READ BY ID protected void edit(HttpServletRequest request,
	 * HttpServletResponse response)throws ServletException,IOException { int id =
	 * Integer.parseInt(request.getParameter("id"));
	 * 
	 * usuario = usuarioDAO.getUsuarioById(id);
	 * 
	 * request.setAttribute("id", usuario.getId()); request.setAttribute("nome",
	 * usuario.getNome()); request.setAttribute("email", usuario.getEmail());
	 * request.setAttribute("senha", usuario.getSenha());
	 * request.setAttribute("tipoPermissao", usuario.getPermissoes());
	 * 
	 * RequestDispatcher rd =
	 * request.getRequestDispatcher("./views/usuarios/update.jsp");
	 * rd.forward(request, response);
	 * 
	 * }
	 * 
	 * // UPDATE protected void update(HttpServletRequest request,
	 * HttpServletResponse response)throws ServletException,IOException {
	 * 
	 * Permissoes permissao =
	 * permissaoDAO.getPermissaoById(Integer.parseInt(request.getParameter(
	 * "tipoPermissao")));
	 * 
	 * usuario.setId(Integer.parseInt(request.getParameter("id")));
	 * 
	 * usuario.setNome(request.getParameter("nome"));
	 * usuario.setEmail(request.getParameter("email"));
	 * usuario.setSenha(request.getParameter("senha"));
	 * usuario.setPermissoes(permissao);
	 * 
	 * usuarioDAO.update(usuario); response.sendRedirect("usuarios"); }
	 */

	// DELET 
	protected void delet(HttpServletRequest request, HttpServletResponse
	response)throws ServletException,IOException
	{

		int id = Integer.parseInt(request.getParameter("id"));

		usuarioDAO.deleteById(id);
		response.sendRedirect("viagens");
	}

}
