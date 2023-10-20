package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(urlPatterns = "/otherServlet")

public class OtherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String print_response = "";
        Writer responseWriter = resp.getWriter();

        try {
            Optional<String> optNumber = Optional.ofNullable(req.getParameter("id"));
            Todo todo = Service.getTodo(Integer.valueOf(optNumber.get()));
            resp.setStatus(HttpServletResponse.SC_OK);

            ArrayList<Todo> todosList = new ArrayList<>();
            todosList.add(todo);
            print_response = Service.todosToHTMLTable(todosList);

        } catch (FileNotFoundException notFound) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            print_response = "No existe un item con el identificador dado";

        } catch (NumberFormatException format) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            print_response = "Requerimiento inválido";

        } catch (MalformedInputException malformed) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            print_response = "Error interno en el servidor";

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            print_response = "Requerimiento inválido";
        }

        String clean_response = StringEscapeUtils.escapeHtml4(print_response);
        responseWriter.write(clean_response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String print_response = "";
        Writer responseWriter = resp.getWriter();

        try {
            Optional<String> optNumber = Optional.ofNullable(req.getParameter("id"));
            Todo todo = Service.getTodo(Integer.valueOf(optNumber.get()));
            resp.setStatus(HttpServletResponse.SC_OK);

            ArrayList<Todo> todosList = new ArrayList<>();
            todosList.add(todo);
            print_response = Service.todosToHTMLTable(todosList);

        } catch (FileNotFoundException notFound) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            print_response = "No existe un item con el identificador dado";

        } catch (NumberFormatException format) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            print_response = "Requerimiento inválido";

        } catch (MalformedInputException malformed) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            print_response = "Error interno en el servidor";

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            print_response = "Requerimiento inválido";
        }

        String clean_response = StringEscapeUtils.escapeHtml4(print_response);
        responseWriter.write(clean_response);
    }
}
