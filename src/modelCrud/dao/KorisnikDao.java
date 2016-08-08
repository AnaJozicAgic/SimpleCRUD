package modelCrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelCrud.dao.CRUD.Create;
import modelCrud.dao.CRUD.Delete;
import modelCrud.dao.CRUD.Read;
import modelCrud.dao.CRUD.Update;
import modelCrud.dto.Korisnik;

public class KorisnikDao implements Create<Korisnik>, Read<Korisnik>, Update<Korisnik>, Delete<Korisnik> {
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public void delete(Korisnik objekat) throws SQLException {
		String query = "DELETE FROM korisnik WHERE username = ? ";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, objekat.getUsername());
		statement.executeUpdate();
	}

	@Override
	public void update(Korisnik objekat, String name) throws SQLException {
		String query = "UPDATE korisnik SET username=? , password=? WHERE username= ?";

		PreparedStatement statement = connection.prepareStatement(query);

		statement.setString(1, objekat.getUsername());
		statement.setString(2, objekat.getPassword());
		statement.setString(3, name);

		statement.executeUpdate();
	}

	@Override
	public Korisnik read(Korisnik objekat) throws SQLException {
		Korisnik korisnik = null;
		String query = "SELECT * FROM korisnik WHERE username=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, objekat.getUsername());

		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			korisnik = new Korisnik();
			korisnik.setId(rs.getInt("id"));
			korisnik.setUsername(rs.getString("username"));
			korisnik.setPassword("password");

			rs.close();
		}
		return korisnik;

	}

	@Override
	public void create(Korisnik objekat) throws SQLException {
		String query = "INSERT INTO korisnik (username, password) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(query);

		statement.setString(1, objekat.getUsername());
		statement.setString(2, objekat.getPassword());
		
		statement.executeUpdate();
		

	}


}
