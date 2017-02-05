package command.member.teacher;

import command.Command;
import model.Teacher;
import org.apache.log4j.Logger;
import service.TeacherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This command loads all teachers into session.
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
public class TeachersCommand implements Command {

    private static final Logger logger = Logger.getLogger(TeachersCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            TeacherService tService = new TeacherService();
            List<Teacher> teachers = tService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("teachers", teachers);

            return STUDENTS;
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }

}
