package ejercicioExamen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	@Test
	void testNotaModulo_TodoCorrecto() {
	    // creo mi módulo
	    Modulo moduloATestear = new Modulo("Matemáticas", Arrays.asList(7.0, 8.0), Arrays.asList(6.0, 5.0));

	    // expected
	    double expected = 7.5 * 0.6 + 5.5 * 0.4; // 4.5 + 2.2 = 6.7

	    // actual
	    double actual = moduloATestear.calcularNotaModulo();

	    // asserts
	    assertEquals(expected, actual, 0.001, "Está mal, la nota del módulo debería ser 6.7");
	}

	@Test
	void testNotaModulo_EntregableFaltante() {
	    // creo mi módulo
	    Modulo moduloATestear = new Modulo("Historia", Arrays.asList(7.0, -1.0), Arrays.asList(6.0, 5.0));

	    // expected
	    double expected = 0;

	    // actual
	    double actual = moduloATestear.calcularNotaModulo();

	    // asserts
	    assertEquals(expected, actual, "Está mal, si falta un entregable la nota debe ser 0");
	}

	@Test
	void testNotaModulo_ExamenFaltante() {
	    // creo mi módulo
	    Modulo moduloATestear = new Modulo("Lengua", Arrays.asList(7.0, 8.0), Arrays.asList(-1.0, 5.0));

	    // expected
	    double expected = 0;

	    // actual
	    double actual = moduloATestear.calcularNotaModulo();

	    // asserts
	    assertEquals(expected, actual, "Está mal, si falta un examen la nota debe ser 0");
	}

	@Test
	void testNotaModulo_ExamenBajo4() {
	    // creo mi módulo
	    Modulo moduloATestear = new Modulo("Física", Arrays.asList(7.0, 8.0), Arrays.asList(3.0, 6.0));

	    // expected
	    double expected = 3.0;

	    // actual
	    double actual = moduloATestear.calcularNotaModulo();

	    // asserts
	    assertEquals(expected, actual, "Está mal, si hay un examen menor de 4 se debe devolver esa nota");
	}

}
