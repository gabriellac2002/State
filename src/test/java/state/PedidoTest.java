package state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PedidoTest {

    @Test
    void deveAlterarOEstadoDoPedidoDuranteOFluxoDeEntrega() {
        Pedido pedido = new Pedido("PED-001");

        assertEquals("Novo", pedido.getEstado());

        pedido.aprovarPagamento();
        assertEquals("Pago", pedido.getEstado());

        pedido.enviar();
        assertEquals("Enviado", pedido.getEstado());

        pedido.entregar();
        assertEquals("Entregue", pedido.getEstado());
    }

    @Test
    void devePermitirCancelarApenasAntesDoEnvio() {
        Pedido pedido = new Pedido("PED-002");
        pedido.aprovarPagamento();
        pedido.cancelar();

        assertEquals("Cancelado", pedido.getEstado());
    }

    @Test
    void naoDevePermitirEnviarPedidoNovo() {
        Pedido pedido = new Pedido("PED-003");

        assertThrows(IllegalStateException.class, pedido::enviar);
        assertEquals("Novo", pedido.getEstado());
    }

    @Test
    void naoDevePermitirCancelarPedidoEnviado() {
        Pedido pedido = new Pedido("PED-004");
        pedido.aprovarPagamento();
        pedido.enviar();

        assertThrows(IllegalStateException.class, pedido::cancelar);
        assertEquals("Enviado", pedido.getEstado());
    }
}
