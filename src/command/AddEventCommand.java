package command;

import model.Event;
import org.apache.log4j.Logger;
import service.EventService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * This command add new event.
 * Created by Nataliia Kozoriz on 14/11/2016.
 */
public class AddEventCommand implements Command {

    private static final Logger logger = Logger.getLogger(AddEventCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String title = request.getParameter("title");
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));
            String place = request.getParameter("place");
            String organizer = request.getParameter("organizer");
            String participants = request.getParameter("participants");
            String description = request.getParameter("description");

            EventService eService = new EventService();
            eService.add(new Event(title, startDate, endDate, place, organizer, participants, description));
            List<Event> events = eService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("events", events);
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return EVENTS;
    }
}
