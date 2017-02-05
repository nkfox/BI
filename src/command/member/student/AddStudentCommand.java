package command.member.student;

import command.Command;
import model.Student;
import model.University;
import org.apache.log4j.Logger;
import service.StudentService;
import service.UniversityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * This command adds teacher.
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
public class AddStudentCommand implements Command {

    private static final Logger logger = Logger.getLogger(StudentCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String email = request.getParameter("studentEmail");
            String name = request.getParameter("name");
            String country = request.getParameter("country");
            String info = request.getParameter("info");
            String picture = request.getParameter("picture");
            Date birthDate = Date.valueOf(request.getParameter("birthDate"));
            String universityEmail = request.getParameter("universityEmail");
            String faculty = request.getParameter("faculty");
            String speciality = request.getParameter("speciality");
            String year = request.getParameter("year");

            UniversityService uService = new UniversityService();
            University university = uService.get(universityEmail);

            StudentService sService = new StudentService();
            sService.add(new Student(email, name, country, info, picture, birthDate, university, faculty, speciality, year));
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