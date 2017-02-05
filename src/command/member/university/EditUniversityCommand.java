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
 * This command edits new university.
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
public class EditUniversityCommand implements Command {

    private static final Logger logger = Logger.getLogger(AddUniversityCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String country = request.getParameter("country");
            String info = request.getParameter("info");
            String picture = request.getParameter("picture");
            String city = request.getParameter("city");

            UniversityService uService = new UniversityService();
            uService.edit(new University(email, name, country, info, picture, city));
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
