package state;

public class PedidoEstadoNovo extends PedidoEstado {

    public void aprovarPagamento(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoPago());
    }

    public void cancelar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoCancelado());
    }

    public String getNome() {
        return "Novo";
    }
}
