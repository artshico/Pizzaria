package DAO;


import Model.CadastroModel;
import Model.PedidoModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CadastroDAO {

        public void salvar(CadastroModel p){
            String insert = "INSERT INTO cadastro (nome_completo, endereço, telefone, CPF)" +
                    "VALUES (?,?,?,?)";

            PreparedStatement ps = null;
            try {
                ps = ConnectionDataBase.getConnection().prepareStatement(insert);
                ps.setObject(1,p.getNomeCompleto());
                ps.setObject(2,p.getEndereco());
                ps.setObject(3,p.getTelefone());
                ps.setObject(4,p.getCPF());

                ps.execute();
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public ArrayList listar(){
            String select = "SELECT * FROM cadastro";

            Statement ps = null;
            ArrayList cadastro = new ArrayList<CadastroModel>();

            try {
                ps = ConnectionDataBase.getConnection().createStatement();
                ResultSet rs = ps.executeQuery(select);


                while(rs.next()){
                    CadastroModel cm = new CadastroModel();
                    cm.setNomeCompleto(rs.getString("nome_completo"));
                    cm.setEndereco(rs.getString("endereço"));
                    cm.setTelefone(rs.getDouble("telefone"));
                    cm.setCPF(rs.getDouble("CPF"));

                    cadastro.add(cm);
                }

                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return cadastro;
        }

    }

