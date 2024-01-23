package co.edu.uniquindio.proyecto_isw3.modelo;

public enum Grupo {

    D_1(0),
    D_2(1),
    D_3(2),
    N_1(3),
    N_2(4);

    private int codigo;

    Grupo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }
}
