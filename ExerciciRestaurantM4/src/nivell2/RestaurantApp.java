package nivell2;

import java.util.Scanner;

import java.util.ArrayList;

import java.util.Collections;

public class RestaurantApp {

	public static void main(String[] args) { 
		
		//assigna sca per cridar el mètode scanner
		Scanner sca = new Scanner(System.in);
		
		//valor de tots els bitllets d'euro
		int eur5 = 5;
		int eur10 = 10;
		int eur20 = 20;
		int eur50 = 50;
		int eur100 = 100;
		int eur200 = 200;
		int eur500 = 500;
		
		int preuTotalMenjar; //guarda el preu total del menjar
		
		
		/*//temp arrays
		String [] menu = {"cartxofes a la brasa", "patata amb bajoques", "peus de porc", "conill amb all i oli", "crema catalana", "gelat"};
		int [] preu = {5, 5, 10, 15, 5, 5}; */
		
		
		//Declara els arrays i els inicia a 6 plats. Potser seria més convenient una llista per variar el número de plats, però l'anunciat demana un array
		String[] menu = new String[6];
		int [] preu = new int[6];
		
		
		for (int i=0; i<menu.length; i++) {
			
			//assigna el nom del plat i
			System.out.println("Introduiu el plat #" + (i+1) + " del menú");
			try {
				menu[i] = sca.nextLine();
			} catch (Exception e) {
				System.out.println("Element en format incorrecte, si us plau, introduiu un String");
				menu[i] = sca.nextLine();
			}
			
			//assigna el preu del plat i
			System.out.println("Introduiu el preu del plat: " + menu[i]);
			try {
				preu[i] = Integer.parseInt(sca.nextLine());
				if (preu[i] % 5 != 0) {
					preu[1000] = 0; //condició impossible de complir
				}
			} catch (Exception e) {
				System.out.println("Element en format incorrecte, si us plau, introduiu un enter múltiple de 5");
				preu[i] = Integer.parseInt(sca.nextLine());
			}
		}
		
		
		//Ploteja la llista de plats i els seus preus
		System.out.println("         Menú del dia         ");
		System.out.println("------------------------------");
		for (int i=0; i<menu.length; i++) {
			System.out.println(menu[i] + " ---- " + preu[i] + "€");
		}
		
		
		//Demana al client quins plats vol prendre i els guarda a la llista comanda
		ArrayList<String> comanda = new ArrayList<String>();
		boolean voleuAlgoMes = true;
		while (voleuAlgoMes == true) {
			System.out.println("Què voldreu prendre?");
			String comandaTemp = sca.nextLine(); 
			
			boolean platExistent = false;
			for (int i=0; i<menu.length; i++) {
				if (menu[i].equals(comandaTemp)) {
					platExistent = true;
					System.out.println("Molt bona elecció");
					comanda.add(comandaTemp);
				}
			}
				
			if(platExistent == false) {
				System.out.println("Lamentablement el plat que desitgeu no es troba al menú");
			}
			
			
			System.out.println("Voleu algun altre plat? (y/n)");
			char lletra = sca.nextLine().charAt(0); //si en comptes de y o n posen yes o no, així també funciona
			try {
				if (lletra == 'n' || lletra == 'y') {}
				
				else {
					menu[1000] = "0"; //condició impossible de complir per fer saltar l'excepció
				}
				
			} catch (Exception e) {
				System.out.println("Introduiu una 'y' o una 'n' minúscula");
				lletra = sca.nextLine().charAt(0);
			}
			
			finally {
				if (lletra == 'n') { 
					voleuAlgoMes = false;
				}
			}
		}
		
		//busca el preu dels elements demanats al menú i els cobra.
		preuTotalMenjar = 0;
		for (int i=0; i<comanda.size(); i++) {
			for (int j=0; j<menu.length; j++) {
				if (menu[j].equals(comanda.get(i))) {
					preuTotalMenjar += preu[j];
					break;
				}
			}
		}
			
		
		//Retorna el preu total de la comanda i indica amb quins bitllets s'ha de pagar
		System.out.println("El total de la comanda són " + preuTotalMenjar + "€");
		
		ArrayList<Integer> bitllets = new ArrayList<Integer>(); //defineix un arraylist per guardar els bitllets
		
		for (int restaAPagar = preuTotalMenjar; restaAPagar != 0;) {
			if(restaAPagar - eur500 >= 0) {
				bitllets.add(eur500);
				restaAPagar -= eur500;
			}
			if(restaAPagar - eur200 >= 0) {
				bitllets.add(eur200);
				restaAPagar -= eur200;
			}
			if(restaAPagar - eur100 >= 0) {
				bitllets.add(eur100);
				restaAPagar -= eur100;

			}
			if(restaAPagar - eur50 >= 0) {
				bitllets.add(eur50);
				restaAPagar -= eur50;

			}
			if(restaAPagar - eur20 >= 0) {
				bitllets.add(eur20);
				restaAPagar -= eur20;

			}
			if(restaAPagar - eur10 >= 0) {
				bitllets.add(eur10);
				restaAPagar -= eur10;

			}
			if(restaAPagar - eur5 >= 0) {
				bitllets.add(eur5);
				restaAPagar -= eur5;
			}
		}
		
		//ploteja els bitllets necessaris per fer el pagament
		System.out.println("El pagament es pot fer amb bitllets de: ");
		Collections.sort(bitllets);  //ordena els bitllets
		for (int i=0; i<bitllets.size(); i++) {
			System.out.print(bitllets.get(i) + " ");
		}
	}
}
