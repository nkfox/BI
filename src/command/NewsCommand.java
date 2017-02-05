package command;

import model.News;
import org.apache.log4j.Logger;
import service.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This command loads all news into session.
 * Created by Nataliia Kozoriz 14/11/2016.
 */
public class NewsCommand implements Command {

    private static final Logger logger = Logger.getLogger(NewsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            NewsService nService = new NewsService();
            List<News> news = nService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("news", news);

            return NEWS;
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }

}
