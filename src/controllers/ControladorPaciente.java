package controllers;

import access.PacienteDAO;
import models.PacienteModel;
import view.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorPaciente implements ActionListener {

    private PacienteDAO pacienteDAO;
    private Ventana ventana;

    public ControladorPaciente(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    public ControladorPaciente(Ventana ventana) {
        this.ventana=ventana;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        PacienteDAO p1 = new PacienteDAO();
        ArrayList<PacienteModel> pas = p1.getAllPacientes();
        if (e.getSource()==ventana.getBtnBuscar()){
            pas = p1.buscar(Integer.parseInt(ventana.getTxtBuscar().getText()));
            try {
                System.out.println(pas.get(0).getPac_cedula() + " " + pas.get(0).getPac_nombre());
                ventana.getTxtNombre().setText(pas.get(0).getPac_nombre());
                ventana.getTxtApellido().setText(pas.get(0).getPac_apellido());
                ventana.getTxtCedula().setText(pas.get(0).getPac_cedula() + "");
                ventana.getTxtGenero().setText(pas.get(0).getPac_genero());
                ventana.getTxtEdad().setText(pas.get(0).getPac_edad()+"");
            } catch (Exception e1){
                JOptionPane.showMessageDialog(null,"No se encontró resultado.");
                limpiar();
            }
        }  else if(e.getSource()==ventana.getBtnModificar()){
            try{
                pas = p1.buscar(Integer.parseInt(ventana.getTxtBuscar().getText()));
                PacienteModel p2= new PacienteModel(pas.get(0).getPac_cedula(),ventana.getTxtApellido().getText(),
                        ventana.getTxtNombre().getText(),pas.get(0).getPac_genero(),pas.get(0).getPac_edad());
                p1.updatePaciente(p2);
                limpiar();
            }catch (Exception e1){
                JOptionPane.showMessageDialog(null,"No se encontró resultado.");
                limpiar();
            }

        } else if(e.getSource()==ventana.getBtnLimpiar()){
            limpiar();
        } else if(e.getSource()==ventana.getBtnEliminar()){
            try{
                pas = p1.buscar(Integer.parseInt(ventana.getTxtBuscar().getText()));
                p1.deletePaciente(pas.get(0).getPac_cedula());
                limpiar();
            }catch (Exception e1){
                JOptionPane.showMessageDialog(null,"No se encontró resultado.");
                limpiar();
            }
        }else if(e.getSource()==ventana.getBtnGuardar()){
            try{
                PacienteModel p2= new PacienteModel(Integer.parseInt(ventana.getTxtCedula().getText()),ventana.getTxtApellido().getText(),
                        ventana.getTxtNombre().getText(),ventana.getTxtGenero().getText(),Integer.parseInt(ventana.getTxtEdad().getText()));
                p1.insertPaciente(p2);
                limpiar();
            }catch (Exception e1){
                JOptionPane.showMessageDialog(null,"No se pudo insertar el dato");
                limpiar();
            }
        }
    }
    public void limpiar(){
        ventana.getTxtNombre().setText(null);
        ventana.getTxtBuscar().setText(null);
        ventana.getTxtApellido().setText(null);
        ventana.getTxtCedula().setText(null);
        ventana.getTxtEdad().setText(null);
        ventana.getTxtGenero().setText(null);
    }
}
