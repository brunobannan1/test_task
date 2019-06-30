package org.nick.servlet;

import org.nick.dao.FormsDaoImpl;
import org.nick.model.Forms;
import org.nick.view.TemplateUtility;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/results")
public class ResultServlet extends HttpServlet {
    FormsDaoImpl formsDao = new FormsDaoImpl();
    private Forms forms;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine te = TemplateUtility.setup();
        Context context = new Context();
        List<Forms> list = formsDao.findAll();
        context.setVariable("listForms", list);
        req.setCharacterEncoding("UTF-8");
        te.process("Results", context, resp.getWriter());
    }
}
