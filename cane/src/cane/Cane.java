package cane;

public class Cane {
	private String nome;
	private int anni;
	private float peso;
	private int forza;

	public Cane(String n, int f) {
		nome = n;
		anni = 3;
		peso = 4.5f;
		forza = f;
	}

	public void mangia(int numCrocchette) {
		float pasto = numCrocchette * 0.05f;
		peso += pasto;
	}

	public int qanteCrocchettePerAumentareDi(float incrementoPeso) {
		int ip = (int) (incrementoPeso / 0.05f);
		return ip;
	}

	public void caga() {
		int numCrocchette = (int) (Math.random() * 3 + 2);
		peso -= numCrocchette * 0.05f;
	}

	public float mordi() {
		float danno = peso * forza;
		return danno;
	}

	public float attacca(int numMorsi, boolean haLaRabbia) {
		float dtot = 0f, x;
		for (int i = 0; i < numMorsi; i++) {
			x = mordi();
			dtot += x;
		}
		if (haLaRabbia) {
			dtot *= 2;
		}
		return dtot;
	}

	public static void main(String[] args) {

		Cane c1 = new Cane("Bobi", 25);
		System.out.println("Bau bau " + c1.nome);
		System.out.println("il cane " + c1.nome + " pesa " + c1.peso + "kg");
		c1.mangia(25);
		System.out.println("Dopo aver mangiato " + c1.nome + " pesa " + c1.peso + "kg");
		float danni = c1.attacca(5, true);
		System.out.println(c1.nome + " attacca infliggendo " + danni);
		c1.caga();
		System.out.println("Dopo aver mangiato caga e ora pesa " + c1.peso + "kg");
		int numCrocchette = c1.qanteCrocchettePerAumentareDi(4f);
		System.out.println("Per aumentare di 4kg deve mangiare : " + numCrocchette + " crocchette");
	}

}
