/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
	    
	    //HashSet não preserva a ordem de inserção
		Set<Carro> hashSetCarros = new HashSet<>();
		
		hashSetCarros.add(new Carro ("Ford"));
		hashSetCarros.add(new Carro("Chevrolet"));
		hashSetCarros.add(new Carro("Fiat"));
		hashSetCarros.add(new Carro("Zip"));
		hashSetCarros.add(new Carro("Alfa Romeo"));
		
		System.out.println(hashSetCarros);
		
		//TreeSet preserva a ordem 
		// árvore balanceada chamada Árvore Rubro-Negra (Red-Black Tree).
		//requer que na classe Carro seja implementada Comparable <Carro>
		Set<Carro> treeSetCarros = new treeSet();
		
		treeSetCarros.add(new Carro ("Ford"));
		treeSetCarros.add(new Carro("Chevrolet"));
		treeSetCarros.add(new Carro("Fiat"));
		treeSetCarros.add(new Carro("Zip"));
		treeSetCarros.add(new Carro("Alfa Romeo"));
		
		System.out.println(treeSetCarros);
		
		
	}
}

// package dio;

import java.util.Objects;

public class Carro implements Comparable<Carro>{

    String marca;

    public Carro(String marca) {
        this.marca = marca;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o){
        // Se o objeto comparado for o mesmo objeto (mesma referência na memória), retorna verdadeiro

        if (this == o) return true;

        // Verifica se o objeto atual é nulo ou se o objeto recebido não é da mesma classe
        if(this == null || getClass() != o.getClass()) return false;

        // Converte o objeto para o tipo Carro
        Carro carro = (Carro) o;

        // Compara a marca dos carros, usando Objects.equals para tratar casos de nulo
        return Objects.equals(marca, carro.marca);

    }

    @Override
    public int hashCode(){
        return Objects.hash(marca);
    }
    
    @Override
    public String toString() {
        return  "Carro{" +
                "marca=" + marca + "\'" +
                '"}";
    }
    /*
    @Override
    public int compareTo(Carro o){
        //compare pelo tamanho da string
        // para que sejam adicionados os items na arvore vazeados no tamanho da string
        if(this.marca.length()< o.marca.length()){
            return -1
        }else if (this.marca.length() > o.marca.length()){
            return 1;
        }
        return 0;
    }*/
    
    @Override
    public int compareTo(Carro o){
        //comparar para ordenar por ordem alfabetica
        return this.getMarca().compareTo(o.getMarca());
    }

}

