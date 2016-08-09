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
 * Servlet implementation class Obrisi
 */
@WebServlet("/obrisi")
public class Obrisi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Obrisi() {
		super();

	}

	ZivotinjaBo bo = new ZivotinjaBo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		Zivotinja objekat = new Zivotinja();
		objekat.setId(id);
		Zivotinja zivotinja = bo.read(objekat);
		
		bo.delete(zivotinja);
		request.getRequestDispatcher("logedin.jsp").forward(request, response);

	}

}
