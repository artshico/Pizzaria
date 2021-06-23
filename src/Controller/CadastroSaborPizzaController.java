package Controller;

import DAO.CadastroSaborPizzaDAO;
import DAO.PedidoDAO;
import Model.CadastroSaborPizzaModel;
import Model.PedidoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class CadastroSaborPizzaController {

    private JPanel jPanelCadastroPizza;
    private JLabel jLabelCadastroPizza;
    private JTextField jTextFieldIngredientes;
    private JTextField jTextFieldNomePizza;
    private JTextField jTextFieldTamanhoPequeno;
    private JTextField jTextFieldTamanhoMedio;
    private JTextField jTextFieldTamanhoGrande;
    private JButton buttonCadastrar;
    private JButton buttonLimpar;


    public CadastroSaborPizzaController() {

        JFrame frame = new JFrame("Cadastro Novo Sabor");
        frame.setContentPane(jPanelCadastroPizza);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800,800));
        //frame.setJMenuBar(menuBar);
        frame.pack();

        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroSaborPizzaModel p = new CadastroSaborPizzaModel();

                p.setNomePizza(jTextFieldNomePizza.getText());
                p.setIngredientes(jTextFieldIngredientes.getText());
                p.setTamanhoPequeno(jTextFieldTamanhoPequeno.getText());
                p.setTamanhoMedio(jTextFieldTamanhoMedio.getText());
                p.setTamanhoGrande(jTextFieldTamanhoGrande.getText());


                CadastroSaborPizzaDAO dao = new CadastroSaborPizzaDAO();
                dao.salvar(p);
            }
        });
        buttonLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldNomePizza.setText("");
                jTextFieldIngredientes.setText("");
                jTextFieldTamanhoPequeno.setText("");
                jTextFieldTamanhoMedio.setText("");
                jTextFieldTamanhoGrande.setText("");
            }
        });
    }




    }

