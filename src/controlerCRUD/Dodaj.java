package controlerCRUD;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelCrud.bo.ZivotinjaBo;
import modelCrud.dto.Zivotinja;

/**
 * Servlet implementation class Dodaj
 */
@WebServlet("/dodaj")
public class Dodaj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dodaj() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Zivotinja objekat = new Zivotinja();
		objekat.setVrsta(request.getParameter("vrsta"));
		objekat.setKratakOpis(request.getParameter("kratakOpis"));

		ZivotinjaBo bo = new ZivotinjaBo();
		if (bo.read(objekat) != null) {
			request.setAttribute("message", "Zivotinja sa ovim podacima vec postoji.");
			request.getRequestDispatcher("logedin.jsp").forward(request, response);
			return;
		}

		try {
			bo.create(objekat);

			request.setAttribute("message", "Hvala sto ste obogatili nas katalog!");
			request.getRequestDispatcher("logedin.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
