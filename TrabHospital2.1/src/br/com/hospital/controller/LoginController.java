package br.com.hospital.controller;


	import java.awt.event.ActionEvent;

import br.com.hospital.DAO.AtendimentoDAO;
import br.com.hospital.model.Atendimento;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

import app.Main;
import br.com.hospital.util.Rotas;
import javafx.event.ActionEvent;

	public class LoginController  extends Main{

	    @FXML
	    private PasswordField senha;

	    @FXML
	    private TextField Usuario;

	    @FXML
	    private Button btnEntrar;

	    @FXML
	    void btnEntrar(ActionEvent event) {
	    	String usuarios = Usuario.getText();
	    	String senhas = senha.getText();
	    	

	    	
	    }

	    @FXML
	    void senha(ActionEvent event) {

	    }

	    @FXML
	    void usuario(ActionEvent event) {

	    }

	}


