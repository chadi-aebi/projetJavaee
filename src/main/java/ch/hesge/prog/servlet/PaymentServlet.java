package ch.hesge.prog.servlet;

import ch.hesge.prog.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/Paiement.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<Product, Integer> cart = (HashMap<Product, Integer>) req.getSession().getAttribute("cart");
        cart.clear();
        req.getSession().setAttribute("cart", cart);
        req.getSession().setAttribute("nbCartItems", 0);
        resp.sendRedirect("produits?payment=ok");
    }
}
