package servlets;

import connection.ConnectionDB;
import connection.ConnectionMySql;
import entity.FullName;
import jdbc.JdbcFullName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/db")
public class ConvertDBIntoHtml extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionDB connectionDB = ConnectionMySql.getConnectionMySQL();
        JdbcFullName jdbcFullName = new JdbcFullName(connectionDB);
        List<FullName> list = jdbcFullName.getAllDataList();
        resp.setContentType("text/html");
        req.setAttribute("listName",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
