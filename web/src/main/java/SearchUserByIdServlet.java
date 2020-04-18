import by.work_company.dao.UserDAO;
import by.work_company.entity.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/search")
public class SearchUserByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr =req.getParameter("id");
        int id = Integer.parseInt(idStr);
        User user = UserService.getInstance().getUser(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req,resp);
    }
}
