package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserposDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserposDAO userposDAO = new UserposDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Anderson Morais");
		userposjava.setEmail("fernando.torres@gmail.com");

		userposDAO.salvar(userposjava);

	}

	@Test
	public void initListar() {
		UserposDAO dao = new UserposDAO();

		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("--------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initBuscar() {

		UserposDAO dao = new UserposDAO();

		try {
			Userposjava userposjava = dao.buscar(6L);

			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {

		try {
			UserposDAO dao = new UserposDAO();

			Userposjava objetoBanco = dao.buscar(4L);

			objetoBanco.setNome("Francisca");

			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void initDeletar() {
		
		try {			
			UserposDAO dao = new UserposDAO();			
			dao.deletar(5L);				
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(61) 995977259");
		telefone.setTipo("celular");
		telefone.setUsuario(20L);
		
		UserposDAO dao = new UserposDAO();
		dao.salvarTelefone(telefone);		
		
	}
	
	@Test
	public void testeCarregarFonesUser() {
		
		UserposDAO dao = new UserposDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(4L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFones);
			System.out.println("-------------------------------");
		}
		
	}
	
	@Test
	public void testeDeleteUserFone() {
		
		UserposDAO dao = new UserposDAO();
		dao.deleteFonesPorUser(10L);
		
	}
	
}
