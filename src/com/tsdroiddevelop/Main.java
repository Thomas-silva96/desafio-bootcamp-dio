package com.tsdroiddevelop;

import com.tsdroiddevelop.dominio.Bootcamp;
import com.tsdroiddevelop.dominio.Curso;
import com.tsdroiddevelop.dominio.Dev;
import com.tsdroiddevelop.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Scanner sc;
    static Bootcamp bootcamp;
    static Dev dev;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        bootcamp = new Bootcamp();
        dev = new Dev();
        String menuCurso = "n";
        int cm;

        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        do {
            System.out.println("Deseja criar: 1- Curso / 2- Mentoria");
            cm = sc.nextInt();
            sc.nextLine();

            if (cm == 1){
                criarCurso();
                System.out.println("Finalizar a criacao de cursos e mentoria: s - sim / n - nao");
                menuCurso = sc.nextLine();
            }
            else if (cm == 2){
                criarMentoria();
                System.out.println("Finalizar a criacao de cursos e mentoria: s - sim / n - nao");
                menuCurso = sc.nextLine();
            }
            else{
                System.out.println("Opcao invalida!");
            }

        }while (Objects.equals(menuCurso, "n"));

        criarDev();
        boolean estudar = true;

        while (estudar){
            System.out.println("\n\n-");
            System.out.println("Conteúdos Inscritos " + dev.getConteudosInscritos());
            System.out.println("\n\n");
            estudar = menuEstuda();
        }

        System.out.println("\n\n\n\n" + dev.getNome() + " O SEU PROGRESSO FOI:\n");

        System.out.println("Conteúdos Inscritos:" + dev.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos:" + dev.getConteudosConcluidos());
        System.out.println("XP:" + dev.calcularTotalXp());

    }

    private static boolean menuEstuda() {
        System.out.println("Continuar estudando digite 1, para sair digite 0.");
        int i = sc.nextInt();
        sc.nextLine();
        if (i == 1) {
            dev.progredir();
            return true;
        }
        else return false;
    }

    public static void criarCurso() {
        Curso curso = new Curso();
        System.out.println("Por favor digite o nome do curso:");
        curso.setTitulo(sc.nextLine());
        System.out.println("Por favor digite a descricao do curso:");
        curso.setDescricao(sc.nextLine());
        System.out.println("Por favor digite a carga horaria do curso:");
        curso.setCargaHoraria(sc.nextInt());
        sc.nextLine();

        System.out.println("Curso criado com sucesso:");
        bootcamp.getConteudos().add(curso);

    }

    public static void criarMentoria () {
        Mentoria mentoria = new Mentoria();
        System.out.println("Por favor digite o nome da mentoria:");
        mentoria.setTitulo(sc.nextLine());
        System.out.println("Por favor digite a descricao da mentoria:");
        mentoria.setDescricao(sc.nextLine());
        mentoria.setData(LocalDate.now());

        System.out.println("Mentoria criada com sucesso:");
        bootcamp.getConteudos().add(mentoria);
    }

    public static void criarDev () {
        System.out.println("Por favor digite o seu nome:");
        dev.setNome(sc.nextLine());
        dev.inscreverBootcamp(bootcamp);
    }
}
