package controller;

import command.Command;
import command.CommandFactory;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Main controller
 */
public class Controller extends HttpServlet {

    private static final Logger logger = Logger.getLogger(Controller.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            Command handler = CommandFactory.getInstance().getCommand(request);
            String path = handler.execute(request, response);
            request.getSession(true).setAttribute("path", path);
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (Exception ex) {
            String path = "/html/index.jsp";
            request.getSession(true).setAttribute("path", path);
            RequestDispatcher rd = request.getRequestDispatcher(path);
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                logger.error("ServletException", ex);
            } catch (IOException e) {
                logger.error("IOException", ex);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }
}
