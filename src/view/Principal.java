package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Principal {
	
	public static void main(String[] args) {

		int permissoes = 1;
		String[] direcao = {"norte", "sul", "leste", "oeste"};	
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idCarro = 0; idCarro < 4 ; idCarro++) {
			ThreadCarro tCarro = new ThreadCarro(idCarro, semaforo, direcao[idCarro]);
			tCarro.start();
		}
	}

}
