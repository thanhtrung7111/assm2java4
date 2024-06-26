package admincontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.RapPhim;
import model.ThanhPho;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.RapPhimDAO;
import dao.ThanhPhoDAO;

/**
 * Servlet implementation class RapPhimServlet
 */
@WebServlet({ "/admin/rapphims", "/admin/createrapphim", "/admin/updaterapphim", "/admin/deleterapphim" })
public class RapPhimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RapPhimDAO rapPhimDAO;
	private ThanhPhoDAO thanhPhoDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RapPhimServlet() {
		super();
		rapPhimDAO = new RapPhimDAO();
		thanhPhoDAO = new ThanhPhoDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("rapphims")) {
			listRapPhim(req, resp);
		} else if (uri.contains("createrapphim")) {
			createRapPhim(req, resp);
		} else if (uri.contains("updaterapphim")) {
			updateRapPhim(req, resp);
		} else if (uri.contains("deleterapphim")) {
			deleteRapPhim(req, resp);
		}

	}

	private void listRapPhim(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			String maThanhPho = req.getParameter("maThanhPho");
			String keywork = req.getParameter("keyword");
			List<RapPhim> rapPhims = null;
			if (!maThanhPho.isBlank() && !keywork.isBlank()) {
				rapPhims = rapPhimDAO.selectAllByCityAndName(maThanhPho, keywork);
			} else if (!maThanhPho.isBlank() && keywork.isBlank()) {
				rapPhims = rapPhimDAO.selectAllByCity(maThanhPho);
			} else if (maThanhPho.isBlank() && !keywork.isBlank()) {
				rapPhims = rapPhimDAO.selectAllByName(keywork);
			} else {
				rapPhims = rapPhimDAO.selectAll();
			}
			List<ThanhPho> thanhPhos = thanhPhoDAO.selectAll();
			req.setAttribute("thanhPhos", thanhPhos);
			req.setAttribute("rapPhims", rapPhims);
		} else {
			List<ThanhPho> thanhPhos = thanhPhoDAO.selectAll();
			List<RapPhim> rapPhims = rapPhimDAO.selectAll();
			req.setAttribute("rapPhims", rapPhims);
			req.setAttribute("thanhPhos", thanhPhos);
		}
		req.setAttribute("view", "/views/admin/rapphim/list.jsp");
		req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
	}

	private void createRapPhim(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
//			System.out.println(req.getParameter("maThanhPho"));
			try {
				rapPhimDAO = new RapPhimDAO();
				RapPhim rapPhim = new RapPhim();
				BeanUtils.populate(rapPhim, req.getParameterMap());
				ThanhPho thanhPho = thanhPhoDAO.findById(req.getParameter("maThanhPho"));
				rapPhim.setThanhPho(thanhPho);
				rapPhimDAO.create(rapPhim);
				resp.sendRedirect("/cinemastar/admin/rapphims");
			} catch (Exception e) {
				List<ThanhPho> thanhPhos = thanhPhoDAO.selectAll();
				req.setAttribute("thanhPhos", thanhPhos);
				req.setAttribute("view", "/views/admin/rapphim/create.jsp");
				req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
			}

		} else {
			List<ThanhPho> thanhPhos = thanhPhoDAO.selectAll();
			req.setAttribute("thanhPhos", thanhPhos);
			req.setAttribute("view", "/views/admin/rapphim/create.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void updateRapPhim(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("post")) {
			try {
				RapPhim rapPhim = new RapPhim();
				BeanUtils.populate(rapPhim, req.getParameterMap());
				ThanhPho thanhPho = thanhPhoDAO.findById(req.getParameter("maThanhPho"));
				rapPhim.setThanhPho(thanhPho);
				rapPhimDAO.update(rapPhim);
				resp.sendRedirect("/cinemastar/admin/rapphims");
			} catch (Exception e) {
				RapPhim rapPhim = rapPhimDAO.findById(req.getParameter("maRapPhim"));
				List<ThanhPho> thanhPhos = thanhPhoDAO.selectAll();
				req.setAttribute("rapPhim", rapPhim);
				req.setAttribute("thanhPhos", thanhPhos);
				req.setAttribute("view", "/views/admin/rapphim/update.jsp");
				req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
			}

		} else {
			RapPhim rapPhim = rapPhimDAO.findById(req.getParameter("maRapPhim"));
			List<ThanhPho> thanhPhos = thanhPhoDAO.selectAll();
			req.setAttribute("rapPhim", rapPhim);
			req.setAttribute("thanhPhos", thanhPhos);
			req.setAttribute("view", "/views/admin/rapphim/update.jsp");
			req.getRequestDispatcher("/views/admin/layout.jsp").forward(req, resp);
		}
	}

	private void deleteRapPhim(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("maRapPhim");
			rapPhimDAO.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		resp.sendRedirect("/cinemastar/admin/rapphims");
	}
}
