package Controller;

import DAO.PedidoDAO;
import Model.PedidoModel;
import jdk.internal.logger.BootstrapLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

import static java.lang.Integer.*;

public class PrincipalController {

    private JPanel jPanelPrincipal;
    private JLabel jLabelTitulo;
    private JLabel jlabelSabor01;
    private JLabel jLabelSabor02;
    private JLabel jLabelSabor03;
    private JLabel jLabelSabor04;
    private JLabel jLabelSabor05;
    private JLabel jLabelSabor06;
    private JLabel jLabelSabor07;
    private JLabel jLabelSabor08;
    private JLabel jLabelSabor09;
    private JLabel jLabelSabor10;
    private JLabel jLabelInformaçãoPedido;
    private JLabel jLabelTamanhoPizzaPequeno;
    private JLabel jLabelTamanhoPizzaMedia;
    private JLabel jLabelTamanhoGrande;
    private JTextField jTextFieldSaborEscolhido;
    private JTextField jTextFieldTamanhoEscolha;
    private JTextField JTextFieldQuantidade;
    private JButton fazerPedidoButton;
    private JButton cancelarButton;

    public PrincipalController() {

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
                p.setTamanho(jTextFieldTamanhoEscolha.getText());
                p.setQuantidade(parseInt(jTextFieldSaborEscolhido.getText()));

                PedidoDAO dao = new PedidoDAO();
                dao.salvar(p);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


               jTextFieldSaborEscolhido.setText("");
                jTextFieldTamanhoEscolha.setText("");
                jTextFieldSaborEscolhido.setText("");
            }
        });
    }


}
