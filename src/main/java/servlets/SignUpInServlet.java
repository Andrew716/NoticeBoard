package servlets;

import dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

/**
 * Created by Andrii on 10/23/2015.
 */
@WebServlet(name = "SignUpInServlet")
public class SignUpInServlet extends javax.servlet.http.HttpServlet {

    private static Logger LOGGER = Logger.getLogger("Info loging");
    private String login;
    private String password;
    private String submit;
    private Connection connection;

    public void processRequest(HttpServletRequest request, HttpServletResponse response){
        this.login = request.getParameter("login");
        this.password = request.getParameter("password");
        this.submit = request.getParameter("submit");
        if (login != null && password != null && submit != null){
            this.connection = DAO.getConnection();
            LOGGER.info("Servlet was started");
        }
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }
}
