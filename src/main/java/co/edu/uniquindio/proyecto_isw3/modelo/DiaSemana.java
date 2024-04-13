package co.edu.uniquindio.proyecto_isw3.modelo;

public enum DiaSemana {
    LUNES(0),
    MARTES(1),
    MIERCOLES(2),
    JUEVES(3),
    VIERNES(4),
    SABADO(5);

    private int id;

    DiaSemana(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
