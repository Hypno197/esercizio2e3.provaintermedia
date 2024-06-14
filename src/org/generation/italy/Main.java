package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.MobileApp;
import org.generation.italy.model.Recensione;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nome, OS;
		double prezzo;
		int scelta;
		boolean esci = false;
		System.out.println("Caricamento nuova applicazione in corso..");
		System.out.println("Inserire nome dell'app: ");
		nome = sc.nextLine();
		System.out.println("Inserire il sistema operativo di sviluppo: ");
		OS = sc.nextLine();
		System.out.println("Inserire il prezzo dell'applicazione: ");
		prezzo = sc.nextDouble();
		sc.nextLine();
		//costruzione oggetto app
		MobileApp app = new MobileApp(nome, OS, prezzo);
		while (app.getPrezzo() <= 0) {
			System.out.println("Inserire il prezzo dell'applicazione: ");
			prezzo = sc.nextDouble();
			sc.nextLine();
			app = new MobileApp(nome, OS, prezzo);

		}
		System.out.println("Applicazione creata con successo!");
		do {
			System.out.println("Seleziona l'operazione da eseguire: ");
			System.out.println("1) Download singolo");
			System.out.println("2) Download multiplo");
			System.out.println("3) Ricevi Recensione");
			System.out.println("4) Visualizza Recensione");
			System.out.println("5) Esci");
			scelta = sc.nextInt();
			sc.nextLine();
			//menu scelta
			switch (scelta) {
			case 1: {//download
				System.out.println("App scaricata! Ricavo totale: "+app.download());
				break;
			}
			case 2: {//download multiplo
				System.out.println("Inserire quantità di download: ");
				int qta=sc.nextInt();
				sc.nextLine();
				System.out.println("App scaricate! Ricavo totale: "+app.download(qta));
				break;
			}
			case 3 :{//costruzione recensione e aggiunta alla lista
				System.out.println("Inserisci il Nome Utente");
				String username=sc.nextLine();
				System.out.println("Inserisci il numero di stelle da assegnare: ");
				int numStelle=sc.nextInt();
				sc.nextLine();
				System.out.println("Inserisci il testo della recensione: ");
				String testo=sc.nextLine();
				Recensione r=new Recensione(numStelle, username, testo);
				app.riceviRecensione(r);
				break;
			}
			case 4 :{//visualizza lista
				for (Recensione r:app.getElencoRecensioni()) {
					System.out.println("Recensione: \nNumero di Stelle: ");
					int i;
					//ciclo for per scrivere le stelline
					for (i=0; i<r.getNumeroStelle(); i++)
						System.out.print("★");
					for (i=i; i<5; i++) {
						System.out.print("☆");
					}
					System.out.println("");
					System.out.println(r.toString());
					
				}
			break;
			}
			case 5: {
				esci = true;
			}
			}

		} while (!esci);

	}
}
