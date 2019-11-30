package br.com.hospital.controller;


	import java.io.IOException;

import br.com.hospital.util.Rotas;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;

	public class Menu {

	    @FXML
	    private Button btnCadastro;

	    @FXML
	    private Button btnPaciente;

	    @FXML
	    private Button btnEnfermidade;

	    @FXML
	    private Button btnMedico;

	    @FXML
	    private Button btnEnfermeiro;

	    @FXML
	    private Button btnAtendimento;

	    @FXML
	    private Button btnEntrada;

	    @FXML
	    private Button btnEnfermidadePessoal;

	    @FXML
	    private Button btnGerente;

	    @FXML
	    void btnAtendimento(ActionEvent event)throws IOException {
	    	openpage(Rotas.ATENDIMENTO); 

	    }

	    private void openpage(String aTENDIMENTO) {
			// TODO Auto-generated method stub
			
		}

		@FXML
	    void btnCadastro(ActionEvent event)throws IOException {
	    	openpage(Rotas.CADASTRO); 

	    }

	    @FXML
	    void btnEnfermidade(ActionEvent event)throws IOException {
	    	openpage(Rotas.ENFERMIDADE); 

	    }

	    @FXML
	    void btnEnfermidadePessoal(ActionEvent event) throws IOException {
	    	openpage(Rotas.ENFERMIDADEPESSOAL);

	    }

	    @FXML
	    void btnEntrada(ActionEvent event)throws IOException {
	    	openpage(Rotas.ENTRADA); 

	    }

	    @FXML
	    void btnGerente(ActionEvent event)throws IOException {
	    	openpage(Rotas.GERENTE); 

	    }

	    @FXML
	    void btnMedico(ActionEvent event)throws IOException {
	    	openpage(Rotas.MEDICO); 

	    }

	    @FXML
	    void btnPaciente(ActionEvent event)throws IOException {
	    	openpage(Rotas.PACIENTE); 

	    }

	}


