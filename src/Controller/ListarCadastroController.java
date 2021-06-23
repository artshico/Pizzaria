package Controller;




import DAO.CadastroDAO;
import Model.CadastroModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListarCadastroController {

    private JPanel jPanelListaCadastro;
    private JScrollPane jScrollPaneListaCadastro;
    private JTable jTableListaCadastro;

    public ListarCadastroController () {
        String[] colunas = new String[]{
                "nome_completo", "endereço", "telefone", "CPF"};

        JFrame frame = new JFrame("Lista de Pedidos");
        CadastroDAO dao = new CadastroDAO();
        ArrayList<CadastroModel> lista = dao.listar();

        Object[][] infos = new Object[lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
            CadastroModel an = lista.get(i);
            infos[i][0] = an.getNomeCompleto();
            infos[i][1] = an.getEndereco();
            infos[i][2] = an.getTelefone();
            infos[i][3] = an.getCPF();

        }

        jTableListaCadastro = new JTable(infos, colunas);
        jScrollPaneListaCadastro = new JScrollPane(jTableListaCadastro);
        jTableListaCadastro.setFillsViewportHeight(true);
        frame.setContentPane(jScrollPaneListaCadastro);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 800));
        frame.pack();

    }
}
