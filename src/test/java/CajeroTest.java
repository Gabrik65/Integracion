import org.example.Cajero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CajeroTest {

    @BeforeEach
    void setUp() {
        Cajero.reiniciarSaldo(); // Restablece el saldo antes de cada test
    }

    @Test
    void testRetiroValido() {
        Cajero.retirar(10000);
        assertEquals(90000, Cajero.obtenerSaldo());
    }

    @Test
    void testRetiroMontoNegativo() {
        assertFalse(Cajero.masque0(-5000));
    }

    @Test
    void testRetiroExcedeSaldo() {
        assertFalse(Cajero.montocomparasaldo(200000));
    }

    @Test
    void testRetiroNoMultiploDeMil() {
        assertFalse(Cajero.multiplo1000(1234));
    }

    @Test
    void testRetiroExactoTotalDisponible() {
        Cajero.retirar(100000);
        assertEquals(0, Cajero.obtenerSaldo());
    }

    @Test
    void testConsultarSaldo() {
        assertEquals(100000, Cajero.obtenerSaldo());
    }

    @Test
    void testDepositoValido() {
        Cajero.depositar(5000);
        assertEquals(105000, Cajero.obtenerSaldo());
    }

    @Test
    void testDepositoNegativo() {
        assertFalse(Cajero.masque0(-3000));
    }

    @Test
    void testDepositoNoMultiplo() {
        assertFalse(Cajero.multiplo1000(3333));
    }

}
