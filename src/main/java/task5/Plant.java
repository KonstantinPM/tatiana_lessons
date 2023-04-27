package task5;

public class Plant {
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws TypeException, ColorException {

        try {
            this.type = Type.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new TypeException("Invalid plant type: " + type);
        }

        try {
            this.color = Color.valueOf(color);
        } catch (IllegalArgumentException e) {
            throw new ColorException("Invalid plant color: " + color);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{type: " + type + ", color: " + color + ", name: " + name + "}";
    }
}

enum Color {
    White, Red, Blue
}

enum Type {
    Rare, Ordinary
}

class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}
class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}
