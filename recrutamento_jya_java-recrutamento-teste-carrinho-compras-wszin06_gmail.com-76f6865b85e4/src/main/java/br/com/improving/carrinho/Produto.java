package br.com.improving.carrinho;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo     O código do produto
     * @param descricao  A descrição do produto
     */
    public Produto(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna o código do produto.
     *
     * @return Long
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define o código do produto.
     *
     * @param codigo O código do produto
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * Define a descrição do produto.
     *
     * @param descricao A descrição do produto
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Sobrescreve o método equals para comparar produtos com base no código.
     *
     * @param obj O objeto a ser comparado
     * @return true se os produtos tiverem o mesmo código, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return codigo.equals(produto.codigo);
    }

    /**
     * Sobrescreve o método hashCode para garantir consistência com o método equals.
     *
     * @return O código de hash do objeto
     */
    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
