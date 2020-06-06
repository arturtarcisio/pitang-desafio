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

@WebServlet(urlPatterns = { "/edit" })
public class UpdateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idUser = Integer.parseInt(req.getParameter("id"));
		Repository<User> repository = new UserRepositoryJDBC();
		try {
			List<User> users = repository.findAll();
			var userSelected = users.stream().filter(c -> c.getId() == idUser).findFirst();
			if (userSelected.isPresent()) {
				req.setAttribute("user", userSelected.get());
			} else {
				req.getSession().setAttribute("errorMessage", "Este contato não existe.");
				resp.sendRedirect("/listar");
			}
		} catch (SQLException e) {
			req.getSession().setAttribute("errorMessage", e.getMessage());
			resp.sendRedirect("/listar");
		}
		RequestDispatcher dispatcher = req.getServletContext()
				.getRequestDispatcher("/WEB-INF/paginas/updateUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User userUpdated = new User();
				
		userUpdated.setName(req.getParameter("name"));
		userUpdated.setEmail(req.getParameter("email"));
		userUpdated.setPassword(req.getParameter("password"));
		userUpdated.setPhone1(req.getParameter("phone1"));
		userUpdated.setPhone2(req.getParameter("phone2"));
		userUpdated.setId(Integer.parseInt(req.getParameter("id")));
		
		Repository<User> repository = new UserRepositoryJDBC();
		try {
			repository.update(userUpdated);
		} catch (SQLException e) {
			req.getSession().setAttribute("errorMessage", e.getMessage());
		}
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}
