package consultorio.apimed.domain.consulta.validacoes;

import consultorio.apimed.domain.ValidacaoException;
import consultorio.apimed.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadedoHorarioAntecedencia implements ValidadoragendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedencia minima de 30 minutos");
        }
    }
}
