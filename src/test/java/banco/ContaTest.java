package banco;
import static org.junit.Assert.*;
import org.junit.Test;
/*
 * Exercício - Introducao ao JUnit
 *
 * Descomentar o teste, ver o teste falar e fazer
 * a mudança necessária para o teste passar.
 *
 */

public class ContaTest {

    @Test
    public void testSendValidValue() throws OperacaoIlegalException {
        Conta source = new Conta("1", 1000);
        Conta receiver = new Conta("2", 500);
        source.transferir(receiver, 200);

        assertEquals(800, source.getSaldo(), 0.01);
        assertEquals(700, receiver.getSaldo(), 0.01);
    }

    @Test(expected = OperacaoIlegalException.class)
    public void testSendInvalidValue() throws OperacaoIlegalException {
        Conta source = new Conta("1", 100);
        Conta receiver = new Conta("2", 500);
        source.transferir(receiver, 200);
    }

    @Test(expected = OperacaoIlegalException.class)
    public void testSendNegativeValue() throws OperacaoIlegalException {
        Conta source = new Conta("1", 100);
        Conta receiver = new Conta("2", 500);
        source.transferir(receiver, -111);
    }

    @Test(expected = OperacaoIlegalException.class)
    public void testSendInvalidAccount() throws OperacaoIlegalException {
        Conta source = new Conta("1", 100);
        Conta receiver = new Conta("2", 500);
        source.transferir(source, 100);
    }



}
