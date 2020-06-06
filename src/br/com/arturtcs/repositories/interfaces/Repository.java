package br.com.arturtcs.repositories.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

	List<T> findAll() throws SQLException, IOException;
	void insert(T entity) throws SQLException, IOException;
	void update(T entity) throws IOException, SQLException;
	void delete(T entity) throws IOException, SQLException;
	boolean loginValidation(String email, String password) throws IOException, SQLException;

}
