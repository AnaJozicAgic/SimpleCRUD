package controlerCRUD;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelCrud.bo.ZivotinjaBo;
import modelCrud.dto.Korisnik;
import modelCrud.dto.Zivotinja;

/**
 * Servlet implementation class ListaSvih
 */
@WebServlet("/listasvih")
public class ListaSvih extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaSvih() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Korisnik korisnik = (Korisnik) request.getSession(false).getAttribute("korisnik");

		ZivotinjaBo bo = new ZivotinjaBo();

		List<Zivotinja> zivotinje = bo.izlistajSve();

		request.setAttribute("zivotinje", zivotinje);
		request.getSession().setAttribute("korisnik", korisnik);
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}


}
