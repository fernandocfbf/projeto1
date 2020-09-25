package br.edu.mvc.model;

import java.sql.Connection;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.mvc.controller.*;

public class DAO {
	private Connection connection = null;

	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
			"jdbc:mysql://localhost/projeto1", "fernando", "password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Tarefas> getLista(String usuario) {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Tarefas WHERE usuario = '" + usuario + "';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				Tarefas tarefa = new Tarefas();
				
				tarefa.setId(rs.getInt("id"));
				tarefa.setTarefa(rs.getString("Tarefa"));
				tarefa.setMateria(rs.getString("materia"));
								
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				tarefa.setData_entrega(data);

				tarefa.setUsuario(rs.getString("usuario"));
				
				tarefas.add(tarefa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tarefas;
	}
	
	public void adiciona(Tarefas tarefa) {
		String sql = "INSERT INTO Tarefas" + "(tarefa, materia, data, usuario) values(?,?,?,?)";
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(1,tarefa.getTarefa());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.setString(2,tarefa.getMateria());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.setDate(3, new java.sql.Date(
					tarefa.getData_entrega().getTimeInMillis()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.setString(4,tarefa.getUsuario());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void altera(Tarefas tarefa) {
		String sql = "UPDATE Tarefas SET " + "tarefa=?, materia=?, data=? WHERE id=?";
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(1, tarefa.getTarefa());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.setInt(4, tarefa.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.setString(2, tarefa.getMateria());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setDate(3, new java.sql.Date(
					tarefa.getData_entrega().getTimeInMillis()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(Integer id) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("DELETE FROM Tarefas WHERE id=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setLong(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Tarefas> ordena(String orientador, String usuario) {
		
		try { 
			List<Tarefas> tarefas = new ArrayList<Tarefas>();
			
			String sql = "SELECT * FROM Tarefas WHERE usuario = '"+usuario+"' ORDER BY "+ orientador +" ;";
			
			System.out.println(sql);
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//stmt.setNString(1, usuario);
			//stmt.setNString(2, orientador);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Tarefas tarefa = new Tarefas();
				
				tarefa.setId(rs.getInt("id"));
				tarefa.setTarefa(rs.getString("Tarefa"));
				tarefa.setMateria(rs.getString("materia"));
				
				System.out.println(tarefa.getMateria());
								
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				tarefa.setData_entrega(data);
				
				tarefa.setUsuario(rs.getString("usuario"));
				
				tarefas.add(tarefa);
			}
			
			rs.close();
		
			stmt.close();
			
			return tarefas;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean verificaLogin(String usuario, String senha) {
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Login WHERE usuario = ? AND senha = ?;");
			
			stmt.setNString(1, usuario);
			stmt.setNString(2, senha);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				rs.close();
				
				stmt.close();
				return true;
			}else {
				rs.close();
				
				stmt.close();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
public List<Tarefas> buscar(String usuario, String busca) {
		
		try {
			List<Tarefas> tarefas = new ArrayList<Tarefas>();
			
			String sql = "SELECT * FROM Tarefas WHERE usuario = '" + usuario + "' AND tarefa = '" + busca + "' OR materia = '" + busca + "' OR data = '"+busca+"';";
			String sql_falso = "SELECT * FROM Tarefas WHERE usuario = '" + usuario + "';";
			
			System.out.println(sql);
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				while (rs.next()) {
					
					Tarefas tarefa = new Tarefas();
					
					tarefa.setId(rs.getInt("id"));
					tarefa.setTarefa(rs.getString("Tarefa"));
					tarefa.setMateria(rs.getString("materia"));
					
					System.out.println(tarefa.getMateria());
									
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("data"));
					tarefa.setData_entrega(data);
					
					tarefa.setUsuario(rs.getString("usuario"));
					
					tarefas.add(tarefa);
				}
				
				rs.close();
			
				stmt.close();
			}else {
				
				stmt = connection.prepareStatement(sql_falso);
				
				rs = stmt.executeQuery();
				
					while (rs.next()) {
					
					Tarefas tarefa = new Tarefas();
					
					tarefa.setId(rs.getInt("id"));
					tarefa.setTarefa(rs.getString("Tarefa"));
					tarefa.setMateria(rs.getString("materia"));
					
					System.out.println(tarefa.getMateria());
									
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("data"));
					tarefa.setData_entrega(data);
					
					tarefa.setUsuario(rs.getString("usuario"));
					
					tarefas.add(tarefa);
				}
				
				rs.close();
			
				stmt.close();
				
			}
			
		return tarefas;

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void cadastrar(String usuario, String senha) {
		try {
			String sql = "INSERT INTO Login" + "(usuario, senha) values(?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,usuario);
			stmt.setString(2,senha);
			stmt.execute();
			stmt.close();
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}