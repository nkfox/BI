package command.member.student;

import command.Command;
import model.Student;
import org.apache.log4j.Logger;
import service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This command loads all students into session.
 * Created by Nataliia Kozoriz on 04/02/2017.
 */
public class StudentsCommand implements Command {

    private static final Logger logger = Logger.getLogger(StudentsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            StudentService sService = new StudentService();
            List<Student> students = sService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("students", students);

            return STUDENTS;
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }

}
