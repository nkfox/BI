package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface for all commands.
 * Created by Nataliia Kozoriz on 08/11/2016.
 */
public interface Command {

    String START_PAGE = "/jsp/index.jsp";

    String UNIVERSITIES = "/jsp/universities.jsp";
    String UNIVERSITY = "/jsp/university.jsp";
    String STUDENTS = "/jsp/students.jsp";
    String STUDENT = "/jsp/teacher.jsp";
    String TEACHERS = "/jsp/teachers.jsp";
    String TEACHER = "/jsp/teacher.jsp";

    String EVENTS = "/jsp/events.jsp";
    String NEWS = "/jsp/news.jsp";
    String PROJECTS = "/jsp/projects.jsp";

    String execute(HttpServletRequest request, HttpServletResponse response);
}
