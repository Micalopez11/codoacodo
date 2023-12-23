<%@page import="dao.JugadoresDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Jugador"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Jugadores</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Lista de Jugadores</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Tema</th>
                        <th>Fecha Alta</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Crear una instancia de JugadoresDAO para acceder a la base de datos
                        JugadoresDAO jugadoresDAO = new JugadoresDAO();

                        // Obtener la lista de jugadores desde la base de datos
                        List<Jugador> jugadores = jugadoresDAO.obtenerTodos();

                        if (jugadores != null && !jugadores.isEmpty()) {
                            // Iterar sobre la lista de jugadores y mostrar sus datos en la tabla
                            for (Jugador jugador : jugadores) {
                    %>
                    <tr>
                        <td><%= jugador.getIdJugador()%></td>
                        <td><%= jugador.getNombre()%></td>
                        <td><%= jugador.getApellido()%></td>
                        <td><%= jugador.getTema()%></td>
                        <td><%= jugador.getFechaAlta()%></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="5">No hay jugadores registrados.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <!-- Botón para volver al índice -->
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>
