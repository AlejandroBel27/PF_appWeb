/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author LindaMoreno
 */
public class alimentadorBD {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/PopcornRush";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "linda";

    public static void main(String[] args) {
        String query = "INSERT INTO usuarios (nombre, correo, contraseña, telefono, avatar, ciudad, fechaNacimiento, genero, municipio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement statement = connection.prepareStatement(query)) {

            // Inserta el primer usuario
            statement.setString(1, "Juan Pérez");
            statement.setString(2, "juan@example.com");
            statement.setString(3, "123456"); // En producción, usa contraseñas hasheadas
            statement.setString(4, "1234567890");
            statement.setString(5, "avatar1.jpg");
            statement.setString(6, "Ciudad de México");
            statement.setString(7, "1990-05-15");
            statement.setString(8, "Masculino");
            statement.setString(9, "Benito Juárez");
            statement.executeUpdate();

            // Inserta el segundo usuario
            statement.setString(1, "María López");
            statement.setString(2, "maria@example.com");
            statement.setString(3, "password123");
            statement.setString(4, "0987654321");
            statement.setString(5, "avatar2.jpg");
            statement.setString(6, "Monterrey");
            statement.setString(7, "1985-10-20");
            statement.setString(8, "Femenino");
            statement.setString(9, "San Nicolás");
            statement.executeUpdate();

            System.out.println("Datos insertados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
