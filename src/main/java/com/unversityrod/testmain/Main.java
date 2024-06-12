package com.unversityrod.testmain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese el ID del alumno
        System.out.print("Ingrese el ID del alumno: ");
        int alumnoId = scanner.nextInt();

        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/university_of_the_live";
        String username = "root";
        String password = "Admin8919*";

        // Conectar a la base de datos y realizar consultas
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            
            // Algoritmo para saber qué cursos aprueba un alumno
            aprobarCursosAlumno(connection, alumnoId);
            
            // Pedir al usuario que ingrese el ID de la especialidad
            System.out.print("Ingrese el ID de la especialidad: ");
            int especialidadId = scanner.nextInt();

            // Algoritmo para saber qué cursos deben crear una nueva sección
            cursosConNuevaSeccion(connection, especialidadId);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void aprobarCursosAlumno(Connection connection, int alumnoId) throws SQLException {
        String query = "SELECT c.curso_descripcion AS cursoDescripcion, eac.nota AS nota " +
                       "FROM evaluacion_alumno_curso eac " +
                       "JOIN alumno_curso ac ON eac.alumno_curso_id = ac.alumno_curso_id " +
                       "JOIN curso c ON ac.curso_id = c.curso_id " +
                       "WHERE ac.alumno_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, alumnoId);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Calcular el promedio de notas
            double sumaNotas = 0;
            int count = 0;
            System.out.println("Cursos y notas del alumno con ID " + alumnoId + ":");
            while (resultSet.next()) {
                String cursoDescripcion = resultSet.getString("cursoDescripcion");
                double nota = resultSet.getDouble("nota");
                System.out.println(cursoDescripcion + ": " + nota);
                sumaNotas += nota;
                count++;
            }

            double promedio = count > 0 ? sumaNotas / count : 0;
            String estadoFinal = promedio > 4 ? "Aprueba" : "Reprueba";
            System.out.println("Promedio: " + promedio);
            System.out.println("Estado Final: " + estadoFinal);
        }
    }

    public static void cursosConNuevaSeccion(Connection connection, int especialidadId) throws SQLException {
        String query = "SELECT c.curso_id, c.curso_descripcion, COUNT(ac.alumno_id) AS cantidad_alumnos " +
                       "FROM curso c " +
                       "JOIN alumno_curso ac ON c.curso_id = ac.curso_id " +
                       "WHERE c.especialidad_id = ? " +
                       "GROUP BY c.curso_id, c.curso_descripcion";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, especialidadId);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Mostrar cursos que necesitan una nueva sección o no
            System.out.println("Cursos de la especialidad con ID " + especialidadId + ":");
            while (resultSet.next()) {
                int cursoId = resultSet.getInt("curso_id");
                String cursoDescripcion = resultSet.getString("curso_descripcion");
                int cantidadAlumnos = resultSet.getInt("cantidad_alumnos");

                if (cantidadAlumnos > 25) {
                    System.out.println("El curso " + cursoDescripcion + " de la especialidad con ID " + especialidadId + " necesita una nueva sección. Tiene " + cantidadAlumnos + " alumnos.");
                } else {
                    System.out.println("El curso " + cursoDescripcion + " de la especialidad con ID " + especialidadId + " no necesita una nueva sección. Tiene " + cantidadAlumnos + " alumnos.");
                }
            }
        }
    }
}
