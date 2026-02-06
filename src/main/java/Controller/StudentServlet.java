package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Model.Student;
import Model.StudentDAO;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;

	public void init() throws ServletException {
		studentDAO = new StudentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			listStudents(request, response);
		} else {
			switch (action) {
				case "new":
					showNewForm(request, response);
					break;
				case "show":
					showStudent(request, response);
					break;
				case "edit":
					showEditForm(request, response);
					break;
				case "delete":
					deleteStudent(request, response);
					break;
				default:
					listStudents(request, response);
					break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			listStudents(request, response);
		} else {
			switch (action) {
				case "insert":
					insertStudent(request, response);
					break;
				case "update":
					updateStudent(request, response);
					break;
				default:
					listStudents(request, response);
					break;
			}
		}
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> students = studentDAO.findAll();
		request.setAttribute("students", students);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("create.jsp").forward(request, response);
	}

	private void showStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentDAO.findById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String from = request.getParameter("from");
		Student student = studentDAO.findById(id);
		request.setAttribute("student", student);
		request.setAttribute("from", from);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String fullName = request.getParameter("fullName");
		String cne = request.getParameter("cne");
		String adresse = request.getParameter("adresse");

		Student student = new Student(fullName, cne, adresse);
		studentDAO.save(student);
		response.sendRedirect("students");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fullName = request.getParameter("fullName");
		String cne = request.getParameter("cne");
		String adresse = request.getParameter("adresse");
		String from = request.getParameter("from");

		Student student = new Student(id, fullName, cne, adresse);
		studentDAO.update(student);

		if ("show".equals(from)) {
			response.sendRedirect("students?action=show&id=" + id);
		} else {
			response.sendRedirect("students");
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDAO.delete(id);
		response.sendRedirect("students");
	}
}
