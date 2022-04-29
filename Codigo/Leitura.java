// Felippe Machado Nunes de Oliveira    RA:2347946

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura{

	public String entDados(String entrada){

		
		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(teclado);
		
		String ent ="";
		System.out.println(entrada);
		try{
			ent = buff.readLine();
		}
		catch(IOException ioe){
			System.out.println("\nERRO NA ENTRADA DE DADOS");
		}

		return ent;
	}

}