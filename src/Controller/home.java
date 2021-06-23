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
        JMenu menuListar = new JMenu("Listar ");
        JMenu menuCadastro = new JMenu("Cadastro");

        JMenuItem menuItemPedidos = new JMenuItem("Pedidos");
        JMenuItem menuItemCadastroCliente = new JMenuItem("Cadastro Clientes");
        JMenuItem menuItemCadastroSabor = new JMenuItem("Cadastro Sabores Pizza");

        JMenuItem menuItemListarPedido = new JMenuItem("Pedidos Feitos");
        JMenuItem menuItemListarCadastroCliente = new JMenuItem(" Lista Cadastro Clientes");
        JMenuItem menuItemListarCadastropizzas = new JMenuItem(" Lista Cadastro Pizzas");

        menuPedidos.add(menuItemPedidos);
        menuCadastro.add(menuItemCadastroCliente);
        menuCadastro.add(menuItemCadastroSabor);

        menuListar.add(menuItemListarPedido);
        menuListar.add(menuItemListarCadastroCliente);
        menuListar.add(menuItemListarCadastropizzas);

        menuBar.add(menuCadastro);
        menuBar.add(menuPedidos);
        menuBar.add(menuListar);

        menuItemPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PedidosController pedido = new PedidosController();
            }
        });
        menuItemCadastroSabor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroSaborPizzaController sabor = new CadastroSaborPizzaController();
            }
        });

        menuItemCadastroCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroController cadastro = new CadastroController();
            }
        });

        menuItemListarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarPedidosController listarPedidos = new ListarPedidosController();
            }
        });

        menuItemListarCadastroCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarCadastroController listarCadastroController = new ListarCadastroController();
            }
        });
        menuItemListarCadastropizzas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarCadastroSaboresPizzasController listarCadastroSaboresPizzasController = new ListarCadastroSaboresPizzasController();
            }
        });

        return menuBar;
    }
}
