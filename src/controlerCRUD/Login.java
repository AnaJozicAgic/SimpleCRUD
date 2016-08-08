package controlerCRUD;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelCrud.bo.KorisnikBo;
import modelCrud.dto.Korisnik;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Korisnik objekat = new Korisnik();
		KorisnikBo bo = new KorisnikBo();

		objekat.setUsername(username);
		objekat.setPassword(password);

		Korisnik korisnik = bo.read(objekat);

		if (korisnik == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else{

		request.getSession().setAttribute("korisnik", korisnik);
		request.getRequestDispatcher("logedin.jsp").forward(request, response);
		return;
		}

	}

}
