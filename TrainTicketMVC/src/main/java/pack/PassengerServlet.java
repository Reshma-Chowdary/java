package pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

@WebServlet("/PassengerServlet")
public class PassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gen = request.getParameter("gen");
		PassengerDal pd=new PassengerDal();
		pd.add(no, name, age, gen);
	}
}