package command;

import model.Event;
import service.EventsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This command shows all events
 * Created by Nataliia Kozoriz on 14.11.2016.
 */
public class EventCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            EventsService eService = new EventsService();
            List<Event> events = eService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("events", events);

            return EVENTS;
        } catch (Exception ex) {
            Logger.getLogger(EventCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return START_PAGE;
    }

}
