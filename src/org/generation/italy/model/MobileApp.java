package org.generation.italy.model;
/*Scrivere una classe MobileApp contenente i seguenti attributi:
nome: stringa
sistemaOperativo: stringa
prezzo: float
elencoRecensioni: ArrayList di Recensione
ricavoTotale: float
e i seguenti metodi:
MobileApp(String nome, String sistemaOperativo, float prezzo)
 (costruttore della classe: inizializza gli attributi nome,
sistemaOperativo, prezzo in base ai parametri passati verificando
la validità dei parametri; inizializza elencoRecensioni,
numeroValutazioni, ricavoTotale a 0)
download():
incrementa il ricavoTotale del valore del prezzo
download(int numeroDownload):
incrementa il ricavoTotale del valore del prezzo*numeroDownload
riceviRecensione(Recensione recensione):
l'app riceve una nuova recensione
float valutazioneMedia():
restituisce la media delle recensioni ricevute finora (nr stelle)
getter e setter (verificare la validità dei dati dei parametri dei setter)*/

import java.util.ArrayList;

public class MobileApp {
	String nome, sistemaOperativo;
	double prezzo, ricavoTotale;
	ArrayList<Recensione> elencoRecensioni;

	public MobileApp(String nome, String sistemaOperativo, double prezzo) {
		super();
		this.nome = nome;
		this.sistemaOperativo = sistemaOperativo;
		try {
			setPrezzo(prezzo);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		this.elencoRecensioni = new ArrayList<Recensione>();
		this.ricavoTotale = 0;
	}

	private void setPrezzo(double prezzo) throws Exception {
		if (prezzo > 0) {
			this.prezzo = prezzo;
		} else
			throw new Exception("Prezzo non valido!");
	}

	public String getNome() {
		return nome;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public double getRicavoTotale() {
		return ricavoTotale;
	}

	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}

	public double download() {
		ricavoTotale += prezzo;
		return ricavoTotale;
	}

	public double download(int numDl) {
		ricavoTotale += (prezzo * numDl);
		return ricavoTotale;
	}

	public void riceviRecensione(Recensione recensione) {
		elencoRecensioni.add(recensione);
	}


public float valutazioneMedia(){
	int counter=0, totVal=0;
	float media=0;
	for (Recensione r : elencoRecensioni) {
		counter++;
		totVal+=r.getNumeroStelle();
		media=(totVal/counter);
}
	return media;
}
}