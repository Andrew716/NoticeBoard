package servlets;

import dao.DAO;
import entities.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by Andrii on 10/23/2015.
 */
@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {

    private static Logger LOGGER = Logger.getLogger("Info loging");
    private String submit;

    public void processRequest(HttpServletRequest request, HttpServletResponse response){
        Person person = new Person(request.getParameter("name"), request.getParameter("surname"), request.getParameter("login"), request.getParameter("password"));
        this.submit = request.getParameter("submit");
        LOGGER.info("fields was filled");
        if (person.getName() != null && person.getSurname() != null && person.getLogin() != null && person.getPassword() != null && submit != null){
            DAO dao = new DAO();
            dao.persist(person);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
