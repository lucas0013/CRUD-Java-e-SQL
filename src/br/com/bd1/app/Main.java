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
		
		empregadoDao.save(empregado);
		for(Empregado e : empregadoDao.getEmpregado()) {
			System.out.println("Empregado: "+ e.getNome());
		}
		
		
	}

}
