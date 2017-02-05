package command;

import model.*;
import org.apache.log4j.Logger;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Empty command. Return path to home page. Load all needed information.
 * Created by Nataliia Kozoriz on 08/11/2016.
 */
public class EmptyCommand implements Command {

    private static final Logger logger = Logger.getLogger(EmptyCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            NewsService nService = new NewsService();
            List<News> news = nService.getAll();

            EventService eService = new EventService();
            List<Event> events = eService.getAll();

            ProjectService pService = new ProjectService();
            List<Project> projects = pService.getAll();

            UniversityService uService = new UniversityService();
            List<University> universities = uService.getAll();

            StudentService sService = new StudentService();
            List<Student> students = sService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("universities", universities);
            session.setAttribute("students", students);
            session.setAttribute("events", events);
            session.setAttribute("news", news);
            session.setAttribute("projects", projects);

            List<Event> mainEvents = new ArrayList<>();
            for (int i = 0; i < Math.min(4, events.size()); i++)
                mainEvents.add(events.get(i));

            List<Project> mainProjects = new ArrayList<>();
            for (int i = 0; i < Math.min(2, projects.size()); i++)
                mainProjects.add(projects.get(i));

            session.setAttribute("mainEvents", mainEvents);
            session.setAttribute("mainProjects", mainProjects);
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }
}
