package access;

import models.PacienteModel;
import utils.ConnectionDB;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PacienteDAO {
    private Connection conn = null;


    public ArrayList<PacienteModel> getAllPacientes() {
        ArrayList<PacienteModel> pacientes = new ArrayList();

        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT pac_cedula,pac_apellido,pac_nombre,pac_genero,pac_edad FROM paciente;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);

            while (result.next()) {
                PacienteModel paciente = new PacienteModel(result.getInt(1),
                        result.getString(2),result.getString(3),
                        result.getString(4),result.getInt(5));
                pacientes.add( paciente );
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return pacientes;
    }

    public ArrayList<PacienteModel> buscar( int keyWord){
        ArrayList<PacienteModel> pacientes = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT pac_cedula,pac_apellido,pac_nombre,pac_genero,pac_edad FROM paciente;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);

            while (result.next()) {
                PacienteModel paciente = new PacienteModel(result.getInt(1),
                        result.getString(2),result.getString(3),
                        result.getString(4),result.getInt(5));
                pacientes.add( paciente );
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }

        ArrayList<PacienteModel> pacienteFiltrado = new ArrayList<>();
        for (PacienteModel i:pacientes
             ) {
                if(keyWord == i.getPac_cedula()){
                    pacienteFiltrado.add(i);
                }
        }
        return pacienteFiltrado;
    }

    public ArrayList<PacienteModel> modificar (PacienteModel paciente){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE paciente SET pac_nombre =? WHERE pac_cedula=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, paciente.getPac_nombre());
            statement.setInt(2, paciente.getPac_cedula());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "The record was updated successfully !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return null;
    }


    public ArrayList<PacienteModel> getPacientesByGender(String pac_genero) {
        ArrayList<PacienteModel> pacientes = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT pac_cedula, pac_apellido, pac_nombre, pac_genero,pac_edad  FROM paciente WHERE pac_genero=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pac_genero);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                PacienteModel paciente = new PacienteModel(result.getInt(1),
                        result.getString(2), result.getString(3),
                        result.getString(4),result.getInt(5));
                pacientes.add( paciente );
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return pacientes;
    }

    public void insertPaciente(PacienteModel paciente){

        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO paciente(pac_cedula, pac_apellido, pac_nombre,pac_genero,pac_edad ) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, paciente.getPac_cedula());
            statement.setString(2, paciente.getPac_apellido());
            statement.setString(3, paciente.getPac_nombre());
            statement.setString(4, paciente.getPac_genero());
            statement.setInt(5, paciente.getPac_edad());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "The record was successfully added  !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }


    public void updatePaciente(PacienteModel paciente) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "UPDATE paciente SET pac_nombre =? WHERE pac_cedula=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, paciente.getPac_nombre());
            statement.setInt(2, paciente.getPac_cedula());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "The record was updated successfully !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }


    public void deletePaciente(int pac_cedula) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "DELETE FROM paciente WHERE pac_cedula=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pac_cedula);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "The record was successfully eliminated !!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

}
