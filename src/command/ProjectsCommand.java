package command;

import model.Project;
import org.apache.log4j.Logger;
import service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This command loads all projects into session.
 * Created by Nataliia Kozoriz on 14/11/2016.
 */
public class ProjectsCommand implements Command {

    private static final Logger logger = Logger.getLogger(ProjectsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ProjectService pService = new ProjectService();
            List<Project> projects = pService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("projects", projects);

            return PROJECTS;
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }

}
