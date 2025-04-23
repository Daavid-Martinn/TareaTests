package ejercicioExamen;
import java.util.List;
public class Modulo {

	private String nombre;
    private List<Double> entregables;
    private List<Double> examenes;

    public Modulo(String nombre, List<Double> entregables, List<Double> examenes) {
        this.nombre = nombre;
        this.entregables = entregables;
        this.examenes = examenes;
    }

    public double calcularNotaModulo() {
        // Verificar entregables
        for (Double nota : entregables) {
            if (nota == -1) {
                return 0;
            }
        }

        // Verificar exámenes
        for (Double nota : examenes) {
            if (nota == -1) {
                return 0;
            }
        }

        // Verificar si hay alguna nota de examen menor a 4
        for (Double nota : examenes) {
            if (nota < 4) {
                return nota; // devuelve la menor nota
            }
        }

        // Calcular media
        double mediaEntregables = entregables.stream().mapToDouble(n -> n).average().orElse(0);
        double mediaExamenes = examenes.stream().mapToDouble(n -> n).average().orElse(0);

        return mediaEntregables * 0.6 + mediaExamenes * 0.4;
    }

}
