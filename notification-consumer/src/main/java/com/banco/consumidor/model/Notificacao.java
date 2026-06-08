package com.banco.consumidor.model;

public class Notificacao {

    private int id;
    private String tipo;
    private String mensagem;
    private String conta;
    private double valor;
    private boolean lida;

    public Notificacao() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getConta() { return conta; }
    public void setConta(String conta) { this.conta = conta; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public boolean isLida() { return lida; }
    public void setLida(boolean lida) { this.lida = lida; }
}
