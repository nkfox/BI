package command;

import model.Project;
import service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This command shows all projects
 * Created by Nataliia Kozoriz on 14.11.2016.
 */
public class ProjectCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ProjectService pService = new ProjectService();
            List<Project> projects = pService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("projects", projects);

            return PROJECTS;
        } catch (Exception ex) {
            Logger.getLogger(ProjectCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return START_PAGE;
    }

}
