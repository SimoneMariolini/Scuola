package dnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arma {
	public String nome;
	public int dannoBase;
	public int magia;
	public int elemento;
	public int tipo;

	public Arma() {
		dannoBase = (int) (Math.random() * 8 + 1);
		magia = (int) (Math.random() * 5);
		tipo = (int) (Math.random() * 2);
		elemento = (int) (Math.random() * 5);
	}

	public void inserisciInput() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		System.out.println("Inserisci nome Arma :");
		nome = tastiera.readLine();
	}

	public String trovaElemento() {
		String nelemento;
		switch (elemento) {
		case 0:
			nelemento = "Nessun Elemento";
			break;
		case 1:
			nelemento = "Fuoco";
			dannoBase += (int) (Math.random() * 6 + 1);
			break;
		case 2:
			nelemento = "Acqua";
			dannoBase += (int) (Math.random() * 6 + 1);
			break;
		case 3:
			nelemento = "Giaccio";
			dannoBase += (int) (Math.random() * 6 + 1);
			break;
		case 4:
			nelemento = "Terra";
			dannoBase += (int) (Math.random() * 6 + 1);
			break;
		default:
			nelemento = "Erba";
			dannoBase += (int) (Math.random() * 6 + 1);
		}

		return nelemento;

	}

	public String trovaTipo() {
		String ttipo;
		if (tipo == 1) {
			ttipo = "Ad una mano";
		} else {
			ttipo = "A due mani";
			dannoBase *= 1.5;
		}

		return ttipo;
	}

	public void stampaArma() {
		System.out.println();
		System.out.println("Info Arma :");
		System.out.println("-Nome : " + nome);
		System.out.println("-Magia : " + magia);
		System.out.println("-Elemento : " + trovaElemento());
		System.out.println("-Tipo : " + trovaTipo());
		System.out.println("-Danno Base : " + dannoBase);
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		Arma spada = new Arma();
		spada.inserisciInput();
		spada.trovaElemento();
		spada.trovaTipo();
		spada.stampaArma();
	}

}
