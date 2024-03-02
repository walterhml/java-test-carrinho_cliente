# java-test-carrinho_cliente
Teste java, Carrinho cliente
# Carrinho de Compras

Este projeto Java implementa um sistema de carrinho de compras, com classes para representar produtos, itens de carrinho, carrinhos de compras individuais e uma fábrica para criar e gerenciar os carrinhos de compras.

## Classes Implementadas

### Produto

A classe `Produto` representa um produto que pode ser adicionado como item ao carrinho de compras. Cada produto é identificado por um código único e tem uma descrição associada.

### Item

A classe `Item` representa um item no carrinho de compras. Cada item é composto por um produto, um valor unitário e uma quantidade. O valor total do item é calculado multiplicando o valor unitário pela quantidade.

### CarrinhoCompras

A classe `CarrinhoCompras` representa o carrinho de compras de um cliente. Ela permite adicionar, remover itens e calcular o valor total do carrinho de compras.

### CarrinhoComprasFactory

A classe `CarrinhoComprasFactory` é responsável pela criação e recuperação dos carrinhos de compras. Ela mantém uma coleção de carrinhos de compras e fornece métodos para criar novos carrinhos, calcular o valor médio dos carrinhos e invalidar carrinhos existentes.

## Instruções de Compilação e Execução

Este projeto pode ser compilado usando Maven. Para compilar o projeto, execute o seguinte comando na raiz do projeto:



Isso compilará o projeto e gerará um arquivo JAR executável.

## Exemplo de Uso

Aqui está um exemplo básico de como utilizar as classes implementadas:

```java
public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto(1L, "Camiseta");
        Produto produto2 = new Produto(2L, "Calça");
        
        CarrinhoComprasFactory factory = new CarrinhoComprasFactory();
        CarrinhoCompras carrinho1 = factory.criar("cliente1");
        
        carrinho1.adicionarItem(produto1, BigDecimal.valueOf(20.0), 2);
        carrinho1.adicionarItem(produto2, BigDecimal.valueOf(50.0), 1);
        
        BigDecimal valorTotal = carrinho1.getValorTotal();
        System.out.println("Valor total do carrinho: " + valorTotal);
    }
}

