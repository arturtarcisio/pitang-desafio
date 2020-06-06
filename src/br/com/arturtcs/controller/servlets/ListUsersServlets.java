package br.com.arturtcs.controller.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.arturtcs.model.entities.User;
import br.com.arturtcs.repositories.impl.UserRepositoryJDBC;
import br.com.arturtcs.repositories.interfaces.Repository;

@WebServlet(urlPatterns = {"/list"})
public final class ListUsersServlets extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Repository<User> repository= new UserRepositoryJDBC();
		try {
			List<User> users = repository.findAll();
			req.setAttribute("usersList", users);
		} catch (SQLException e) {
			req.setAttribute("errorMessage", e.getMessage());
		}
		Object errorMessage = req.getSession().getAttribute("errorMessage");
		if(errorMessage != null) {
			req.setAttribute("errorMessage", errorMessage.toString());
		}
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/usersList.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
