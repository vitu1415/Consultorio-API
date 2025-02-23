package consultorio.apimed.paciente;

import consultorio.apimed.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosPaciente(

        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco) {
}
