package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class home {
    private JPanel jPanelHome;

    public static void main(String[] args) throws IOException {

        JMenuBar menuBar = getMenuBar();

        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new home().jPanelHome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setJMenuBar(menuBar);
        frame.pack();
    }

    private static JMenuBar getMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        JMenu menuPedidos = new JMenu("Pedidos");
        JMenu menuListar = new JMenu("Listar Pedidos");

        JMenuItem menuItemPedidos = new JMenuItem("Pedidos");

        JMenuItem menuItemListarPedido = new JMenuItem("Pedidos Feitos");

        menuPedidos.add(menuItemPedidos);

        menuListar.add(menuItemListarPedido);

        menuBar.add(menuPedidos);
        menuBar.add(menuListar);

        menuItemPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrincipalController pedido = new PrincipalController();
            }
        });
        menuItemListarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarPedidos listarPedidos = new ListarPedidos();
            }
        });
        return menuBar;
    }
}
