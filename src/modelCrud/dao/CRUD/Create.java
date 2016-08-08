package modelCrud.dao.CRUD;

import java.sql.SQLException;

public interface Create<T> {

	public void create (T objekat) throws SQLException;
}
