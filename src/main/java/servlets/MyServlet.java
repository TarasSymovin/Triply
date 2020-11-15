package servlets;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyServlet extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");

        UserManager userManager = new UserManager();
        User user = userManager.getUserById(Integer.parseInt(userId));

        String userJsonString = this.gson.toJson(user);
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        writer.write(userJsonString);
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("id");

        UserManager userManager = new UserManager();
        User user = userManager.getUserById(Integer.parseInt(userId));

        String userJsonString = this.gson.toJson(user);
        response.sendError(404);
       // PrintWriter writer = response.getWriter();
        //response.setContentType("application/json");
        //response.setCharacterEncoding("UTF-8");

       // writer.write(userJsonString);
        //writer.close();
    }
}

