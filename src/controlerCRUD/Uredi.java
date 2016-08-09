package controlerCRUD;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelCrud.bo.ZivotinjaBo;
import modelCrud.dto.Zivotinja;

/**
 * Servlet implementation class Uredi
 */
@WebServlet("/uredi")
public class Uredi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Uredi() {
		super();

	}

	ZivotinjaBo bo = new ZivotinjaBo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Zivotinja objekat = new Zivotinja();
		objekat.setId(id);
		Zivotinja zivotinja = bo.read(objekat);
		System.out.println(zivotinja.toString());

		request.setAttribute("zivotinja", zivotinja);

		request.getRequestDispatcher("uredi.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// Ovdje sam pravo zapetljala
		int id = Integer.parseInt(request.getParameter("id"));
		String vrsta = request.getParameter("vrsta");
		String kratakOpis = request.getParameter("kratakOpis");

		Zivotinja zivotinja = new Zivotinja();
		zivotinja.setId(id);

		Zivotinja name = bo.read(zivotinja);

		Zivotinja objekat = new Zivotinja();
		objekat.setVrsta(vrsta);
		objekat.setKratakOpis(kratakOpis);

		bo.update(objekat, name.getVrsta());

		request.getRequestDispatcher("logedin.jsp").forward(request, response);
	

	}

}
