package br.com.hospital.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.hospital.DAO.EntradaDAO;
import br.com.hospital.model.Entrada;
import br.com.hospital.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EntradaController{
 

    @FXML
    private Button btnVoltar;

    @FXML
    private DatePicker DataEntrada;

    @FXML
    private Button btnFinalizar;

    @FXML
    private Button btnCancelar;

    @FXML
    private DatePicker dateSaida;

    @FXML
    private TextField txtStatusPaciente;

    @FXML
    private TextField txtPaciente;

    @FXML
    private TableColumn<?, ?> listaEntrada;

    @FXML
    private TableColumn<?, ?> listaPaciente;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnAtualizar;
    @FXML
    private TableView<?> listaEntrada1;


    @FXML
    void atualizar(ActionEvent event) throws IOException {
    
		LocalDate dataEntrada = DataEntrada.getValue();
		LocalDate dataSaida = dateSaida.getValue();
		String StatusPaciente = txtStatusPaciente.getText();
		
		EntradaDAO enDAO = new EntradaDAO();
		Entrada en = new Entrada();
	
		en.setDataEntrada(dataEntrada);
		
			
		enDAO.update(en);
		openpage(Rotas.ENTRADA);


    }

    @FXML
    void btnVoltar(ActionEvent event) {

    }

    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {
    	Entrada e = txtStatusPaciente.getSelection().getSelectedItem();
		txtPaciente.setPromptText(e.getIdPaciente());
		
		DataEntrada.setValue(e.getDataEntrada());
		dateSaida.setValue(e.getDataEntrada());

    }

    @FXML
    void excluir(ActionEvent event) {
    	try {
			Entrada e = listaEntrada.getSelection().getSelectedItem();
			System.out.println(e.getDataEntrada());
			EntradaDAO edao = new EntradaDAO();
			edao.removeById(e.getDataEntrada());
			openpage(Rotas.ENTRADA);
		} catch (SQLException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

    }

    private void openpage(String eNTRADA) {
		// TODO Auto-generated method stub
		
	}

	@FXML
    void finalizar(ActionEvent event) {

    }

    @FXML
    void voltar(MouseEvent event) {

    }

}
