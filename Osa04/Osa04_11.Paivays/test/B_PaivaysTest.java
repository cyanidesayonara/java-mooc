
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import static org.junit.Assert.*;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;

//@RunWith(PowerMockRunner.class)
@PrepareForTest({Paivays.class})
public class B_PaivaysTest {

    @Points("04-11.2")
    @Test
    public void parametrillinenMetodiEteneKutsuuParametritontaEteneMetodia() {
        Class c = Paivays.class;
        String metodi = "etene";
        String virhe = "Tee luokalle Paivays metodi public void etene(int paivia)";
        int montakoPaivaaEteenpain = 3;

        Method parametritonEtene = null;
        try {
            parametritonEtene = ReflectionUtils.requireMethod(c, metodi);
        } catch (Throwable t) {
            fail(virhe);
        }

        Paivays mockPaivays = PowerMock.createMock(Paivays.class, parametritonEtene);

        try {
            parametritonEtene.invoke(mockPaivays);
        } catch (Throwable t) {
            fail(virhe + ", varmista myös että metodi on public.");
        }
        PowerMock.expectLastCall().times(montakoPaivaaEteenpain);

        PowerMock.replay(mockPaivays);

        Method parametrillinenEtene = null;
        try {
            parametrillinenEtene = ReflectionUtils.requireMethod(mockPaivays.getClass(), metodi, int.class);
        } catch (Throwable t) {
            fail("Varmista että kutsut metodia etene() metodista etene(int paivia). Tarkista myös että kutsukertojen määrä on oikea.");
        }
        try {
            parametrillinenEtene.invoke(mockPaivays, montakoPaivaaEteenpain);
        } catch (Throwable t) {
            fail("Varmista että kutsut metodia etene() metodista etene(int paivia). Tarkista myös että kutsukertojen määrä on oikea.");
        }

        try {
            PowerMock.verify(mockPaivays);
        } catch (Throwable t) {
            fail("Varmista että kutsut metodia etene() metodista etene(int paivia). Tarkista myös että kutsukertojen määrä on oikea." + t);
        }
    }
}
