package clinix.com.clinix_sistema_usuarios;

import clinix.com.clinix_sistema_usuarios.model.Paciente;
import clinix.com.clinix_sistema_usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteCrudTest {

    @Mock
    private UsuarioRepository usuarioRepository; // Simula o repositório

    @InjectMocks
    private Paciente paciente; // Instância do paciente

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa mocks
    }

    @Test
    void deveCadastrarPacienteComSucesso() {
        // 1️⃣ Criando um paciente com dados fictícios
        Paciente novoPaciente = new Paciente(
                "João Silva",
                "joaosilva",
                "joao@email.com",
                "senha123",
                "123.456.789-00",
                "MG-12.345.678"
        );

        // 2️⃣ Simulando o comportamento do repositório (Mock)
        when(usuarioRepository.save(novoPaciente)).thenReturn(novoPaciente);

        // 3️⃣ Salvando o paciente
        Paciente pacienteSalvo = usuarioRepository.save(novoPaciente);

        // 4️⃣ Verificando se o paciente foi salvo corretamente
        assertNotNull(pacienteSalvo);
        assertEquals("João Silva", pacienteSalvo.getNome());
        assertEquals("joaosilva", pacienteSalvo.getNomeUsuario());
        assertEquals("joao@email.com", pacienteSalvo.getEmail());
        assertEquals("123.456.789-00", pacienteSalvo.getCpf());
        assertEquals("MG-12.345.678", pacienteSalvo.getRg());

        // 5️⃣ Verificando se o método `save` foi chamado
        verify(usuarioRepository, times(1)).save(novoPaciente);
    }
}

