package command;

import model.Event;
import model.Member;
import model.News;
import model.Project;
import service.EventsService;
import service.MemberService;
import service.NewsService;
import service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Empty command. Return path to home page
 * Created by Nataliia Kozoriz on 08.11.2016.
 */
public class EmptyCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        NewsService nService = new NewsService();
        List<News> news = nService.getAll();

        EventsService eService = new EventsService();
        List<Event> events = eService.getAll();

        ProjectService pService = new ProjectService();
        List<Project> projects = pService.getAll();

        MemberService mService = new MemberService();
        List<Member> members = mService.getAll();

        HttpSession session = request.getSession(true);
        session.setAttribute("members", members);
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

        return START_PAGE;
    }
}
