package DAO;


import Model.PedidoModel;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDAO {

        public void salvar(PedidoModel p){
            String insert = "INSERT INTO pedidos (data_pedido, nome_completo, endereço, telefone, sabor, tamanho,quantidade)" +
                    "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = null;
            try {
                ps = ConnectionDataBase.getConnection().prepareStatement(insert);
                ps.setObject(1,p.getDataPedido());
                ps.setObject(2,p.getNomeCompleto());
                ps.setObject(3,p.getEndereco());
                ps.setObject(4,p.getTelefone());
                ps.setObject(5,p.getSabor());
                ps.setObject(6,p.getTamanho());
                ps.setObject(7,p.getQuantidade());

                ps.execute();
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public ArrayList listar(){
            String select = "SELECT * FROM pedidospizzaria";

            Statement ps = null;
            ArrayList pedidos = new ArrayList<PedidoModel>();

            try {
                ps = ConnectionDataBase.getConnection().createStatement();
                ResultSet rs = ps.executeQuery(select);


                while(rs.next()){
                    PedidoModel pm = new PedidoModel();
                    pm.setDataPedido(rs.getDate("data_pedido"));
                    pm.setNomeCompleto(rs.getString("nome_completo"));
                    pm.setEndereco(rs.getString("endereço"));
                    pm.setTelefone(rs.getDouble("telefone "));
                    pm.setSabor(rs.getInt("sabor"));
                    pm.setTamanho(rs.getString("tamanho"));
                    pm.setQuantidade(rs.getInt("quantidade"));

                    pedidos.add(pm);
                }

                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return pedidos;
        }

    }

