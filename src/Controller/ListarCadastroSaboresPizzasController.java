package Controller;

import DAO.CadastroDAO;
import DAO.CadastroSaborPizzaDAO;
import Model.CadastroModel;
import Model.CadastroSaborPizzaModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListarCadastroSaboresPizzasController {

    private JPanel jPanelListarCadastroSabores;
    private JScrollPane jScrollPanelListarCadastroSabores;
    private JTable jTableListarCadastroSabores;


    public ListarCadastroSaboresPizzasController () {
        String[] colunas = new String[]{
                "nome_pizza", "ingrediente", "tamanho_pequeno", "tamanho_medio", "tamanho_grande"};

        JFrame frame = new JFrame("Lista de Pizzas");
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

        jTableListarCadastroSabores = new JTable(infos, colunas);
        jScrollPanelListarCadastroSabores = new JScrollPane(jTableListarCadastroSabores);
        jTableListarCadastroSabores.setFillsViewportHeight(true);
        frame.setContentPane(jScrollPanelListarCadastroSabores);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 800));
        frame.pack();

    }
}
