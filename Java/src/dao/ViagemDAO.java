package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Viagem;

public class ViagemDAO {


		public void save(Viagem viagens) { 

			String sql = "INSERT INTO viagem (preco, periodo, origem, destino) VALUES (?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setDouble(1, viagens.getPreco());
				pstm.setString(2, viagens.getPeriodo());
				pstm.setString(3, viagens.getOrigem());
				pstm.setString(4, viagens.getDestino());
				
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

		public List<Viagem> getViagem() { 
			
			String sql = "SELECT * FROM viagem";
			
			List<Viagem> viagem = new ArrayList<Viagem>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) { 
					Viagem viagens = new Viagem();
						
					viagens.setId_viagem(rset.getInt("id_viagem"));
					viagens.setPreco(rset.getDouble("preco"));
					viagens.setPeriodo(rset.getString("periodo"));
					viagens.setOrigem(rset.getString("origem"));
					viagens.setDestino(rset.getString("destino"));
					
					viagem.add(viagens);
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
			
			return viagem;
		}

		public void update(Viagem viagens) { 
			
			String sql = "UPDATE viagem SET preco = ?, perido = ?, origem = ?, destino = ? WHERE id_viagem = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try { 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
		
				
				pstm.setDouble(1, viagens.getPreco());
				pstm.setString(2, viagens.getPeriodo());
				pstm.setString(3, viagens.getOrigem());
				pstm.setString(4, viagens.getDestino());
				pstm.setInt(5, viagens.getId_viagem());
				
				
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
		
		public void deleteById(int id) { 
			
			String sql = "DELETE FROM viagem WHERE id_viagem = ?";
			
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