package dnd;

import java.io.IOException;

public class DnD {

	public static void main(String[] args) throws IOException, InterruptedException   {
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
		p1.combattimento(p2);
		
	}

}
