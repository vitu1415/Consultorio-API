package consultorio.apimed.medico;

import consultorio.apimed.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMadico(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
