package consultorio.apimed.domain.consulta.validacoes;

import consultorio.apimed.domain.ValidacaoException;
import consultorio.apimed.domain.consulta.Consulta;
import consultorio.apimed.domain.consulta.ConsultaRepository;
import consultorio.apimed.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsulta implements ValidadoragendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico ja possui outra consulta agendada nesse emsmo horário");
        }
    }
}