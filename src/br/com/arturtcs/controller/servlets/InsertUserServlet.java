package br.com.arturtcs.controller.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.arturtcs.model.entities.User;
import br.com.arturtcs.repositories.impl.UserRepositoryJDBC;
import br.com.arturtcs.repositories.interfaces.Repository;

@WebServlet(urlPatterns = {"/insert"})
public class InsertUserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/userInsert.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Repository<User> repository = new UserRepositoryJDBC();
		
		User newUser = new User();
		newUser.setName(req.getParameter("name"));
		newUser.setEmail(req.getParameter("email"));
		newUser.setPassword(req.getParameter("password"));
		newUser.setPhone1(req.getParameter("phone1"));
		newUser.setPhone2(req.getParameter("phone2"));
		
		try {
			repository.insert(newUser);;
		} catch (SQLException e) {
			req.getSession().setAttribute("errorMessage", e.getMessage());
		}
		resp.sendRedirect(req.getContextPath() + "/list");
	}
	
	
	
}
