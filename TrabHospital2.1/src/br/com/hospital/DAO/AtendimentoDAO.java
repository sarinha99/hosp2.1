package br.com.hospital.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.hospital.conexao.Conexao;
import br.com.hospital.model.Atendimento;

public class AtendimentoDAO {

	public void save(AtendimentoDAO atendimento1) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere ="INSERT INTO Atendimento VALUES (?,?,?,?,?,?,?) ";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		stmt.setInt(1, atendimento1.getIdAtendimento());
		stmt.setString(2, atendimento1.getComentarioEnfermeiro());
		stmt.setString(3, atendimento1.getComentarioEnfermeiro());
		stmt.setFloat(4, atendimento1.getPeso());
		stmt.setFloat(5, atendimento1.getAltura());
		stmt.setDate(6, java.sql.Date.valueOf(atendimento1.getData()));
		// stmt.setString(7, a.getDoenca());
		stmt.execute();
	}
	private String getData() {
		// TODO Auto-generated method stub
		return null;
	}
	public float getAltura() {
		// TODO Auto-generated method stub
		return 0;
	}
	public float getPeso() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getComentarioEnfermeiro() {
		// TODO Auto-generated method stub
		return null;
	}
	private int getIdAtendimento() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void removeById(int id) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "DELETE from Atendimento where id =(?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		stmt.setInt(1,id);
		stmt.execute();
		
	}
	public void Selecionar (Atendimento a) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "select from Atendimento(?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		stmt.setInt(1, a.getIdAtendimento());
		stmt.setString(2, a.getComentarioEnfermeiro());
		stmt.setString(3, a.getComentario_Medico());
		stmt.setFloat(4, a.getPeso());
		stmt.setFloat(5, a.getAltura());
		stmt.setDate(6,java.sql.Date.valueOf(a.getData()));
		// stmt.setString(7, a.getDoenca());
		stmt.execute();
		
	}
	
	public void Alterar (Atendimento a) throws SQLException {
		Conexao conn = new  Conexao();
		Connection conexao =  conn.getConnection();
		System.out.println(conn.getStatus());
		String sqlInsere = "update Atendimento set (?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
		
		stmt.setInt(1, a.getIdAtendimento());
		stmt.setString(2, a.getComentarioEnfermeiro());
		stmt.setString(3, a.getComentario_Medico());
		stmt.setFloat(4, a.getPeso());
		stmt.setFloat(5, a.getAltura());
		stmt.setDate(6,java.sql.Date.valueOf(a.getData()));
		// stmt.setString(7, a.getDoenca());
		stmt.execute();
		
	}
	public List<Atendimento> select() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getComentarioMedico() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDoenca() {
		// TODO Auto-generated method stub
		return null;
	}
	public void update(Object a) {
		// TODO Auto-generated method stub
		
	}
	
	
}
