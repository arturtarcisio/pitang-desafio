package br.com.arturtcs.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.arturtcs.model.entities.User;
import br.com.arturtcs.repositories.impl.UserRepositoryJDBC;
import br.com.arturtcs.repositories.interfaces.Repository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Repository<User> repository = new UserRepositoryJDBC();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			if(repository.loginValidation(email, password)) {
				resp.sendRedirect(req.getContextPath() + "/list");
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/acessDenied.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
