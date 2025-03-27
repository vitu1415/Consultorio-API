package consultorio.apimed.domain.medico;

import consultorio.apimed.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMadico(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
