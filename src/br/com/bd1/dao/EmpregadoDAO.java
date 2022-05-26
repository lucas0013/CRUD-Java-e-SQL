package br.com.bd1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.bd1.factory.ConnectionFactory;
import br.com.db1.model.Empregado;

public class EmpregadoDAO {
	
	/*
	 * CRUD
	 * c: CREATE
	 * r: READ
	 * u: UPDATE
	 * d: DELETE
	 */
	
	public void save(Empregado empregado) {
		
		String sql = "INSERT INTO empregado(nome, idade, sexo) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// Conectar com banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// PreparedStatement para executar uma query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, empregado.getNome());
			pstm.setInt(2, empregado.getIdade());
			pstm.setString(3, empregado.getSexo());
			//executar query
			pstm.execute();
			
			System.out.println("Empregado salvo com sucesso!!");
			
		} catch(Exception e){
			e.printStackTrace();
			
		}finally {
			//Fechar conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				}catch(Exception e) {
					e.printStackTrace(); 
			}
		}
	}
	
	public void update(Empregado empregado) {
		String sql = "UPDATE empregado SET nome = ?, idade = ?, sexo = ?" + "WHERE cod = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
	
	
		try {
			//Conexão com banco
			conn = ConnectionFactory.createConnectionToMySQL();
			//Classe paraexecutar query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar valores para atualização
			pstm.setString(1, empregado.getNome());
			pstm.setInt(2, empregado.getIdade());
			pstm.setString(3, empregado.getSexo());
			
			//Qual o ID do registro para atualizar?
			pstm.setInt(4, empregado.getIdade());
			
			//executar query
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteByID(int id) {
		String sql = "DELETE FROM empregado WHERE cod = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		try {
			//Conexão com banco
			conn = ConnectionFactory.createConnectionToMySQL();
			//Classe para executar query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Empregado> getEmpregado(){
		String sql = "SELECT * FROM empregado";
		
		List<Empregado> empregados = new ArrayList<Empregado>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Empregado empregado = new Empregado();
				
				// Recuperar id
				empregado.setIdade(rset.getInt("idade"));
				// Recuperar nome
				empregado.setNome(rset.getString("nome"));
				// Recuperar sexo
				empregado.setSexo(rset.getString("sexo"));
				
				empregados.add(empregado);
				
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}	
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return empregados;
	}
}
