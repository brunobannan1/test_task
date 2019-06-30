package org.nick.servlet;

import org.nick.dao.FormsDaoImpl;
import org.nick.dao.FormsDataAsList;
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
        formsDao.fillForms(forms);

        FormsDataAsList formsDataAsList = new FormsDataAsList();
        formsDataAsList.retrieve(forms);

        TemplateEngine te = TemplateUtility.setup();
        Context context = new Context();
        context.setVariable("dataList", formsDataAsList.getDataList());
        context.setVariable("rateList", formsDataAsList.getRateList());
        context.setVariable("formList", formsDataAsList.getFormList());
        context.setVariable("id", forms.getId());
        context.setVariable("success", forms.getSuccess());
        context.setVariable("dateUpload", forms.getUploadDate());
        req.setCharacterEncoding("UTF-8");
        te.process("ResultDetails", context, resp.getWriter());
    }
}
