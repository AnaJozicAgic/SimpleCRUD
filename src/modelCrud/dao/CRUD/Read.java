package modelCrud.dao.CRUD;

import java.sql.SQLException;

public interface Read<T> {

	public T read(T objekat) throws SQLException;
}
