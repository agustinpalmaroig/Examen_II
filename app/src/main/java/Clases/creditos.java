package Clases;

public class creditos {
    // Declaración de datos.

    private int hipotecario;
    private int automotriz;

    // Constructor

    public creditos()
    {
        hipotecario = 1000000;
        automotriz = 500000;
    }

    // Accesadores

    public int getHipotecario()
    {
        return hipotecario;
    }

    public int getAutomotriz()
    {
        return automotriz;
    }
}
