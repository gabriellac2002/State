package state;

public class ExemploState {

    public static void main(String[] args) {
        Pedido pedido = new Pedido("PED-001");
        System.out.println("Estado inicial: " + pedido.getEstado());

        pedido.aprovarPagamento();
        pedido.enviar();
        pedido.entregar();

        System.out.println("Estado final: " + pedido.getEstado());
    }
}
