package command.member.university;

import command.Command;
import model.University;
import org.apache.log4j.Logger;
import service.UniversityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This command loads all universities into session.
 * Created by Nataliia Kozoriz on 14/11/2016.
 */
public class UniversitiesCommand implements Command {

    private static final Logger logger = Logger.getLogger(UniversitiesCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            UniversityService uService = new UniversityService();
            List<University> universities = uService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("universities", universities);

            return UNIVERSITIES;
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }

}
