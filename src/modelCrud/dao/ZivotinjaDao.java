package modelCrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelCrud.dto.Zivotinja;
import modelCrud.dao.CRUD.Create;
import modelCrud.dao.CRUD.Delete;
import modelCrud.dao.CRUD.Read;
import modelCrud.dao.CRUD.Update;

public class ZivotinjaDao implements Create<Zivotinja>, Read<Zivotinja>, Update<Zivotinja>, Delete<Zivotinja> {

	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public void create(Zivotinja objekat) throws SQLException {
		String query = "INSERT INTO zivotinja (vrsta, kratakOpis) VALUES(?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, objekat.getVrsta());
		statement.setString(2, objekat.getKratakOpis());
		statement.executeUpdate();

	}

	@Override
	public void delete(Zivotinja objekat) throws SQLException {
		String query = "DELETE FROM zivotinja WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, objekat.getId());
		statement.executeUpdate();
	}

	@Override
	public void update(Zivotinja objekat, String name) throws SQLException {
		String query = "UPDATE zivotinja SET (vrsta, kratatkOpis) VALUES (?,?) WHERE vrsta =?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, objekat.getVrsta());
		statement.setString(2, objekat.getKratakOpis());
		statement.setString(3, name);

		statement.executeUpdate();

	}

	@Override
	public Zivotinja read(Zivotinja objekat) throws SQLException {
		Zivotinja zivotinja = null;
		String query = "SELECT * FROM zivotinja WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, objekat.getId());

		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			zivotinja = new Zivotinja();
			zivotinja.setId(rs.getInt("id"));
			zivotinja.setVrsta(rs.getString("vrsta"));
			zivotinja.setKratakOpis("kratakOpis");

			rs.close();
		}

		return zivotinja;

	}

	public List<Zivotinja> izlistajSve() throws SQLException {
		List<Zivotinja> zivotinje = new ArrayList<>();
		Zivotinja zivotinja = null;
		String query = "SELECT * FOROM zivotinja ";
		PreparedStatement statement = connection.prepareStatement(query);

		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			zivotinja = new Zivotinja();
			zivotinja.setId(rs.getInt("id"));
			zivotinja.setVrsta(rs.getString("vrsta"));
			zivotinja.setKratakOpis("kratakOpis");

			zivotinje.add(zivotinja);
		}
		rs.close();
		return zivotinje;

	}

	public List<Zivotinja> pretraziZivotinje(String unesenoUpretragu) throws SQLException {
		List<Zivotinja> zivotinje = new ArrayList<>();
		Zivotinja zivotinja = null;
		String query = "SELECT * FROM zivotinje WHERE vrsta LIKE ?";
		PreparedStatement statment = connection.prepareStatement(query);
		statment.setString(1, "%" + unesenoUpretragu + "%");
		ResultSet rs = statment.executeQuery();

		while (rs.next()) {
			zivotinja = new Zivotinja();
			zivotinja.setId(rs.getInt("id"));
			zivotinja.setVrsta(rs.getString("vrsta"));
			zivotinja.setKratakOpis(rs.getString("kratakOpis"));

			zivotinje.add(zivotinja);
		}
		rs.close();
		return zivotinje;

	}
}
