package consultorio.apimed.paciente;

import consultorio.apimed.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastradoPaciente (

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotNull @Valid
        DadosEndereco endereco){

}