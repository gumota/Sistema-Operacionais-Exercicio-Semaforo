package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private int idCarro;
	private Semaphore semaforo;
	private String direcao;

	public ThreadCarro(int idCarro, Semaphore semaforo, String direcao) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.direcao = direcao;
	}

	@Override
	public void run() {
		carroParado();
		try {
			// --------P (Acquire)-------------//
			semaforo.acquire();
			carroAndando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// --------V (Release)-------------//
			semaforo.release();
			carroPassou();
		}
	}

	private void carroParado() {
		System.out.println("Carro #" + this.idCarro + " parou no cruzamento");
	}

	private void carroAndando() {

		System.out.println("carro #" + this.idCarro + " seguiu para direção " + this.direcao);

		int tempo = 1000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void carroPassou() {
		System.out.println("carro #" + idCarro + " passou o cruzamento ");
	}

}
