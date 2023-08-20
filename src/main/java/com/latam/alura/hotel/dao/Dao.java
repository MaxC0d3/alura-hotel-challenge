package com.latam.alura.hotel.dao;

import com.latam.alura.hotel.db.ConnectionFactory;
import com.latam.alura.hotel.view.MenuUsuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class Dao {
	public Dao(HashMap<Object, Object> opts) {
		var fechaEntrada = opts.get("fechaEntrada");
		var fechaSalida = opts.get("fechaSalida");
		var valor = opts.get("valor");
		var formaPago = opts.get("formaPago");
		var nombre = opts.get("nombre");
		var apellido = opts.get("apellido");
		var nacimiento = opts.get("fechaNacimiento");
		var nacionalidad = opts.get("nacionalidad");
		var telefono = opts.get("telefono");
		// var nreserva = opts.get("nReserva");

		try (Connection connection = new ConnectionFactory().getConnection()) {

			connection.setAutoCommit(false);

			String statementGuest = "INSERT INTO guest(name, lastname, datebt, nationality, phone) VALUES (?, ?, ?, ?, ?)";
			String statementReservations = "INSERT INTO reservations(dateEntry, dateDep, value, payment) VALUES (?, ?, ?, ?)";


			try (PreparedStatement stmtGuest = connection.prepareStatement(statementGuest)) {
				stmtGuest.setString(1, nombre.toString());
				stmtGuest.setString(2, apellido.toString());
				stmtGuest.setString(3, String.valueOf(nacimiento.toString()));
				stmtGuest.setString(4, nacionalidad.toString());
				stmtGuest.setString(5, telefono.toString());
				// stmtGuest.setInt(6, Integer.parseInt(nreserva.toString()));

				stmtGuest.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}


			try (PreparedStatement stmtReservations = connection.prepareStatement(statementReservations)) {
				stmtReservations.setDate(1, java.sql.Date.valueOf(fechaEntrada.toString()));
				stmtReservations.setString(2, String.valueOf(fechaSalida.toString()));
				stmtReservations.setInt(3, Integer.parseInt(valor.toString()));
				stmtReservations.setString(4, formaPago.toString());
				// stmtReservations.setInt(5, Integer.parseInt(nreserva.toString()));

				stmtReservations.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			connection.commit();

			JOptionPane.showMessageDialog(null, "Reserva realizada con éxito");

			MenuUsuario menu = new MenuUsuario();
			menu.setVisible(true);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
