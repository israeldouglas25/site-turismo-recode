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
import model.Destino;

@WebServlet(urlPatterns = { "/destino", "/create-destino", "/edit-destino", "/update-destino", "/delet-destino" })
public class DestinoServilet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DestinoDAO destinoDAO = new DestinoDAO();
	Destino destino = new Destino();

	public DestinoServilet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/destino":
			read(request, response);
			break;
		case "/create-destino":
			create(request, response);
			break;
		case "/edit-destino":
			edit(request, response);
			break;
		case "/update-destino":
			update(request, response);
			break;
		case "/delet-destino":
			delet(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Destino> lista = destinoDAO.getdestino();

		request.setAttribute("destino", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		destino.setDestino(request.getParameter("destino"));	
		destino.setPreco(Double.parseDouble( request.getParameter("preco")));

		destinoDAO.save(destino);
		response.sendRedirect("destino");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		destino = destinoDAO.getdestinoById(id);

		request.setAttribute("id", destino.getId());		
		request.setAttribute("destino", destino.getDestino());	
		request.setAttribute("preco", destino.getPreco());

		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		destino.setId(Integer.parseInt(request.getParameter("id")));	
		destino.setDestino(request.getParameter("destino"));		
		destino.setPreco(Double.parseDouble(request.getParameter("preco")));

		destinoDAO.update(destino);
		response.sendRedirect("destino");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		destinoDAO.deleteById(id);
		response.sendRedirect("destino");
	}

}
