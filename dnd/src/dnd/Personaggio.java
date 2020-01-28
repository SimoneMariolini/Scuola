package dnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Personaggio {
	public int livello;
	public String nome;
	public int razza;
	public int classe;
	public int hp;
	public int difesa;
	public int TxC;
	public Arma spada;
	public Armatura armatura;
	public int forza;
	public int destrezza;
	public int costituzione;
	public int intelligenza;
	public int saggezza;
	public int carisma;
	public int ModF;
	public int ModDes;
	public int ModCos;
	public int ModInt;
	public int ModSag;
	public int ModCar;

	public Personaggio() {

		livello = (int) (Math.random() * 20 + 1);
		razza = (int) (Math.random() * 10 + 1);
		classe = (int) (Math.random() * 12 + 1);
		spada = new Arma();
		armatura = new Armatura();
		for (int i = 1; i < 3; i++) {
			forza += (int) (Math.random() * 8 + 1);
			destrezza += (int) (Math.random() * 8 + 1);
			costituzione += (int) (Math.random() * 8 + 1);
			intelligenza += (int) (Math.random() * 8 + 1);
			saggezza += (int) (Math.random() * 8 + 1);
			carisma += (int) (Math.random() * 8 + 1);
		}

		ModF = (forza - 10) / 2;
		ModDes = (destrezza - 10) / 2;
		ModCos = (costituzione - 10) / 2;
		ModInt = (intelligenza - 10) / 2;
		ModSag = (saggezza - 10) / 2;
		ModCar = (carisma - 10) / 2;

		hp = ((int) (Math.random() * 10 + 1) + ModCos) * livello;
		if (hp <= 0) {
			hp = 1;
		}
		
		TxC = (int) (Math.random() * 20 + 1) + livello + ModF + spada.magia;
		difesa = 10 + ModF + armatura.CA;
		
	}

	public void inputPersonaggio() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		System.out.println("Inserisci nome Personaggio :");
		nome = tastiera.readLine();
	}
	
	public String trovaRazza() {
		String nrazza;
		switch (razza) {
		case 1:
			nrazza = "Aasimar";
			break;
		case 2:
			nrazza = "Avventurieri Mostruosi";		
			break;
		case 3:
			nrazza = "Dragonide";			
			break;
		case 4:
			nrazza = "Elfo";			
			break;
		case 5:
			nrazza = "Firbolg";
			break;
		case 6:
			nrazza = "Gith";
		break;
		case 7:
			nrazza = "Gnomo";
		break;
		case 8:
			nrazza = "Goliath";
		break;
		case 9:
			nrazza = "Halfing";
		break;
		case 10:
			nrazza = "Kenku";
		break;
		case 11:
			nrazza = "Lizardfolk";
		break;
		case 12:
			nrazza = "Nano";
		break;
		case 13:
			nrazza = "Tabaxi";
		break;
		case 14:
			nrazza = "Tiefling";
		break;
		case 15:
			nrazza = "Tritone";
		break;
		case 16:
			nrazza = "Umano";
		break;
		default :
			nrazza = "Orco";	
		}
		return nrazza;	
	}

	public String trovaClasse() {
		String  nclasse;
		switch (razza) {
		case 1:
			nclasse = "Barbaro";
			break;
		case 2:
			nclasse = "Bardo";		
			break;
		case 3:
			nclasse = "Chierico";			
			break;
		case 4:
			nclasse = "Druido";			
			break;
		case 5:
			nclasse = "Guerriero";
			break;
		case 6:
			nclasse = "Ladro";
		break;
		case 7:
			nclasse = "Mago";
		break;
		case 8:
			nclasse = "Monaco";
		break;
		case 9:
			nclasse = "Paladino";
		break;
		case 10:
			nclasse = "Ranger";
		break;
		case 11:
			nclasse = "Stregone";
		break;
		default :
			nclasse = "Warlock";	
		}	
		return nclasse;	
	}
	
	public void stampaPersonaggio() {
		String nr = trovaRazza();
		String nc = trovaClasse();
		System.out.println();
		System.out.println("Info Personaggio :");
		System.out.println("-Nome : " + nome);
		System.out.println("-Livello : " + livello);
		System.out.println("-Razza : " + nr);
		System.out.println("-Classe : " + nc);
		System.out.println("-HP : " + hp);
		System.out.println("-Difesa : " + difesa);
		System.out.println("-Forza : " + forza);
		System.out.println("-Destrezza : " + destrezza);
		System.out.println("-Costituzione : " + costituzione);
		System.out.println("-Intelligenza : " + intelligenza);
		System.out.println("-Saggezza : " + saggezza);
		System.out.println("-Carisma : " + carisma);
		System.out.println();
	}

	public int dannoSpada1(Personaggio p1) {
		int danno = 0;
			danno = p1.spada.dannoBase + p1.spada.magia + p1.ModF;
		return danno;
	}
	
	public int dannoSpada2(Personaggio p2) {
		int danno = 0;
			danno = p2.spada.dannoBase + p2.spada.magia + p2.ModF;
		return danno;
	}

	public void combattimento(Personaggio p2) throws InterruptedException {
		int turni = 1;
		int d1 = dannoSpada1(this);
		int d2 = dannoSpada2(p2);
		
		do {
			if (this.TxC >= p2.difesa) {
				System.out.println();
				System.out.println();
				System.out.println("Turno " + turni + " :");
				Thread.sleep(1000);
				System.out.println();
				System.out.println(this.nome + " ha colpito " + p2.nome);
				p2.hp -= d1;
				Thread.sleep(500);
				System.out.println();
				System.out.print("HP " + this.nome + " : " + this.hp + "\t\t\t" );
				System.out.println("HP " + p2.nome + " : " + p2.hp);
				
				if (p2.hp <= 0) {
					System.out.println();
					Thread.sleep(1000);
					System.out.println("Ha vinto " + this.nome);
					break;
				}
			}else {
				System.out.println();
				System.out.println();
				System.out.println("Turno " + turni + " :");
				System.out.println();
				System.out.println();
				Thread.sleep(1000);
				System.out.println(this.nome + " ha missato il colpo");
				System.out.println();
				Thread.sleep(500);
				System.out.print("HP " + this.nome + " : " + this.hp + "\t\t\t" );
				System.out.println("HP " + p2.nome + " : " + p2.hp);
			}
			
			if (p2.TxC >= this.difesa) {
				System.out.println();
				System.out.println();
				this.hp -= d2;
				Thread.sleep(1000);
				System.out.println(p2.nome + " ha colpito " + this.nome);
				System.out.println();
				Thread.sleep(500);
				System.out.print("HP " + this.nome + " : " + this.hp + "\t\t\t" );
				System.out.println("HP " + p2.nome + " : " + p2.hp);
				
				if (this.hp <= 0) {
					System.out.println();
					System.out.println();
					Thread.sleep(1000);
					System.out.println("Ha vinto " + p2.nome);
					break;
				}
			}else {
				System.out.println();
				System.out.println();
				Thread.sleep(1000);
				System.out.println(p2.nome + " ha missato il colpo");
				System.out.println();
				Thread.sleep(500);
				System.out.print("HP " + this.nome + " : " + this.hp + "\t\t\t" );
				System.out.println("HP " + p2.nome + " : " + p2.hp);
			}
			
			turni ++;
			
		}while(turni <= 1000);
	}
	
	public static void main(String[] args) throws IOException {
		Personaggio p1 = new Personaggio();
		Personaggio p2 = new Personaggio();
		Arma spada1 = new Arma();
		Arma spada2 = new Arma();
		Armatura armatura1 = new Armatura();
		Armatura armatura2 = new Armatura();
		p1.inputPersonaggio();
		p1.trovaClasse();
		p1.trovaRazza();
		p1.stampaPersonaggio();
		spada1.inserisciInput();
		spada1.trovaElemento();
		spada1.trovaTipo();
		spada1.stampaArma();
		armatura1.inputArmatura();
		armatura1.trovaClasseArmatura();
		armatura1.stampaArmatura();
		p2.inputPersonaggio();
		p2.trovaClasse();
		p2.trovaRazza();
		p2.stampaPersonaggio();
		spada2.inserisciInput();
		spada2.trovaElemento();
		spada2.trovaTipo();
		spada2.stampaArma();
		armatura2.inputArmatura();
		armatura2.trovaClasseArmatura();
		armatura2.stampaArmatura();
		
	}

}
