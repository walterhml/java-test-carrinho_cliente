package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     *
     * @param produto       O produto associado ao item
     * @param valorUnitario O valor unitário do produto
     * @param quantidade    A quantidade do produto
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    /**
     * Retorna o produto associado ao item.
     *
     * @return Produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Retorna a quantidade do item.
     *
     * @return int
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Retorna o valor total do item (valor unitário * quantidade).
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
        return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    /**
     * Define a quantidade do item.
     *
     * @param quantidade A nova quantidade do item
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Define o valor unitário do item.
     *
     * @param valorUnitario O novo valor unitário do item
     */
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
