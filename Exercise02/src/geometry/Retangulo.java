package geometry;

public class Retangulo implements Cloneable {

    private int x1, y1, x2, y2;

    // Construtor para criar um retângulo a partir de dois pontos
    public Retangulo(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        // Verifica se o retângulo é válido ao criar o objeto
        if (!isValidRectangle()) throw new IllegalArgumentException("Coordenadas inválidas para formar um retângulo.");
    }

    private boolean isValidRectangle() {
        return x1 < x2 && y1 < y2;
    }

    // Metodo que verifica se dois retângulos se intersectam
    public static boolean intersects(Retangulo r1, Retangulo r2) {
        // Verifica se um retângulo está à esquerda ou à direita do outro
        if (r1.x2 < r2.x1 || r2.x2 < r1.x1) return false;

        // Verifica se um retângulo está acima ou abaixo do outro
        return r1.y2 >= r2.y1 && r2.y2 >= r1.y1;
    }

    // Retorna a largura do retângulo
    public int getWidth() {
        return x2 - x1;
    }

    // Retorna a altura do retângulo
    public int getHeight() {
        return y2 - y1;
    }

    public boolean isPointInside(int x, int y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    // Getters
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }

    // Setters
    public void setX1(int x1) {
        this.x1 = x1;
        if (!isValidRectangle()) throw new IllegalArgumentException("Coordenadas inválidas para formar um retângulo.");
    }
    public void setY1(int y1) {
        this.y1 = y1;
        if (!isValidRectangle()) throw new IllegalArgumentException("Coordenadas inválidas para formar um retângulo.");
    }
    public void setX2(int x2) {
        this.x2 = x2;
        if (!isValidRectangle()) throw new IllegalArgumentException("Coordenadas inválidas para formar um retângulo.");
    }
    public void setY2(int y2) {
        this.y2 = y2;
        if (!isValidRectangle()) throw new IllegalArgumentException("Coordenadas inválidas para formar um retângulo.");
    }

    // Construtor de cópia
    public Retangulo(Retangulo outro) {
        if (outro == null) throw new IllegalArgumentException("O retângulo a ser copiado não pode ser nulo.");

        // Copia os valores dos atributos
        this.x1 = outro.getX1();
        this.y1 = outro.getY1();
        this.x2 = outro.getX2();
        this.y2 = outro.getY2();
    }

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Retangulo clone() {
        Retangulo clone = null;
        try {
            clone = new Retangulo(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = x1;

        hash *= prime * hash + y1;
        hash *= prime * hash + x2;
        hash *= prime * hash + y2;

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Retangulo that = (Retangulo) o;

        return this.x1 == that.x1 &&
               this.y1 == that.y1 &&
               this.x2 == that.x2 &&
               this.y2 == that.y2;
    }

    @Override
    public String toString() {
        return "Retangulo [(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")]";
    }
}
