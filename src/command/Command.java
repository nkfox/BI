package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface for all commands
 */
public interface Command {

    String START_PAGE = "/jsp/index.jsp";
    String EVENTS = "/jsp/events.jsp";
    String MEMBERS = "/jsp/members.jsp";
    String NEWS = "/jsp/news.jsp";
    String PROJECTS = "/jsp/projects.jsp";

    String execute(HttpServletRequest request, HttpServletResponse response);
}
