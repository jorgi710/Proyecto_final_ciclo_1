package view;

import controllers.ControladorPaciente;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{

    private String rutaResources ="/resources/";
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCedula;
    private JTextField txtGenero;
    private JTextField txtEdad;
    private JButton btnGuardar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JPanel Ventana;
    private JLabel lblUsuario;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblCedula;
    private JLabel lblGenero;
    private JLabel lblEdad;
    private JLabel lblTtitulo;

    public Ventana() {
        setContentPane(Ventana);
        setTitle("RETO 5");
        setSize(1500, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        btnBuscar.addActionListener(new ControladorPaciente(this));
        btnEliminar.addActionListener(new ControladorPaciente(this));
        btnGuardar.addActionListener(new ControladorPaciente(this));
        btnLimpiar.addActionListener(new ControladorPaciente(this));
        btnModificar.addActionListener(new ControladorPaciente(this));

        btnModificar.setIcon(setIcono(rutaResources + "edit.png",btnModificar));
        btnModificar.setIcon(setIconoPresionado(rutaResources+"edit.png",btnModificar,33,20));

        btnBuscar.setIcon(setIcono(rutaResources + "loupe.png",btnBuscar));
        btnBuscar.setIcon(setIconoPresionado(rutaResources+"loupe.png",btnBuscar,33,20));

        btnEliminar.setIcon(setIcono(rutaResources + "remove.png",btnEliminar));
        btnEliminar.setIcon(setIconoPresionado(rutaResources+"remove.png",btnEliminar,33,20));

        btnGuardar.setIcon(setIcono(rutaResources + "updated.png",btnGuardar));
        btnGuardar.setIcon(setIconoPresionado(rutaResources+"updated.png",btnGuardar,33,20));

        btnLimpiar.setIcon(setIcono(rutaResources + "clean.png",btnLimpiar));
        btnLimpiar.setIcon(setIconoPresionado(rutaResources+"clean.png",btnLimpiar,33,20));

    }

    public Icon setIcono(String url, JButton btn){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(btn.getWidth(),btn.getHeight(),Image.SCALE_FAST));
        return icono;
    }
    public Icon setIconoPresionado(String url, JButton btn,int width,int Height){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(btn.getWidth(),btn.getHeight(),Image.SCALE_DEFAULT));
        return icono;
    }


    public static void main(String[] args) {
        Ventana v1 = new Ventana();
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtGenero() {
        return txtGenero;
    }

    public void setTxtGenero(JTextField txtGenero) {
        this.txtGenero = txtGenero;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(JTextField txtEdad) {
        this.txtEdad = txtEdad;
    }
}
