package org.nick.servlet;

import org.nick.dao.FormsDaoImpl;
import org.nick.model.Forms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details")
public class ResultDetailsServlet extends HttpServlet {

    private Forms forms;
    private FormsDaoImpl formsDao = new FormsDaoImpl();
    private int formsId;
    private boolean success;
    private String dateTime;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formsIdAsString = req.getParameter("id");
        String successAsString = req.getParameter("check");
        dateTime = req.getParameter("date");
        formsId = Integer.parseInt(formsIdAsString);
        success = Boolean.parseBoolean(successAsString);

        forms = formsDao.find(formsId);



    }
}
