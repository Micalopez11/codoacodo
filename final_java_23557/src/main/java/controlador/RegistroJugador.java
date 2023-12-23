package controlador;

import dao.JugadoresDAO;
import modelo.Jugador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/registroJugador")
public class RegistroJugador extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String tema = request.getParameter("tema");

        // Crear un objeto Jugador con los datos
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setTema(tema);

        // Obtener la fecha actual
        java.util.Date fechaActual = new java.util.Date(); //es una forma de utilizar la clase sin necesitar una declaracion 'import'
        jugador.setFechaAlta(new Date(fechaActual.getTime()));

        // Agregar el jugador a la base de datos
        JugadoresDAO jugadoresDAO = new JugadoresDAO();
        jugadoresDAO.agregarJugador(jugador);

        // Redireccionar a la página de visualización de jugadores
        response.sendRedirect(request.getContextPath() + "/vistas/verJugadores.jsp");
    }
}
