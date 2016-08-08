package modelCrud.bo;

import java.sql.SQLException;

import javax.servlet.jsp.el.ELException;

import modelCrud.dao.KorisnikDao;
import modelCrud.dao.CRUD.Create;
import modelCrud.dao.CRUD.Delete;
import modelCrud.dao.CRUD.Read;
import modelCrud.dao.CRUD.Update;
import modelCrud.dto.Korisnik;

public class KorisnikBo implements Create<Korisnik>, Read<Korisnik>, Update<Korisnik>, Delete<Korisnik> {
	private KorisnikDao dao = new KorisnikDao();

	@Override
	public void create(Korisnik objekat) throws SQLException {

		try {

			dao.create(objekat);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Korisnik objekat) throws SQLException {

		try {
			dao.create(objekat);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Korisnik objekat, String name) throws SQLException {
		try {
			dao.update(objekat, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Korisnik read(Korisnik objekat) {
		Korisnik korisnik = null;
		try {
			korisnik = dao.read(objekat);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return korisnik;
	}

}
