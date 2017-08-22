package ado1.ap2;

import java.util.Scanner;

/**
 * MATHEUS DE JESUS MAIA
 *
 * @author matheus.jmaia
 */
public class ADO1AP2 {

    static Scanner console = new Scanner(System.in);
    /**
     * a variavel "nome" será usada para armazenar nomes temporariamente para a
     * passagem de dados de um metodo para o outro.
     */
    static String nome = "";

    //função apenas exibe o menu.
    static void exibeMenu() {
        System.out.println("");
        System.out.println("O que você quer fazer agora?");
        System.out.println("");
        System.out.println("1 - Adicionar um novo nome");
        System.out.println("2 - Apresentar os nomes");
        System.out.println("3 - Pesquisar um nome");
        System.out.println("4 - Remover um nome");
        System.out.println("0 - Sair");
        System.out.println("");
    }

    /**
     * função verifica o primerio indice vazio da lsita e adiciona um nome
     * também verifica se a lista está cheia, já que só sairá do laço (for)
     * quando não encontrar nenhuma variavel do vetor vazia, devido ao return
     * depois de adicionar o nome, logo a conclusão é que a lista está cheia.
     */
    static String[] adicionaNome(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = nome;
                System.out.println("Nome adicionado!");
                return lista;
            }
        }
        System.err.println("Ops..! parece que a lista está cheia, tente apagar alguns nomes ");
        return lista;
    }

    /**
     * função verifica se um nome já está presente na lista e retorna uma
     * booleana se o nome já está na lista retorna true, se não false.
     */
    static boolean verificaNomeExistente(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (nome.equalsIgnoreCase(lista[i])) {
                System.err.println("Esse nome já está na lista");
                return true;
            }
        }
        return false;
    }

    /**
     * função exibe todos os nomes da lista testa se a o indice da lista não
     * está vazio (null), para que não exiba variaveis em branco no meio da
     * lista. antes dos nomes são exibidos suas respectivas posições no vetor.
     */
    static void apresentaLista(String[] lista) {
        System.out.println("");
        System.out.println("*****ESSA É SUA LISTA*****");
        for (int i = 0; i < lista.length; i++) {
            if (!(lista[i] == null)) {
                System.out.println(i + " - " + lista[i]);
            }
        }
    }

    /**
     * função sem retorno localiza um nome e informa a posição que ele foi
     * encontrado, também informa caso o nome não seja encontrado.
     */
    static void localizarNome(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (nome.equalsIgnoreCase(lista[i])) {
                System.err.println("Eba! o nome foi encontrado, ele está localizado no vetor de posição '" + i + "'");
                return;
            }
        }
        System.err.println("Parece que o nome não está na lista. tente adiconá-lo :D");
    }

    /**
     * função busca o nome digitado e apaga (subustitui por "") e informa o
     * usurario caso tenha sucesso. também informa caso o nome solicitado para
     * deletar não esteja na lista
     */
    static String[] RemoverNome(String[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (nome.equalsIgnoreCase(lista[i])) {
                lista[i] = null;
                System.err.println("Nome apagado com sucesso!");
                return lista;
            }

        }
        System.err.println("ERRO: o nome não está na lista!");
        return lista;
    }

    static String[] arrumaVetor(String[] lista) {
        int n = 1;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = null;
                String v = lista[n];
                lista[i] = v;
                lista[n] = null;

                //return lista;
            }
            n = n + 1;
        }
        return lista;
    }

    public static void main(String[] args) {
        String[] lista = new String[5];
        System.out.println("*BEM VINDx A SUA LISTA*");
        int menu = 0;
        do {

            exibeMenu();
            menu = console.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Digite o nome a ser adicionado: ");
                    nome = console.next();
                    boolean nomeExistente = verificaNomeExistente(lista);
                    if (nomeExistente == false) {
                        lista = adicionaNome(lista);
                    }
                    break;
                case 2:
                    apresentaLista(lista);
                    break;
                case 3:
                    System.out.print("Digite um nome para ser pesquisado: ");
                    nome = console.next();
                    localizarNome(lista);
                    break;
                case 4:
                    System.out.print("Digite um nome para ser removido: ");
                    nome = console.next();
                    lista = RemoverNome(lista);
                    lista = arrumaVetor(lista);
                    break;
                case 0:
                    System.out.println("Até mais...");
                    break;
                default:
                    System.out.println("Opção inválida");

            }

        } while (!(menu == 0));

    }
}
