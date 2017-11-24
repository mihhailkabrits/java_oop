import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/ServletMihhail", urlPatterns = {"/ServletMihhail"})
public class ServletMihhail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("button1") != null){

        }   FakeData fakeData = new FakeData();
    String fS = fakeData.fakeString();
//        request.setAttribute("fakeString", fS);
//        response.sendRedirect("welcome.jsp");
        request.setAttribute("fakeString", fS);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
//request.setAttr
//   String asd = "ASD";

}
