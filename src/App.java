import java.util.Scanner;
import model.AgendaManager;
import model.Agendamento;

public class App {
    public static void main(String[] args) throws Exception {
        Agendamento[] agenda = new Agendamento[10];
        Scanner scanner = new Scanner(System.in);
        byte opt = 0;

        while(opt != 5){
            System.out.println("\n\n|\tSISTEMA Pet Shop\t|\n1 - Agendar Banho\n2 - Consultar Agenda\n3 - Editar Agendamento\n4 - Excluir Agendamento\n5 - Sair do Sistema\n\n\n");
            opt = scanner.nextByte();
            scanner.nextLine(); // Clear Buffer
            switch(opt){
                case 1:   
                    Agendamento novo = AgendaManager.agendarBanho(agenda);
                    agenda[novo.getHorarioBanho() - 1] = novo;
                    break;
                case 2:
                    AgendaManager.listarBanho(agenda);
                    break;
                case 3:
                    agenda = AgendaManager.editarBanho(agenda);
                    break;
                case 4:
                    agenda = AgendaManager.excluirBanho(agenda);
                    break;
                case 5:
                    System.out.println("SISTEMA FECHADO");
                    opt = 5;
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
            }
        }
    }
}