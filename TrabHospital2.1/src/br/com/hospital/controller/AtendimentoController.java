package br.com.hospital.controller;


import br.com.hospital.DAO.AtendimentoDAO;
import br.com.hospital.model.Atendimento;
import br.com.hospital.model.Pessoa;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import br.com.hospital.util.Rotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
public class AtendimentoController extends Main{

	private static final Pessoa Altura = null;

	@FXML
    private Button btnFinalizar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnVoltar;
    @FXML
    private TextField txtpeso;

    @FXML
    private TextArea txtComentarioEnfermeiro;

    @FXML
    private TextArea txtComentarioMedico;

    @FXML
    private TableColumn<?, ?> peso;

    @FXML
    private TextField txtaltura;

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
    private TableView<?> listaAtendimento;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnAtualizar;
    @FXML
    void cancelar(ActionEvent event) {

    }
    @FXML
    void editar(ActionEvent event) {
    	try {
			AtendimentoDAO a = new AtendimentoDAO();
			txtComentarioEnfermeiro.setText(a.getComentarioEnfermeiro());
			txtpeso.setText("" + a.getPeso());
			txtDoenca.setText("" +a.getDoenca());
			txtaltura.setText("" + a.getAltura());
			txtComentarioMedico.setText(a.getComentarioMedico());
			

		} catch (Exception e) {

			e.printStackTrace();
		}



    }
    @FXML
    void excluir(ActionEvent event) {
    	try {
			Atendimento a = (Atendimento) listaAtendimento.getSelectionModel().getSelectedItem();
			System.out.println(a.getIdAtendimento());
			AtendimentoDAO adao = new AtendimentoDAO();
			adao.removeById(a.getIdAtendimento());
			openpage(Rotas.ATENDIMENTO);
		} catch (SQLException e) {

		} catch (NullPointerException e) {

		}

    }
    @FXML
    void atualizar(ActionEvent event) {
    	try {
			// somente para pegar ID
			Atendimento getId = (Atendimento) listaAtendimento.getSelectionModel().getSelectedItem();
			LocalDate data = date.getValue();
			float peso = Float.parseFloat(Pessoa.getText());
			String doenca = txtDoenca.getText();
			String ComentarioEnfermeiro = txtComentarioEnfermeiro.getText();
			float altura = Float.parseFloat(Pessoa.getText());
			String ComentarioMedico = txtComentarioMedico.getText();
			Atendimento atend = new Atendimento();
			AtendimentoDAO aDAO = new AtendimentoDAO();
			atend.setIdAtendimento(getId.getIdAtendimento());
			atend.setData(data);
			atend.setPeso(peso);
			atend.setDoenca(doenca);
			atend.setComentarioEnfermeiro(ComentarioEnfermeiro);
			atend.setAltura(altura);
			atend.setComentario_Medico(ComentarioMedico);
			
			aDAO.update(atend);
			openpage(Rotas.ATENDIMENTO);
		} catch (NumberFormatException e) {
			System.out.println("Campo Peso e altura vazios");
		}
    	

    }


    @FXML
    void finalizar(ActionEvent event) {
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
    	AtendimentoDAO atendimento1 = new AtendimentoDAO();
    	try {
			atendimento1.save(atendimento1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
			openpage(Rotas.MENU);
		} 


	private void openpage(String MENU) {
		// TODO Auto-generated method stub
		
	}
	@FXML
    void voltar(ActionEvent event) {
		openpage(Rotas.MENU);

	}

	
    

//@Override
/*	public void initialize(URL arg0, ResourceBundle arg1) {
	peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
		altura.setCellValueFactory(new PropertyValueFactory<>("altura"));
		comentarioMedico.setCellValueFactory(new PropertyValueFactory<>("comentario_Medico"));
		doenca.setCellValueFactory(new PropertyValueFactory<>("doenca"));
		Data.setCellValueFactory(new PropertyValueFactory<>("data"));
		AtendimentoDAO adao = new AtendimentoDAO();
		List<Atendimento> atendimentos = adao.select();

		System.out.println("Tamanho " + atendimentos.size());
		ObservableList<Atendimento> obsA = FXCollections.observableArrayList(atendimentos);



}*/
}
