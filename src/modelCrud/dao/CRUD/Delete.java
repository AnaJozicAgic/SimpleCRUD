package modelCrud.dao.CRUD;

import java.sql.SQLException;

public interface Delete<T> {
	public void delete(T objekat)throws SQLException;

}
