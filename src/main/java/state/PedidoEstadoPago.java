package state;

public class PedidoEstadoPago extends PedidoEstado {

    public void enviar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEnviado());
    }

    public void cancelar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoCancelado());
    }

    public String getNome() {
        return "Pago";
    }
}
