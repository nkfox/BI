package command;

import model.Event;
import org.apache.log4j.Logger;
import service.EventService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This command loads all events into session.
 * Created by Nataliia Kozoriz on 14/11/2016.
 */
public class EventsCommand implements Command {

    private static final Logger logger = Logger.getLogger(EventsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            EventService eService = new EventService();
            List<Event> events = eService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("events", events);

            return EVENTS;
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }

}
