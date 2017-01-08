package br.unifor.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 * Resultado dos testes:
 * Com um Array Dinâmico estoura a memória quando se tenta colocar 1.000.000 (um milhão) de registros.
 * 
 * Com um Array Estático (Vetor) não dá problema, mas tem-se que entrar com um valor máximo e criar
 * um método para saber até qual índice do vetor está preenchido.
 * 
 * 
 * 
 * @author Diego Augusto
 *
 */
public class Generator {

	public static void main (String[] args) {
		
		Generator g = new Generator();
		
		g.gerarArquivo(1000000);
//		g.lerFileComoArray();
		
	}
	
	public StringBuilder gerarArquivo(int quantidade) {
		
		StringBuilder content = new StringBuilder();
		
		for (int i = 0 ; i < quantidade ; i++) {
			if (i % 2 == 0) content.append((int)((Math.random() * 100) + (Math.random() * 10))+" ");
			else
			if (i % 3 == 0) content.append((int)((Math.random() * 10))+" ");
			else
			if (!(i % 2 == 0)) content.append((int)((Math.random() * 1000) + (Math.random() * 100) + (Math.random() * 10))+" ");
		}
		
		return content;
		
	}
	
	public void lerFileComoArray() {
		
//		List<Integer> vet = new ArrayList<Integer>();
//		LinkedList<Integer> a = new LinkedList<Integer>();
		
		int[] vet = new int[10000000];
		try {
			FileReader reader = new FileReader(new File("F:\\teste.txt"));
			BufferedReader leitor = new BufferedReader(reader);

			String t = null;
			int i = 0;
			while ((t = leitor.readLine()) != null) {
//				vet.add(t);
				
				String[] linha = t.split(" ");
				System.out.println("linha "+linha);
				int tamanhoLinha = linha.length;
				
				for ( int j = 0 ; j < tamanhoLinha ; j++) {
					vet[j + i] = Integer.parseInt(linha[j]);
				}
				
//				vet[i] = t;
				i++;
			}
			
			System.out.println(vet.toString());
			System.out.println("OK - funcionou!");
			for (int j = 0 ; j < vet.length ; j++) {
				if (vet[j] != 0)
				System.out.println(vet[j]+" ");
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
