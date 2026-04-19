import java.util.Stack;

public class FilaConPilas<T> {

    private Stack<T> entrada;
    private Stack<T> salida;

    public FilaConPilas() {
        entrada = new Stack<>();
        salida = new Stack<>();
    }

    public void enqueue(T item) {
        entrada.push(item);
    }

    public T dequeue() {
        if (isEmpty()) return null;

        if (salida.isEmpty()) {
            while (!entrada.isEmpty()) {
                salida.push(entrada.pop());
            }
        }

        return salida.pop();
    }

    public T peek() {
        if (isEmpty()) return null;

        if (salida.isEmpty()) {
            while (!entrada.isEmpty()) {
                salida.push(entrada.pop());
            }
        }

        return salida.peek();
    }

    public boolean isEmpty() {
        return entrada.isEmpty() && salida.isEmpty();
    }

    public int size() {
        return entrada.size() + salida.size();
    }
}


