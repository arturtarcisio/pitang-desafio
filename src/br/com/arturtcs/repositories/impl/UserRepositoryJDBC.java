package br.com.arturtcs.repositories.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.arturtcs.factory.FactoryConnectionJdbc;
import br.com.arturtcs.model.entities.User;
import br.com.arturtcs.repositories.interfaces.Repository;

public class UserRepositoryJDBC implements Repository<User> {

	@Override
	public List<User> findAll() throws SQLException, IOException {
		List<User> users = new ArrayList<User>();
		
		try (Connection conn = (Connection) FactoryConnectionJdbc.createConnection()) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT id, name, email, password, phone1, phone2 FROM user");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone1(rs.getString("phone1"));
				user.setPhone2(rs.getString("phone2"));
				
				users.add(user);
			}
		}
		return users;
	}

	@Override
	public void insert(User user) throws IOException, SQLException {
		Connection conn = null;
		try {
			conn = (Connection) FactoryConnectionJdbc.createConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO user (name, email, password, phone1, phone2) " + 
															     " VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone1());
			ps.setString(5, user.getPhone2());			
			
			ps.execute();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	@Override
	public void update(User user)  throws IOException, SQLException {
		try (Connection conn = (Connection) FactoryConnectionJdbc.createConnection()){
			PreparedStatement ps = conn.prepareStatement("UPDATE user SET name = ?, email = ?, password = ?, "
					+ "phone1 = ?, phone2 = ? WHERE id = ?");
			
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone1());
			ps.setString(5, user.getPhone2());	
			ps.setInt(6, user.getId());
			
			ps.execute();
		}

	}

	@Override
	public void delete(User user)  throws IOException, SQLException {
		try (Connection conn = (Connection) FactoryConnectionJdbc.createConnection()){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM user WHERE id = ?");
			ps.setInt(1, user.getId());
			ps.execute();
		}

	}
	
	@Override
	public boolean loginValidation(String email, String password) throws IOException, SQLException {
		Connection conn = null;		
		try {
			conn = (Connection) FactoryConnectionJdbc.createConnection();
			PreparedStatement st = conn.prepareStatement(
					"SELECT * FROM user WHERE email = '"+email+"' and password = '"+password+"'");
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}finally {
			if (conn != null) {
				conn.close();
			}
		}	
	}
	


}