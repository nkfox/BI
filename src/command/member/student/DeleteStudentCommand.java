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
 * This command deletes teacher.
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
public class DeleteStudentCommand implements Command {

    private static final Logger logger = Logger.getLogger(StudentCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String email = request.getParameter("studentEmail");

            StudentService sService = new StudentService();
            sService.delete(email);
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