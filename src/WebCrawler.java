public class WebCrawler {

    private Pila<String> pila;
    private Fila<String> fila;

    public WebCrawler(Pila<String> pila, Fila<String> fila) {
        this.pila = pila;
        this.fila = fila;
    }


    public boolean esXHTMLValido(String xhtml) {
        if (xhtml.indexOf("<!DOCTYPE>") == -1) {
            return false;
        }
        if (xhtml.indexOf("<html xmlns") == -1) {
            return false;
        }
        while (!pila.isEmpty()) {
            pila.pop();
        }

        int i = 0;
        while (i < xhtml.length()) {
            int inicioTag = xhtml.indexOf('<', i);
            if (inicioTag == -1) {
                break;
            }

            int finTag = xhtml.indexOf('>', inicioTag);
            if (finTag == -1) {
                break;
            }

            String tag = xhtml.substring(inicioTag + 1, finTag);
            tag = tag.trim();

            if (tag.startsWith("!")) {
                i = finTag + 1;
                continue;
            }

            String nombreTag = tag.split(" ")[0];

            if (!nombreTag.equals(nombreTag.toLowerCase())) {
                return false;
            }

            if (nombreTag.startsWith("/")) {
                if (pila.isEmpty()) {
                    return false;
                }

                String ultimoAbierto = pila.pop();
                String cierreSinDiagonal = nombreTag.substring(1);

                if (!ultimoAbierto.equals(cierreSinDiagonal)) {
                    return false;
                }

            } else {
                pila.push(nombreTag);
            }

            i = finTag + 1;
        }
        return pila.isEmpty();
    }


}