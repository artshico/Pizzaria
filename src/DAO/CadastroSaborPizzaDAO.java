package DAO;

import Model.CadastroModel;
import Model.CadastroSaborPizzaModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CadastroSaborPizzaDAO {

    public void salvar(CadastroSaborPizzaModel p){
        String insert = "INSERT INTO cadastropizza (nome_pizza, ingredientes, tamanho_pequeno, tamanho_medio, tamanho_grande)" +
                "VALUES (?,?,?,?,?)";

        PreparedStatement ps = null;
        try {
            ps = ConnectionDataBase.getConnection().prepareStatement(insert);
            ps.setObject(1,p.getNomePizza());
            ps.setObject(2,p.getIngredientes());
            ps.setObject(3,p.getTamanhoPequeno());
            ps.setObject(4,p.getTamanhoMedio());
            ps.setObject(5,p.getTamanhoGrande());

            ps.execute();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList listar(){
        String select = "SELECT * FROM cadastropizza";

        Statement ps = null;
        ArrayList cadastropizza = new ArrayList<CadastroSaborPizzaModel>();

        try {
            ps = ConnectionDataBase.getConnection().createStatement();
            ResultSet rs = ps.executeQuery(select);


            while(rs.next()){
                CadastroSaborPizzaModel cs = new CadastroSaborPizzaModel();
                cs.setNomePizza(rs.getString("nome_pizza"));
                cs.setIngredientes(rs.getString("ingredientes"));
                cs.setTamanhoPequeno(rs.getString("tamanho_pequeno"));
                cs.setTamanhoMedio(rs.getString("tamanho_medio"));
                cs.setTamanhoGrande(rs.getString("tamanho_grande"));


                cadastropizza.add(cs);
            }

            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cadastropizza;
    }
}
