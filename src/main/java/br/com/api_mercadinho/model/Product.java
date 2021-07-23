package br.com.api_mercadinho.model;

import javax.persistence.*;

@Entity
@Table(name= "product", schema = "mercadinho")
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "descricao")
    private String desc;

    @Column(nullable = false, name = "descricao_fornecedor")
    private String descForn;

    @Column(nullable = false, name = "preco")
    private Double preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescForn() {
        return descForn;
    }

    public void setDescForn(String descForn) {
        this.descForn = descForn;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
