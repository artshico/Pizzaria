package Controller;

import DAO.CadastroSaborPizzaDAO;
import DAO.PedidoDAO;
import Model.CadastroSaborPizzaModel;
import Model.PedidoModel;
import jdk.internal.logger.BootstrapLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import static java.lang.Integer.*;

public class PedidosController {

    private JPanel jPanelPrincipal;
    private JLabel jLabelTitulo;
    private JLabel jLabelInformaçãoPedido;
    private JTextField jTextFieldSaborEscolhido;
    private JTextField jTextFieldTamanhoEscolha;
    private JTextField JTextFieldQuantidade;
    private JButton fazerPedidoButton;
    private JButton cancelarButton;
    private JTextField jTextFieldNomeCompleto;
    private JTextField jTextFieldCPF;
    private JScrollPane jScrollPanePedidoPizza;
    private JTable jTableListaPedidoPizza;
    private JPanel jPanelTabelaPizza;

    public PedidosController() {

            JFrame frame = new JFrame("Pedido");

            frame.setContentPane(jPanelPrincipal);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.setMinimumSize(new Dimension(800,800));
            //frame.setJMenuBar(menuBar);
            frame.pack();

        fazerPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PedidoModel p = new PedidoModel();

                p.setDataPedido(Calendar.getInstance().getTime());
                p.setSabor(parseInt(jTextFieldSaborEscolhido.getText()));
                p.setNomeCompleto(jTextFieldNomeCompleto.getText());
                p.setCPF(Double.parseDouble(jTextFieldCPF.getText()));
                p.setTamanho(jTextFieldTamanhoEscolha.getText());
                p.setQuantidade(parseInt(jTextFieldSaborEscolhido.getText()));

                PedidoDAO dao = new PedidoDAO();
                dao.salvar(p);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldCPF.setText("");
                jTextFieldNomeCompleto.setText("");
               jTextFieldSaborEscolhido.setText("");
                jTextFieldTamanhoEscolha.setText("");
                jTextFieldSaborEscolhido.setText("");
            }
        });

        String[] colunas = new String[]{
                "nome_pizza", "ingrediente", "tamanho_pequeno", "tamanho_medio", "tamanho_grande"};

        JFrame frame1 = new JFrame("Lista de Pizzas");
        CadastroSaborPizzaDAO dao = new CadastroSaborPizzaDAO();
        ArrayList<CadastroSaborPizzaModel> lista = dao.listar();

        Object[][] infos = new Object[lista.size()][5];

        for (int i = 0; i < lista.size(); i++) {
            CadastroSaborPizzaModel an = lista.get(i);
            infos[i][0] = an.getNomePizza();
            infos[i][1] = an.getIngredientes();
            infos[i][2] = an.getTamanhoPequeno();
            infos[i][3] = an.getTamanhoMedio();
            infos[i][4] = an.getTamanhoGrande();

        }

        jTableListaPedidoPizza = new JTable(infos, colunas);
        jScrollPanePedidoPizza = new JScrollPane(jTableListaPedidoPizza);
        jTableListaPedidoPizza.setFillsViewportHeight(true);
        frame.setContentPane(jScrollPanePedidoPizza);


    }


    }



