package com.example.myapplicationlistview;

public class StatesBrazil {
    private String nome;
    private String sigla;
    private String siglaRegiao;

    private String link ="https://www.tutorialspoint.com/java/images/java-mini-logo.jpg";

    public String getSiglaRegiao() {
        return siglaRegiao;
    }

    public void setSiglaRegiao(String siglaRegiao) {
        this.siglaRegiao = siglaRegiao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }



    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +"Sigla: " + sigla;
    }

}
