package state;

public class PedidoEstadoEnviado extends PedidoEstado {

    public void entregar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEntregue());
    }

    public String getNome() {
        return "Enviado";
    }
}
