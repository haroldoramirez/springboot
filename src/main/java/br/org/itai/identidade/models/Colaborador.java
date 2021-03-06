package br.org.itai.identidade.models;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@ApiModel(value = "Colaborador", description = "Representação do Colaborador")
public class Colaborador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "Nome do Colaborador", required = true)
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(value = "Pais de Origem", required = true)
    @Column(nullable = false)
    private String pais;

    public Colaborador() {}

    public Colaborador(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "nome='" + nome + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
