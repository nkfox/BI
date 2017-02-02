package command;

import model.News;
import service.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This command shows all news
 * Created by Abdulla Atkaev on 14.11.2016.
 */
public class NewsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            NewsService nService = new NewsService();
            List<News> news = nService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("news", news);

            return NEWS;
        } catch (Exception ex) {
            Logger.getLogger(NewsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return START_PAGE;
    }

}
