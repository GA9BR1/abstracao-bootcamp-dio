import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);


        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        //System.out.println(curso1);
        //System.out.println(curso2);
        //System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devGustavo = new Dev();
        devGustavo.setNome("Gustavo");
        devGustavo.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Gustavo:" + devGustavo.getConteudosInscritos());
        devGustavo.progredir("curso java");
        devGustavo.progredir("curso js");
        devGustavo.progredir("mentoria de java");
        System.out.println("Conteúdos concluídos Gustavo:" + devGustavo.getConteudosConclucidos());
        System.out.println("Conteúdos inscritos Gustavo:" + devGustavo.getConteudosInscritos());
        System.out.println("XP: " + devGustavo.calcularTotalXp());

        System.out.println("----------Separação---------");

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir("curso java");
        System.out.println("Conteúdos concluídos Camila:" + devCamila.getConteudosConclucidos());
        System.out.println("Conteúdos inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("XP: " + devCamila.calcularTotalXp());

    }
}