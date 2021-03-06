package Controller;

import DAO.PedidoDAO;
import Model.PedidoModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListarPedidosController {
    private JPanel jPanelListarPedidos;
    private JScrollPane jScrollPanelListarPedidos;
    private JTable jTableListarPedidos;

    public ListarPedidosController() {
        String[] colunas = new String[]{
                "ID","data_pedido", "sabor","tamanho","quantidade", "nome_completo", "CPF"};

        JFrame frame = new JFrame("Lista de Pedidos");
       PedidoDAO dao = new PedidoDAO();
        ArrayList<PedidoModel> lista = dao.listar();

        Object[][] infos = new Object[lista.size()][7];

        for (int i = 0; i < lista.size(); i++) {
            PedidoModel an = lista.get(i);
            infos[i][0] = an.getID();
            infos[i][1] = an.getDataPedido();
            infos[i][2] = an.getSabor();
            infos[i][3] = an.getTamanho();
            infos[i][4] = an.getQuantidade();
            infos[i][5] = an.getNomeCompleto();
            infos[i][6] = an.getCPF();

        }

        jTableListarPedidos = new JTable(infos, colunas);
        jScrollPanelListarPedidos = new JScrollPane(jTableListarPedidos);
        jTableListarPedidos.setFillsViewportHeight(true);
        frame.setContentPane(jScrollPanelListarPedidos);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800,800));
        frame.pack();
    }
}


