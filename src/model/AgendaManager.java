package model;
import java.util.Scanner;

public class AgendaManager {

    public static Agendamento agendarBanho(Agendamento[] a){
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------\n\n1 - Banho Simples\n2 - Banho com Tosa\n\nDigite o ID do tipo de Banho: ");
        byte id = scanner.nextByte();
        scanner.nextLine(); // Clear Buffer
        Agendamento agenda = null;

        while(id < 1 || id > 2){
            System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 e 2!\n");
            id = scanner.nextByte();
            scanner.nextLine();
        }
        if(id == 1)
            agenda = new BanhoSimples();
        else
            agenda = new BanhoComTosa();

        System.out.println("\nDigite o nome do Pet: ");
        agenda.setNomePet(scanner.nextLine()); 
        
        System.out.println("\nDigite o nome da espécie: ");
        agenda.setEspecie(scanner.nextLine());
        
        System.out.println("\nDigite o nome do dono: ");
        agenda.setNomeDono(scanner.nextLine());

        System.out.println("\nDigite o número de telefone do dono: ");
        agenda.setTelefoneDono(scanner.nextLine());

        for(int i = 0; i < 10; i++){
            if(a[i] == null)
                System.out.println((i+1) + " - " + verificarData(i+1));
        }

        System.out.println("\nDigite o número respectivo ao horário do banho: ");
        byte h = scanner.nextByte();
        while(h < 1 || h > 10 || a[h-1] != null){
            System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 a 10! E QUE NÃO ESTEJAM CADASTRADOS\n");
            h = scanner.nextByte();
        }
        agenda.setHorarioBanho(h);
        return agenda;
    }

    public static void listarBanho(Agendamento[] a){
        System.out.println("\n\nLista de Banhos\n\n| ID |\tHorário\t|\tNome do Pet\t|\tNome do Dono\t|\tTelefone\t|\tTipo\t");
        for(int x=0; x < 10; x++ ){
            if(a[x] != null) {
                String tipo = "[Desconhecido]";
                if(a[x] instanceof BanhoSimples) {
                    tipo = ((BanhoSimples) a[x]).getTipoBanho();
                } else if(a[x] instanceof BanhoComTosa) {
                    tipo = ((BanhoComTosa) a[x]).getTipoBanho();
                }

                System.out.println("| "+(x + 1)+" |\t" 
                        + verificarData(a[x].getHorarioBanho()) + "\t|\t" 
                        + a[x].getNomePet() + "\t\t|\t" 
                        + a[x].getNomeDono() + "\t\t|\t" 
                        + a[x].getTelefoneDono()+ "\t|\t"
                        + tipo);
            }
        }
    }

    public static Agendamento[] editarBanho(Agendamento[] a){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do Banho: ");
        byte num = scanner.nextByte();
        while(num < 1 || num > 10){
            System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 a 10!\n");
            num = scanner.nextByte();
        }

        if(a[--num] != null){
            System.out.println("O que deseja fazer?\n" +
                               "1 - Mudar Nome do Pet\n" +
                               "2 - Mudar Nome do Dono\n" +
                               "3 - Mudar Telefone\n" +
                               "4 - Mudar Espécie\n" +
                               "5 - Mudar Horário\n" +
                               "6 - Mudar Tipo de Banho\n" +
                               "Qualquer outro número - Sair\n");
            int opt = scanner.nextInt();
            scanner.nextLine(); // Clear Buffer
            switch (opt) {
                case 1:
                    System.out.println("Digite o novo nome do Pet: ");
                    a[num].setNomePet(scanner.nextLine());
                    return a;
                case 2:
                    System.out.println("Digite o novo nome do Dono: ");
                    a[num].setNomeDono(scanner.nextLine());
                    return a;
                case 3:
                    System.out.println("Digite o novo telefone do Dono: ");
                    a[num].setTelefoneDono(scanner.nextLine());
                    return a;
                case 4:
                    System.out.println("Digite a nova espécie: ");
                    a[num].setEspecie(scanner.nextLine());
                    return a;
                case 5:
                    for(int i = 0; i < 10; i++){
                        if(a[i] == null){
                            System.out.println(i+1 + " - " + verificarData(i+1));
                        }
                    }
                    System.out.println("\nDigite o número respectivo ao novo horário do banho: ");
                    byte h = scanner.nextByte();
                    while(h < 1 || h > 10 || a[h-1] != null){
                        System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 a 10! E QUE NÃO ESTEJAM CADASTRADOS\n");
                        h = scanner.nextByte();
                    }
                    a[num].setHorarioBanho(h);
                    a[a[num].getHorarioBanho() - 1] = a[num];
                    a[num] = null;
                    return a;
                case 6:
                    System.out.println("Digite o novo tipo:\n1 - Banho Simples\n2 - Banho com Tosa");
                    byte id = scanner.nextByte();
                    scanner.nextLine(); // Clear Buffer

                    while(id < 1 || id > 2){
                        System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 e 2!\n");
                        id = scanner.nextByte();
                    }

                    Agendamento novoAgendamento = null;
                    if(id == 1)
                        novoAgendamento = new BanhoSimples();
                    else
                        novoAgendamento = new BanhoComTosa();
            
                    novoAgendamento.setNomePet(a[num].getNomePet());
                    novoAgendamento.setEspecie(a[num].getEspecie());
                    novoAgendamento.setNomeDono(a[num].getNomeDono());
                    novoAgendamento.setTelefoneDono(a[num].getTelefoneDono());
                    novoAgendamento.setHorarioBanho(a[num].getHorarioBanho());
                    a[num] = novoAgendamento;
                    return a;
                default:
                    break;
            }
        } else {
            System.out.println("[ERRO] ID NÃO CADASTRADO");
            return a;
        }
        return a;
    }

    public static Agendamento[] excluirBanho(Agendamento[] a){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do Banho: ");
        byte num = scanner.nextByte();
        while(num < 1 || num > 10 || a[num -1] == null){
            System.out.println("\n[ERRO]: APENAS NÚMEROS DE 1 a 10!\n");
            num = scanner.nextByte();
        }
        a[--num] = null;        
        return a;
    }

    public static String verificarData(int num){
        switch(num) {
            case 1:  return "12:30";
            case 2:  return "13:00";
            case 3:  return "13:30";
            case 4:  return "14:00";
            case 5:  return "14:30";
            case 6:  return "15:00";
            case 7:  return "15:30";
            case 8:  return "16:00";
            case 9:  return "16:30";
            case 10: return "17:00";
            default: return "[ERRO]";
        }
    }
}