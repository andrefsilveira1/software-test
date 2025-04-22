package param;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculoImpostoDeRendaTest {
    @ParameterizedTest
    @CsvSource({
            "1000, 0.0",
            "1201, 120.1",     // 10%
            "3000, 300.0",     // 10%
            "5000, 500.0",     // 10%
            "5001, 750.15",    // 15%
            "8000, 1200.0",    // 15%
            "10000, 1500.0",   // 15%
            "10001, 2000.2",   // 20%
            "20000, 4000.0"    // 20%
    })
    void testCalculoImposto(double valorCompra, double esperado) {
        assertEquals(esperado, CalculoImpostoRenda.calculaImposto(valorCompra), 0.001);
        // Alguns testes estavam falhando com o double. Por isso, adicionei o threshold de 0.001
    }
}