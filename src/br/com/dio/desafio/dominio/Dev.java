package br.com.dio.desafio.dominio;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Stream;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);

    }


    public void progredir(String titulo) {
        Stream<Conteudo> conteudo = this.conteudosInscritos.stream().filter(cont -> (cont.getTitulo().compareTo(titulo)) == 0);
        Optional<Conteudo> conteudoOptional = conteudo.findFirst();
        if(conteudoOptional.isPresent()){
            this.conteudosConcluidos.add(conteudoOptional.get());
            this.conteudosInscritos.remove(conteudoOptional.get());

        } else {
            if(conteudosInscritos.isEmpty()){
                System.err.println("O dev " + this.nome + " não está matriculado em nenhum curso !");
            } else {
                System.err.println("O nome do curso informado para o dev " + this.nome + " não corresponde a nenhum curso em nossa base de dados !");
            }

        }

    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConclucidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConclucidos(Set<Conteudo> conteudosConclucidos) {
        this.conteudosConcluidos = conteudosConclucidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return nome.equals(dev.nome) && conteudosInscritos.equals(dev.conteudosInscritos) && conteudosConcluidos.equals(dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
