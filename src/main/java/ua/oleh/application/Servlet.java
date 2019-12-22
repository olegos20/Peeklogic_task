package ua.oleh.application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DropboxActioner dropboxActioner = new DropboxActioner();
     String path = request.getParameter("path");
     String token = request.getParameter("token");
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");
        try {
            dropboxActioner.createFolder(path,token);
            printWriter.println("Succes creating path with name: "+path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
