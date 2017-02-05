package command.member.teacher;

import command.Command;
import model.Teacher;
import org.apache.log4j.Logger;
import service.TeacherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This command loads teacher by id.
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
public class TeacherCommand implements Command {

    private static final Logger logger = Logger.getLogger(TeacherCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String email = request.getParameter("teacherEmail");

            TeacherService tService = new TeacherService();
            Teacher teacher = tService.get(email);

            HttpSession session = request.getSession(true);
            session.setAttribute("teacher", teacher);
            return STUDENT;
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }
}