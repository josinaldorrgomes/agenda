package br.com.agenda.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.model.Agenda;
import br.com.agenda.model.Contato;

public class ListarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Agenda agenda = Agenda.getInstance();
		Set<Contato> contatos = agenda.getContatos();
		request.setAttribute("contatos", contatos);
		request.getRequestDispatcher("/listar.jsp").forward(request, response);

	}
}
