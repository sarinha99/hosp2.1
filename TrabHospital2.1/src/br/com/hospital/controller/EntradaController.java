package br.com.hospital.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class EntradaController {

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
    void atualizar(ActionEvent event) {
    	Entrada getId = ListaEntrada.getSelectionModel().getSelectedItem();
		LocalDate dataEntrada = dtDataEntrada.getValue();
		LocalDate dataSaida = dtDataSaida.getValue();
		String SituacaoPaciente = txtSituacaoPaciente.getText();
		String statusEntrada = txtStatusEntrada.getText();
		EntradaDAO enDAO = new EntradaDAO();
		Entrada en = new Entrada();
		en.setIdEntrada(getId.getIdEntrada());
		en.setDataEntrada(dataEntrada);
		en.setDataDeSaida(dataSaida);
		en.setSituacaoDePaciente(SituacaoPaciente);
		en.setStatusDeEntrada(statusEntrada);
		try {
			enDAO.update(en);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			openpage(Rotas.ENTRADA);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


    }

    @FXML
    void btnVoltar(ActionEvent event) {

    }

    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {
    	Entrada e = ListaEntrada.getSelectionModel().getSelectedItem();
		txtSituacaoPaciente.setText(e.getSituacaoDePaciente());
		txtStatusEntrada.setText(e.getStatusDeEntrada());
		dtDataEntrada.setValue(e.getDataEntrada());
		dtDataSaida.setValue(e.getDataDeSaida());

    }

    @FXML
    void excluir(ActionEvent event) {
    	try {
			Entrada e = ListaEntrada.getSelectionModel().getSelectedItem();
			System.out.println(e.getIdEntrada());
			EntradaDAO edao = new EntradaDAO();
			edao.removeById(e.getIdEntrada());
			openpage(Rotas.ENTRADA);
		} catch (SQLException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

    }

    @FXML
    void finalizar(ActionEvent event) {

    }

    @FXML
    void voltar(MouseEvent event) {

    }

}
