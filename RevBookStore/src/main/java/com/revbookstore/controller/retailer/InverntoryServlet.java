package com.revbookstore.controller.retailer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revbookstore.dto.ProductReview;
import com.revbookstore.entity.Product;
import com.revbookstore.service.SellerService;
import com.revbookstore.util.ServiceFactory;

/**
 * Servlet implementation class InverntoryServlet
 */
@WebServlet("/retailer/inventory")
public class InverntoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SellerService sellerService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		sellerService = ServiceFactory.getSellerService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession();
		var id = (Long) session.getAttribute("user-id");
		var pid = request.getParameter("productId");
		if (pid != null) {
			var ppid = Long.parseLong(pid);
			var p = sellerService.getProduct(id, ppid);
			List<ProductReview> reviesList = sellerService.getProductReviews(id);
			request.setAttribute("product", p);
			request.setAttribute("reviews", reviesList);
			request.getRequestDispatcher("/seller-views/productinfo.jsp").forward(request, response);
			return;
		}
		List<Product> products = sellerService.getProducts(id);
		request.setAttribute("inventory", products);
		request.getRequestDispatcher("/seller-views/inventory.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("_method");

		if ("DELETE".equalsIgnoreCase(method)) {
			doDelete(request, response);
		} else {
			// Handle other POST operations, if any
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long productId = Long.parseLong(req.getParameter("id"));
		var session = req.getSession();
		var id = (Long) session.getAttribute("user-id");

		sellerService.deleteProduct(id, productId);

		resp.sendRedirect(req.getContextPath() + "/retailer/inventory");
	}

}
