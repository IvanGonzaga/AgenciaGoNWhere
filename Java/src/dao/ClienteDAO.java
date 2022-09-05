package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {

		public void save(Cliente clientes) { 

			String sql = "INSERT INTO cliente (nome, cpf, telefone, endereco, email) VALUES (?, ?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, clientes.getNome());
				pstm.setString(2, clientes.getCpf());
				pstm.setString(3, clientes.getTelefone());
				pstm.setString(4, clientes.getEndereco());
				pstm.setString(5, clientes.getEmail());
				
				pstm.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally { 
				try { 
					if (pstm != null) { 
						pstm.close();
					}
					if (conn != null) { 
						conn.close();
					}
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
		}
		
		//READ
		public List<Cliente> getCliente() { 
			
			String sql = "SELECT * FROM cliente";
			
			List<Cliente> cliente = new ArrayList<Cliente>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) { 
					Cliente clientes = new Cliente();
					
						
					clientes.setId_cliente(rset.getInt("id_cliente"));
					clientes.setNome(rset.getString("nome"));
					clientes.setCpf(rset.getString("cpf"));
					clientes.setTelefone(rset.getString("telefone"));
					clientes.setEndereco(rset.getString("endereco"));
					clientes.setEmail(rset.getString("email"));
					
					
					cliente.add(clientes);
				}
			} catch (Exception e) { 
				e.printStackTrace();
			} finally { 
				try { 
					if (rset != null) { 
						rset.close();
					}
					if (pstm != null) { 
						pstm.close();
					}
					if (conn != null) { 
						conn.close();
					}
					
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
			
			return cliente;
		}

		//UPDATE
		public void update(Cliente clientes) { 
			
			String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, endereco = ?, email = ? WHERE id_cliente = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
		
				
				pstm.setString(1, clientes.getNome());
				pstm.setString(2, clientes.getCpf());
				pstm.setString(3, clientes.getTelefone());
				pstm.setString(4, clientes.getEndereco());
				pstm.setString(5, clientes.getEmail());
				pstm.setInt(6, clientes.getId_cliente());
				
				
				pstm.execute();
				
			} catch (Exception e) { 
				e.printStackTrace();
			} finally { 
				try { 
					if (pstm != null) { 
						pstm.close();
					}
					if (conn != null) { 
						conn.close();
					}
					
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
		}
		
		//DELETE
		public void deleteById(int id) { 
			
			String sql = "DELETE FROM cliente WHERE id_cliente = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				pstm.execute();
				
			} catch (Exception e) { 
				e.printStackTrace();
			} finally { 
				try { 
					if (pstm != null) { 
						pstm.close();
					}
					if (conn != null) { 
						conn.close();
					}
					
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
		}
	}