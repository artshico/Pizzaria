package DAO;


import Model.PedidoModel;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDAO {

        public void salvar(PedidoModel p){
            String insert = "INSERT INTO pedidos (data_pedido , sabor, tamanho,quantidade,nome_completo, CPF)" +
                    "VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = null;
            try {
                ps = ConnectionDataBase.getConnection().prepareStatement(insert);
                ps.setObject(1,p.getDataPedido());
                ps.setObject(2,p.getSabor());
                ps.setObject(3,p.getTamanho());
                ps.setObject(4,p.getQuantidade());
                ps.setObject(5,p.getNomeCompleto());
                ps.setObject(6,p.getCPF());

                ps.execute();
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public ArrayList listar(){
            String select = "SELECT * FROM pedidos";

            Statement ps = null;
            ArrayList pedidos = new ArrayList<PedidoModel>();

            try {
                ps = ConnectionDataBase.getConnection().createStatement();
                ResultSet rs = ps.executeQuery(select);


                while(rs.next()){
                    PedidoModel pm = new PedidoModel();
                    pm.setID(rs.getInt("ID"));
                    pm.setDataPedido(rs.getDate("data_pedido"));
                    pm.setSabor(rs.getInt("sabor"));
                    pm.setTamanho(rs.getString("tamanho"));
                    pm.setQuantidade(rs.getInt("quantidade"));
                    pm.setNomeCompleto(rs.getString("nome_completo"));
                    pm.setCPF(rs.getString("CPF"));

                    pedidos.add(pm);
                }

                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return pedidos;
        }

    }

