package dnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Armatura {
	public String nome;
	public int CA;
	
	public Armatura() {
		CA = (int) (Math.random() * 8 + 1);
	}
	
	public void inputArmatura() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		System.out.println("Inserisci nome armatura :");
		nome = tastiera.readLine();
	}
	
	public String trovaClasseArmatura() {
		String NCA;
		switch (CA) {
		case 1:
			NCA = "Imbottita";
			break;
		case 2:
			NCA = "Cuoio";		
			break;
		case 3:
			NCA = "Giaco di maglia";			
			break;
		case 4:
			NCA = "Corazza di scaglie";			
			break;
		case 5:
			NCA = "Corazza di piasetre";
			break;
		case 6:
			NCA = "Mezza Armatura";
		break;
		case 7:
			NCA = "Corazza ad anelli";
		break;
		default :
			NCA = "Armatra Completa";	
		}
		return NCA;
	}
	
	public void stampaArmatura() {
		String NCA = trovaClasseArmatura();
		System.out.println();
		System.out.println("Info Armatura :");
		System.out.println("-Nome : " + nome);
		System.out.println("-Classe Armatura : " + NCA);
		System.out.println();
	}
		
			
	public static void main(String[] args) throws IOException {
		Armatura armatura = new Armatura();
		armatura.inputArmatura();
		armatura.trovaClasseArmatura();
		armatura.stampaArmatura();
	}

}
