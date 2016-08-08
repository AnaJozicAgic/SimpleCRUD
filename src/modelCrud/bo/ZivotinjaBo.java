package modelCrud.bo;

import java.sql.SQLException;
import java.util.List;

import modelCrud.dao.ZivotinjaDao;
import modelCrud.dao.CRUD.Create;
import modelCrud.dao.CRUD.Delete;
import modelCrud.dao.CRUD.Read;
import modelCrud.dao.CRUD.Update;
import modelCrud.dto.Zivotinja;

public class ZivotinjaBo implements Create<Zivotinja>, Read<Zivotinja>, Update<Zivotinja>, Delete<Zivotinja> {
	private ZivotinjaDao dao = new ZivotinjaDao();

	@Override
	public void delete(Zivotinja objekat) throws SQLException {
		try {
			dao.delete(objekat);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Zivotinja objekat, String name) throws SQLException {
		try {
			dao.update(objekat, name);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Zivotinja read(Zivotinja objekat){
		Zivotinja zivotinja = null;
		try {
			zivotinja = dao.read(objekat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zivotinja;
	}

	@Override
	public void create(Zivotinja objekat) throws SQLException {
		try {
			dao.create(objekat);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Zivotinja> pretraziZivotinje(String unesenoUpretragu) {
		List<Zivotinja> zivotinje = null;
		try {
			zivotinje = dao.pretraziZivotinje(unesenoUpretragu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zivotinje;
	}

	public List<Zivotinja> izlistajSve(){
		List<Zivotinja> zivotinje= null;
		
		try {
			zivotinje = dao.izlistajSve();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zivotinje;
	}

}
