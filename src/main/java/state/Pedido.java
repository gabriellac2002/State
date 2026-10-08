package state;

import java.util.Objects;

// Contexto: delega cada acao ao estado atual do pedido.
public class Pedido {

    private final String codigo;
    private PedidoEstado estado;

    public Pedido(String codigo) {
        this.codigo = Objects.requireNonNull(codigo, "O codigo do pedido e obrigatorio");
        this.estado = new PedidoEstadoNovo();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado.getNome();
    }

    void setEstado(PedidoEstado estado) {
        this.estado = Objects.requireNonNull(estado, "O estado e obrigatorio");
    }

    public void aprovarPagamento() {
        estado.aprovarPagamento(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void entregar() {
        estado.entregar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }
}
