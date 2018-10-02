package models.entidades;

import java.util.Date;

public class Cupom {
    private String codigo;
    private float valor;
    private Date validade;

    public Cupom(String codigo, float valor, Date validade) {
        this.codigo = codigo;
        this.valor = valor;
        this.validade = validade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}