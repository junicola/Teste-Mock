package ex05;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class SomatoriaTeste {
    
    public SomatoriaTeste() {
    }

    @Test
    public void teste5e10() {
        Primo primoMock = mock(Primo.class);
        MathOps mathMock = mock(MathOps.class);
        when(primoMock.ehPrimo(5)).thenReturn(true);
        when(primoMock.ehPrimo(10)).thenReturn(false); 
        when(mathMock.fatorial(10)).thenReturn(3628800);
                
        
        Somatoria somatoria = new Somatoria(mathMock);
        int v[] = {5,10};
        assertEquals(3628800, somatoria.somaDeFatoriais(v, primoMock));
       
    }
    
    @Test
    public void teste3e4e4e5() {
        Primo primoMock = mock(Primo.class);
        MathOps mathMock = mock(MathOps.class);
        when(primoMock.ehPrimo(3)).thenReturn(true);
        when(primoMock.ehPrimo(4)).thenReturn(false); 
        when(primoMock.ehPrimo(5)).thenReturn(true); 
        when(mathMock.fatorial(4)).thenReturn(24);
                
        
        Somatoria somatoria = new Somatoria(mathMock);
        int v[] = {3,4,4,5};
        assertEquals(48, somatoria.somaDeFatoriais(v, primoMock));
       
    }
}
