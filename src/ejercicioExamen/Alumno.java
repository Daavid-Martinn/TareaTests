package ejercicioExamen;

import java.util.List;
import java.util.regex.Pattern;

public class Alumno {

	private String nombre;
    private String email;
    private List<Modulo> modulos;

    public Alumno(String nombre, String email, List<Modulo> modulos) throws Exception {
        if (!esEmailValido(email)) {
            throw new Exception("Email inválido: " + email);
        }
        this.nombre = nombre;
        this.email = email;
        this.modulos = modulos;
    }

    private boolean esEmailValido(String email) {
        String regex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, email);
    }

    public boolean apruebaCurso() {
        if (modulos == null || modulos.isEmpty()) {
            return true;
        }

        for (Modulo m : modulos) {
            if (m.calcularNotaModulo() <= 5) {
                return false;
            }
        }
        return true;
    }

}
