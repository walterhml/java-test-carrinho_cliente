package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

    private Map<Produto, Item> itens;

    public CarrinhoCompras() {
        this.itens = new HashMap<>();
    }

    /**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * @param produto       O produto a ser adicionado
     * @param valorUnitario O valor unitário do produto
     * @param quantidade    A quantidade do produto a ser adicionada
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
        Item item = itens.get(produto);
        if (item != null) {
            // Item já existe no carrinho, atualizar quantidade e valor unitário se necessário
            int novaQuantidade = item.getQuantidade() + quantidade;
            BigDecimal novoValorUnitario = valorUnitario;

            // Se o valor unitário informado for diferente do valor unitário atual do item,
            // atualizar o novo valor unitário
            if (!item.getValorUnitario().equals(valorUnitario)) {
                novoValorUnitario = valorUnitario;
            }

            // Atualizar a quantidade e o valor unitário do item
            item.setQuantidade(novaQuantidade);
            item.setValorUnitario(novoValorUnitario);
        } else {
            // Novo item, adicioná-lo ao carrinho
            itens.put(produto, new Item(produto, valorUnitario, quantidade));
        }
    }

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto O produto a ser removido
     * @return true se o produto existir no carrinho e for removido com sucesso, false caso contrário
     */
    public boolean removerItem(Produto produto) {
        return itens.remove(produto) != null;
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na coleção,
     * em que zero representa o primeiro item.
     *
     * @param posicaoItem A posição do item a ser removido
     * @return true se o item na posição especificada for removido com sucesso, false caso contrário
     */
    public boolean removerItem(int posicaoItem) {
        if (posicaoItem < 0 || posicaoItem >= itens.size()) {
            return false;
        }
        Produto produto = itens.keySet().stream().skip(posicaoItem).findFirst().orElse(null);
        if (produto != null) {
            return itens.remove(produto) != null;
        }
        return false;
    }

    /**
     * Retorna o valor total do carrinho de compras, que é a soma dos valores totais de todos os itens.
     *
     * @return O valor total do carrinho de compras
     */
    public BigDecimal getValorTotal() {
        return itens.values().stream()
                .map(Item::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Retorna a coleção de itens do carrinho de compras.
     *
     * @return A coleção de itens do carrinho de compras
     */
    public Collection<Item> getItens() {
        return itens.values();
    }
}
