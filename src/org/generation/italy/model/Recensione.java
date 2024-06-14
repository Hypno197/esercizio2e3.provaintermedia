package org.generation.italy.model;

import java.time.LocalDate;

public class Recensione {
	private LocalDate data;
	private int numeroStelle;
	private String nomeUtente, testo;

	public Recensione(int numeroStelle, String nomeUtente, String testo) {
		super();
		this.data = LocalDate.now();
		try {
			this.numeroStelle = setNumeroStelle(numeroStelle);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		this.nomeUtente = nomeUtente;
		this.testo = testo;
	}

	public LocalDate getData() {
		return data;
	}

	public int getNumeroStelle() {
		return numeroStelle;
	}

	public int setNumeroStelle(int numeroStelle) throws Exception {//verifica num stelle tra 1 e 5
		if (numeroStelle > 0 && numeroStelle < 6)
			return numeroStelle;
		else
			throw new Exception("Numero stelle non valido.");
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	@Override
	public String toString() {//tostring modificato per scrivere le recensioni
		return "Data: " + data +"\nNome Utente: " + nomeUtente + "\nRecensione: \n''"
				+ testo + "''";
	}

}
