package br.com.hospital.controller;


import br.com.hospital.DAO.AtendimentoDAO;
import br.com.hospital.model.Atendimento;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import app.Main;
import br.com.hospital.DAO.AtendimentoDAO;
import br.com.hospital.model.Atendimento;
import br.com.hospital.util.Rotas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AtendimentoController extends Main implements Inicializar {

	@FXML
    private Button btnFinalizar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextArea txtComentarioEnfermeiro;

    @FXML
    private TextArea txtComentarioMedico;

    @FXML
    private TableColumn<?, ?> peso;

    @FXML
    private TableColumn<?, ?> altura;

    @FXML
    private DatePicker date;

    @FXML
    private TextField txtDoenca;

    @FXML
    private ImageView comentarioEnfer;

    @FXML
    private TableColumn<?, ?> comentarioMedico;

    @FXML
    private TableColumn<?, ?> doenca;

    @FXML
    private TableColumn<?, ?> Data;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnAtualizar;
    @FXML
    void btnCancelar(ActionEvent event) {

    }
    @FXML
    void editar(ActionEvent event) {
    	try {
			Atendimento a = listAtendimento.getSelectionModel().getSelectedItem();

			txtComentarioEnfermeiro.setText(a.getComentarioEnfermeiro());
			txtPeso.setText("" + a.getPeso());
			txtDoenca.setText(a.getDoenca());
			txtAltura.setText("" + a.getAltura());
			txtComentarioMedico.setText(a.getComentarioMedico());
			txtData.setValue(a.getData());

		} catch (Exception e) {

			e.printStackTrace();
		}



    }
    @FXML
    void excluir(ActionEvent event) {
    	try {
			Atendimento a = listAtendimento.getSelectionModel().getSelectedItem();
			System.out.println(a.getIdAtendimento());
			AtendimentoDAO adao = new AtendimentoDAO();
			adao.removeById(a.getIdAtendimento());
			openpage(Rotas.ATENDIMENTO);
		} catch (SQLException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

    }
    @FXML
    void atualizar(ActionEvent event) {
    	try {
			// somente para pegar ID
			Atendimento getId = listAtendimento.getSelectionModel().getSelectedItem();
			LocalDate data = txtData.getValue();
			float peso = Float.parseFloat(txtPeso.getText());
			String doenca = txtDoenca.getText();
			String ComentarioEnfermeiro = txtComentarioEnfermeiro.getText();
			float altura = Float.parseFloat(txtAltura.getText());
			String ComentarioMedico = txtComentarioMedico.getText();
			Atendimento atend = new Atendimento();
			AtendimentoDAO aDAO = new AtendimentoDAO();
			atend.setIdAtendimento(getId.getIdAtendimento());
			atend.setData(data);
			atend.setPeso(peso);
			atend.setDoenca(doenca);
			atend.setComentarioEnfermeiro(ComentarioEnfermeiro);
			atend.setAltura(altura);
			atend.setComentarioMedico(ComentarioMedico);
			aDAO.update(a);
			openpage(Rotas.ATENDIMENTO);
		} catch (NumberFormatException e) {
			System.out.println("Campo Peso e altura vazios");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }


    @FXML
    void btnFinalizar(ActionEvent event)  {
    	String comentarioEnfermeiro = txtComentarioEnfermeiro.getText();
    	String comentarioMedico = txtComentarioMedico.getText();
    	float pesos=Float.parseFloat(peso.getText());
    	float  alturas = Float.parseFloat(altura.getText());
    	String  data = date.getPromptText();
    	String doencas = txtDoenca.getText();

    	Atendimento atendimento = new Atendimento();
    	atendimento.setComentarioEnfermeiro(comentarioEnfermeiro);
    	atendimento.setComentario_Medico(comentarioMedico);
    	atendimento.setPeso(pesos);
    	atendimento.setAltura(alturas);
    	atendimento.setDoenca(doencas);
    	AtendimentoDAO atendimento = new AtendimentoDAO();
    	atendimento.save(atendimento);
    	try {
			openpage(Rotas.DASH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (NumberFormatException e) {
		System.out.println("Campo Peso e altura vazios");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	@FXML
	void Voltardash(ActionEvent event) throws IOException {
		openpage(Rotas.DASH);

	}


    

@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tableCoEnf.setCellValueFactory(new PropertyValueFactory<>("comentarioEnfermeiro"));
		tableCoMedi.setCellValueFactory(new PropertyValueFactory<>("comentarioMedico"));
		tableDonca.setCellValueFactory(new PropertyValueFactory<>("doenca"));
		tablePeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
		tableAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
		tableData.setCellValueFactory(new PropertyValueFactory<>("data"));

		AtendimentoDAO adao = new AtendimentoDAO();
		List<Atendimento> atendimentos = adao.select();

		System.out.println("Tamanho " + atendimentos.size());
		ObservableList<Atendimento> obsA = FXCollections.observableArrayList(atendimentos);

		listAtendimento.setItems(obsA);

}
}
