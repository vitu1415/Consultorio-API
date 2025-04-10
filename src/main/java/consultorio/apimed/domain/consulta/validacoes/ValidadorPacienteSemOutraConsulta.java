package consultorio.apimed.domain.consulta.validacoes;

import consultorio.apimed.domain.ValidacaoException;
import consultorio.apimed.domain.consulta.ConsultaRepository;
import consultorio.apimed.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsulta implements ValidadoragendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacienteSemOutraConsulta = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (pacienteSemOutraConsulta) {
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}
