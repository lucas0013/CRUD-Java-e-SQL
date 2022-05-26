package br.com.bd1.app;
import br.com.bd1.dao.EmpregadoDAO;
import br.com.db1.model.Empregado;

public class Main {
	public static void main(String[] args) {
		
		EmpregadoDAO empregadoDao = new EmpregadoDAO();
		
		Empregado empregado = new Empregado();
		empregado.setNome("Lucas dos Santos");
		empregado.setIdade(21);
		empregado.setSexo("M");
		
		Empregado e1 = new Empregado();
		
		e1.setNome("Lucas de Sousa");
		e1.setIdade(24);
		e1.setSexo("F");
		e1.setIdade(1);
		
		//empregadoDao.update(e1); 
		empregadoDao.deleteByID(10);
		//empregadoDao.save(empregado);
		for(Empregado e : empregadoDao.getEmpregado()) {
			System.out.println("Empregado: "+ e.getNome());
		}
		
		
	}

}
