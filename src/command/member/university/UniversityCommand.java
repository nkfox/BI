package command.member.university;

import command.Command;
import model.Student;
import model.Teacher;
import model.University;
import org.apache.log4j.Logger;
import service.StudentService;
import service.TeacherService;
import service.UniversityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This command loads university by id and teachers and students for it.
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
public class UniversityCommand implements Command {

    private static final Logger logger = Logger.getLogger(UniversityCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String email = request.getParameter("universityEmail");

            UniversityService uService = new UniversityService();
            University university = uService.get(email);

            StudentService sService = new StudentService();
            List<Student> univStudents = sService.getByUniversity(email);

            TeacherService tService = new TeacherService();
            List<Teacher> univTeachers = tService.getByUniversity(email);

            HttpSession session = request.getSession(true);
            session.setAttribute("university", university);
            session.setAttribute("univStudents", univStudents);
            session.setAttribute("univTeachers", univTeachers);
            return UNIVERSITY;
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }
}