import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz extends JFrame {

    private JTextField txtNombre, txtApellido, txtEdad, txtTelefono;
    private JTextField txtProducto, txtValor, txtCantidad;
    private JComboBox<String> cbTipo;
    private JLabel lblResultado;

    public Interfaz() {
        setTitle("DON APARATO");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(12, 2));

        // Campos
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtEdad = new JTextField();
        txtTelefono = new JTextField();
        txtProducto = new JTextField();
        txtValor = new JTextField();
        txtCantidad = new JTextField();

        cbTipo = new JComboBox<>(new String[]{"Seleccione", "A", "B", "C"});

        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Apellido:")); add(txtApellido);
        add(new JLabel("Edad:")); add(txtEdad);
        add(new JLabel("Teléfono:")); add(txtTelefono);
        add(new JLabel("Tipo:")); add(cbTipo);
        add(new JLabel("Producto:")); add(txtProducto);
        add(new JLabel("Valor:")); add(txtValor);
        add(new JLabel("Cantidad:")); add(txtCantidad);

        JButton btnCompra = new JButton("Realizar Compra");
        JButton btnMostrar = new JButton("Mostrar Datos");
        JButton btnLimpiar = new JButton("Limpiar");

        add(btnCompra);
        add(btnMostrar);
        add(btnLimpiar);

        lblResultado = new JLabel("");
        add(lblResultado);

        // EVENTOS

        btnCompra.addActionListener(e -> realizarCompra());
        btnMostrar.addActionListener(e -> mostrarDatos());
        btnLimpiar.addActionListener(e -> limpiar());

        setVisible(true);
    }

    private void realizarCompra() {
        try {
            Usuario user = new Usuario(
                txtNombre.getText(),
                txtApellido.getText(),
                Integer.parseInt(txtEdad.getText()),
                txtTelefono.getText(),
                cbTipo.getSelectedItem().toString()
            );

            double valor = Double.parseDouble(txtValor.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            double total = valor * cantidad;
            double descuento = 0;

            switch (user.getTipo()) {
                case "A": descuento = total * 0.40; break;
                case "B": descuento = total * 0.20; break;
                case "C": descuento = total * 0.10; break;
            }

            double pagar = total - descuento;

            if (user.getTipo().equals("Seleccione")) {
                lblResultado.setText("No se le realiza descuento | Total: " + total);
            } else {
                lblResultado.setText(
                    "Cliente: " + user.getNombre() +
                    " | Tipo: " + user.getTipo() +
                    " | Total: " + total +
                    " | Desc: " + descuento +
                    " | Pagar: " + pagar
                );
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en datos");
        }
    }

    private void mostrarDatos() {
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacíos");
        } else {
            lblResultado.setText(
                txtNombre.getText() + " " + txtApellido.getText() +
                " | Edad: " + txtEdad.getText() +
                " | Tel: " + txtTelefono.getText()
            );
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtProducto.setText("");
        txtValor.setText("");
        txtCantidad.setText("");
        cbTipo.setSelectedIndex(0);
        lblResultado.setText("");
    }
}
