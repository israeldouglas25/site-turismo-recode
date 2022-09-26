package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ViajanteDAO;
import model.Viajante;

@WebServlet(urlPatterns = { "/viajantes", "/create-viajante", "/edit-viajante", "/update-viajante", "/delet-viajante" })
public class ViajanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ViajanteDAO viajanteDAO = new ViajanteDAO();
	Viajante viajante = new Viajante();

	public ViajanteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/viajantes":
			read(request, response);
			break;
		case "/create-viajante":
			create(request, response);
			break;
		case "/edit-viajante":
			edit(request, response);
			break;
		case "/update-viajante":
			update(request, response);
			break;
		case "/delet-viajante":
			delet(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Viajante> lista = viajanteDAO.getViajante();

		request.setAttribute("viajantes", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/viajante/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		viajante.setNome(request.getParameter("nome"));
		viajante.setEmail(request.getParameter("email"));
		viajante.setIdade(Integer.parseInt(request.getParameter("idade")));
		viajante.setEstado(request.getParameter("estado"));
		viajante.setCpf(request.getParameter("cpf"));
		viajante.setTelefone(request.getParameter("telefone"));

		viajanteDAO.save(viajante);
		response.sendRedirect("viajantes");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		viajante = viajanteDAO.getViajanteById(id);

		request.setAttribute("id", viajante.getId());
		request.setAttribute("nome", viajante.getNome());
		request.setAttribute("email", viajante.getEmail());
		request.setAttribute("idade", viajante.getIdade());
		request.setAttribute("estado", viajante.getEstado());
		request.setAttribute("cpf", viajante.getCpf());
		request.setAttribute("telefone", viajante.getTelefone());

		RequestDispatcher rd = request.getRequestDispatcher("./views/viajante/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		viajante.setId(Integer.parseInt(request.getParameter("id")));
		viajante.setNome(request.getParameter("nome"));
		viajante.setEmail(request.getParameter("email"));
		viajante.setIdade(Integer.parseInt(request.getParameter("idade")));
		viajante.setEstado(request.getParameter("estado"));
		viajante.setCpf(request.getParameter("cpf"));
		viajante.setTelefone(request.getParameter("telefone"));

		viajanteDAO.update(viajante);
		response.sendRedirect("viajantes");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		viajanteDAO.deleteById(id);
		response.sendRedirect("viajantes");
	}

}
