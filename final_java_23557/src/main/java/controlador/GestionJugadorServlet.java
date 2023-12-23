package controlador;

import dao.JugadoresDAO;
import modelo.Jugador;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/vistas/GestionJugadorServlet")
public class GestionJugadorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        JugadoresDAO jugadoresDAO = new JugadoresDAO();

        // Inicializar idOrador antes del switch para que esté disponible en todos los casos
        int idJugador = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "actualizar":
                Jugador jugador = jugadoresDAO.obtenerPorId(idJugador);
                request.setAttribute("jugador", jugador); //Esto permite pasar datos del servlet a una vista (como un archivo JSP) o a otro servlet al que se redirige o se reenvía la solicitud
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "confirmarActualizacion":
                Jugador jugadorActualizado = new Jugador();
                jugadorActualizado.setIdJugador(idJugador);
                jugadorActualizado.setNombre(request.getParameter("nombre"));
                jugadorActualizado.setApellido(request.getParameter("apellido"));
                jugadorActualizado.setTema(request.getParameter("tema"));
                // Asume que el método setFechaAlta acepta un java.sql.Date
                jugadorActualizado.setFechaAlta(java.sql.Date.valueOf(request.getParameter("fechaAlta")));

                jugadoresDAO.actualizarJugador(jugadorActualizado);
                response.sendRedirect("gestionJugadores.jsp");
                break;
            case "eliminar":
                jugadoresDAO.eliminarJugador(idJugador);
                response.sendRedirect("gestionJugadores.jsp");
                break;
            default:
                response.sendRedirect("gestionJugadores.jsp");
                break;
        }
    }
}

