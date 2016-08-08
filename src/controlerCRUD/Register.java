package controlerCRUD;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelCrud.bo.KorisnikBo;
import modelCrud.dto.Korisnik;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KorisnikBo bo = new KorisnikBo();
		Korisnik objekat = new Korisnik();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		objekat.setUsername(username);
		objekat.setPassword(password);
		
		if(bo.read(objekat)!=null){
			request.setAttribute("message", "Korisnik sa ovim podacima vec postoji.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

	try {
		bo.create(objekat);
		
		request.setAttribute("message", "Cestitamo na prijavi!");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}

}
