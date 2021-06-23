package Controller;

import DAO.CadastroDAO;
import DAO.PedidoDAO;
import Model.CadastroModel;
import Model.PedidoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class CadastroController {
    private JPanel jPanelCadastro;
    private JLabel jLabelCadastroCliente;
    private JTextField jTextFieldNomeCompleto;
    private JTextField jTextFieldEndereco;
    private JTextField jTextFieldTelefone;
    private JTextField jTextFieldCPF;
    private JButton JbuttonCadastrar;
    private JButton jButtonlimpar;

    public CadastroController() {

        JFrame frame = new JFrame("Cadastro Cliente");
        frame.setContentPane(jPanelCadastro);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800,800));
        //frame.setJMenuBar(menuBar);
        frame.pack();




        JbuttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   CadastroModel c = new CadastroModel();

                    c.setNomeCompleto(jTextFieldNomeCompleto.getText());
                    c.setEndereco(jTextFieldEndereco.getText());
                    c.setTelefone(jTextFieldTelefone.getText());
                    c.setCPF(jTextFieldCPF.getText());

                    CadastroDAO dao = new CadastroDAO();
                    dao.salvar(c);
                }
            });


        jButtonlimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldNomeCompleto.setText("");
                jTextFieldTelefone.setText("");
                jTextFieldTelefone.setText("");
                jTextFieldCPF.setText("");
            }
        });
    }

}
