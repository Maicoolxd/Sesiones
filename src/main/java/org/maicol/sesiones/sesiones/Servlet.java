package org.maicol.sesiones.sesiones;


/*Nombre del programador: Michael Guaman
Materia: Lenguajes de Programacion 2
Fecha: 20/05/2024
Detalle:Ingreso se sesiones
Version:1.1.0*/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        // Creamos la sesion
        HttpSession session = req.getSession();

        String titulo = null;
        // Corregimos la obtención del atributo de sesión
        Integer contadorVisitas = (Integer) session.getAttribute("contadorVisitas");

        // Evaluamos la condición si es la primera vez que ingresa a la aplicación
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido a la aplicacion por primera vez";
        } else {
            contadorVisitas = contadorVisitas + 1;
            titulo = "Bienvenido a la aplicacion nuevamente";
        }

        // Seteamos o agregamos los nuevos valores a la sesion mediante el metodo
        session.setAttribute("contadorVisitas", contadorVisitas);


        res.getWriter().println("<html><body>");
        res.getWriter().println("<h1>" + titulo + "</h1>");
        res.getWriter().println("<p>Numero de accesos: " + contadorVisitas + "</p>");
        res.getWriter().println("</body></html>");
    }
}
