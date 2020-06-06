package br.com.arturtcs.controller.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.arturtcs.model.entities.User;
import br.com.arturtcs.repositories.impl.UserRepositoryJDBC;
import br.com.arturtcs.repositories.interfaces.Repository;

@WebServlet(urlPatterns = { "/delete" } )
public class DeleteUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1468519669640783161L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idUser = Integer.parseInt(req.getParameter("id"));
		User userDeleted = new User();
		userDeleted.setId(idUser);
		Repository<User> repository = new UserRepositoryJDBC();
		try {
			repository.delete(userDeleted);
		} catch (SQLException e) {
			req.getSession().setAttribute("errorMessage", e.getMessage());
		}
		resp.sendRedirect(req.getContextPath() + "/list");
	}
	
	

}
