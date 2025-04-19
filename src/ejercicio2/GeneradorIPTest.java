package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeneradorIPTest {

	@Test
	void testGenerarNumero() {
		
		//creo el generador
        GeneradorIP generador = new GeneradorIP();

        //repetimos 1000 veces para probar aleatoriedad
        for (int i = 0; i < 1000; i++) {

            //expected: entre 0 y 254
            int min = 0;
            int max = 254;

            //actual
            int resultado = generador.generarNumero(min, max);

            //asserts
            assertTrue(resultado >= min, "Error: el número generado es menor que el mínimo permitido (" + resultado + " < " + min + ")");
            assertTrue(resultado <= max, "Error: el número generado es mayor que el máximo permitido (" + resultado + " > " + max + ")");
        }
        
	}

	@Test
	void testGenerarIPV4() {
		
		//creo el generador
        GeneradorIP generador = new GeneradorIP();

        //repetimos 1000 veces para probar IPs generadas
        for (int i = 0; i < 1000; i++) {

            //actual
            String ip = generador.generarIPV4();
            String[] partes = ip.split("\\.");

            //expected: 4 partes
            int expectedLongitud = 4;

            //asserts
            assertEquals(expectedLongitud, partes.length, "Error: la IP generada no tiene 4 partes -> " + ip);

            int n1 = Integer.parseInt(partes[0]);
            int n2 = Integer.parseInt(partes[1]);
            int n3 = Integer.parseInt(partes[2]);
            int n4 = Integer.parseInt(partes[3]);

            assertTrue(n1 >= 1 && n1 <= 254, "Error: primera parte fuera de rango (1-254): " + n1 + " en IP " + ip);
            assertTrue(n2 >= 0 && n2 <= 254, "Error: segunda parte fuera de rango (0-254): " + n2 + " en IP " + ip);
            assertTrue(n3 >= 0 && n3 <= 254, "Error: tercera parte fuera de rango (0-254): " + n3 + " en IP " + ip);
            assertTrue(n4 >= 1 && n4 <= 254, "Error: cuarta parte fuera de rango (1-254): " + n4 + " en IP " + ip);
        }
	}
	}


