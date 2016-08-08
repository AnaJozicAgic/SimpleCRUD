package modelCrud.dao.CRUD;

import java.sql.SQLException;

public interface Update<T> {
	public void update(T objekat, String name) throws SQLException;

}
