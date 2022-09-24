package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ViagemDAO;
import model.Viagem;

@WebServlet(urlPatterns = { "/destino", "/create-destino", "/edit-destino", "/update-destino", "/delet-destino" })
public class ViagemServilet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ViagemDAO viagemDAO = new ViagemDAO();
	Viagem viagem = new Viagem();

	public ViagemServilet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/destino":
			read(request, response);
			break;
		case "/create-destino":
			create(request, response);
			break;
			/*case "/edit-viajante":
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
		*/}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Viagem> lista = viagemDAO.getViagem();

		request.setAttribute("destino", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/index.jsp");
		rd.forward(request, response);
	}
	
	// CREATE
		protected void create(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			viagem.setOrigem(request.getParameter("origem"));
			viagem.setDestino(request.getParameter("destino"));
			viagem.setDataIda(request.getParameter("dataIda"));
			viagem.setDataVolta(request.getParameter("dataVolta"));
			viagem.setQtdViajantes(Integer.parseInt(request.getParameter("qtdViajantes")));
			viagem.setQtdQuartos(Integer.parseInt(request.getParameter("qtdQuartos")));
			viagem.setPreco(Double.parseDouble(request.getParameter("preco")));
			viagem.setTotal(Double.parseDouble(request.getParameter("total")));
			viagem.setDias(Integer.parseInt(request.getParameter("dias")));

			viagemDAO.save(viagem);
			response.sendRedirect("viagem");

		}

}
