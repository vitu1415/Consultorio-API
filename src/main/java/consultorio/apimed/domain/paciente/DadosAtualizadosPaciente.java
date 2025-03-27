package consultorio.apimed.domain.paciente;

import consultorio.apimed.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosPaciente(

        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco) {
}
