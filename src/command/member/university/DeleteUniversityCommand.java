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
 * This command deletes university.
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
public class DeleteUniversityCommand implements Command {

    private static final Logger logger = Logger.getLogger(AddUniversityCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String email = request.getParameter("email");

            UniversityService uService = new UniversityService();
            uService.delete(email);
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
