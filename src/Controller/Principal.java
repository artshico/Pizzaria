package Controller;

import DAO.PedidoDAO;
import Model.PedidoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.Integer.*;

public class Principal {

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
    private JLabel jLabelDados;
    private JTextField jTextFieldNome;
    private JTextField jTextFieldEndereco;
    private JTextField jTextFieldTelefone;

    public Principal() {
        fazerPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PedidoModel p = new PedidoModel();


                p.setnomeCompeto(jTextFieldNome.getText());
                p.setEndereco(jTextFieldEndereco.getText());
                p.setTelefone(Double.parseDouble(jTextFieldTelefone.getText()));
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
                jTextFieldNome.setText("");
                jTextFieldEndereco.setText("");
                 jTextFieldTelefone.setText("");
               jTextFieldSaborEscolhido.setText("");
                jTextFieldTamanhoEscolha.setText("");
                jTextFieldSaborEscolhido.setText("");
            }
        });
    }

    public static void main(String[] args) throws IOException {


        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().jPanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 800));
        frame.pack();
    }
}
