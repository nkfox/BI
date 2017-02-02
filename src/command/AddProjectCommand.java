package command;

import model.Project;
import service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * This command add new project
 * Created by Nataliia Kozoriz on 14.11.2016.
 */
public class AddProjectCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        String organizer = request.getParameter("organizer");
        String description = request.getParameter("description");

        ProjectService pService = new ProjectService();
        pService.add(new Project(name, category, startDate, endDate, organizer, description));
        List<Project> projects = pService.getAll();

        HttpSession session = request.getSession(true);
        session.setAttribute("projects", projects);
        return "../jsp/projects.jsp";
    }
}
