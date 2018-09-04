package ex06;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class RelatorioTeste {
    
    public RelatorioTeste() {
    }

    @Test
    public void teste2FuncCPFNaoBloqueadoCategoriaTecnico() {
        FuncionarioDAO funcDAOMock = mock(FuncionarioDAO.class);
        ReceitaFederal receitaMock = mock(ReceitaFederal.class);              
        ArrayList<Funcionario> f = new ArrayList<>();        

        f.add(new Funcionario(1, "Samira Close","27483847652"));
        f.add(new Funcionario(2, "Agata Feroz","27483847652"));
        when(funcDAOMock.getFuncionariosBy("tecnico")).thenReturn(f);
        when(receitaMock.isCPFBloqueado(any())).thenReturn(false);
        
        RelatorioDeFuncionarios relatorio = new RelatorioDeFuncionarios(funcDAOMock);
        relatorio.setRf(receitaMock);
        assertEquals(0, relatorio.getFuncComCPFBloqueado("tecnico"));
        
    }
    
    @Test
    public void teste1FuncCPFBloqueadoCategoriaAnalista() {
        FuncionarioDAO funcDAOMock = mock(FuncionarioDAO.class);
        ReceitaFederal receitaMock = mock(ReceitaFederal.class);              
        ArrayList<Funcionario> f = new ArrayList<>();        

        f.add(new Funcionario(1, "Lindsayyy","29475793965"));
        when(funcDAOMock.getFuncionariosBy("analista")).thenReturn(f);
        when(receitaMock.isCPFBloqueado(any())).thenReturn(true);
        
        RelatorioDeFuncionarios relatorio = new RelatorioDeFuncionarios(funcDAOMock);
        relatorio.setRf(receitaMock);
        assertEquals(1, relatorio.getFuncComCPFBloqueado("analista"));
        
    }
    
    @Test
    public void teste2FuncCPFBloqueadoCategoriaGerente() {
        FuncionarioDAO funcDAOMock = mock(FuncionarioDAO.class);
        ReceitaFederal receitaMock = mock(ReceitaFederal.class);              
        ArrayList<Funcionario> f = new ArrayList<>();        

        f.add(new Funcionario(1, "Wenner","123456789-00"));
        f.add(new Funcionario(2, "Clebinho","111222333-44"));
        f.add(new Funcionario(3, "Rudinei","654321987-23"));
        f.add(new Funcionario(4, "Vando","098876654-99"));
        when(funcDAOMock.getFuncionariosBy("gerente")).thenReturn(f);
        when(receitaMock.isCPFBloqueado("123456789-00")).thenReturn(false);
        when(receitaMock.isCPFBloqueado("654321987-23")).thenReturn(false);
        when(receitaMock.isCPFBloqueado("111222333-44")).thenReturn(true);
        when(receitaMock.isCPFBloqueado("098876654-99")).thenReturn(true);
        
        RelatorioDeFuncionarios relatorio = new RelatorioDeFuncionarios(funcDAOMock);
        relatorio.setRf(receitaMock);
        assertEquals(2, relatorio.getFuncComCPFBloqueado("gerente"));
        
    }
    
          
        
        
        
}
