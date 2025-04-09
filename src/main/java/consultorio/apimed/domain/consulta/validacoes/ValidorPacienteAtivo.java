package consultorio.apimed.domain.consulta.validacoes;

import consultorio.apimed.domain.ValidacaoException;
import consultorio.apimed.domain.consulta.DadosAgendamentoConsulta;
import consultorio.apimed.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidorPacienteAtivo {

    @Autowired
    PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var dadosPaciente = pacienteRepository.findById(dados.idPaciente());

        if (dadosPaciente.isEmpty()){
            throw new ValidacaoException("Pacinete nao encontrado");
        }

        var verificarAtivo = dadosPaciente.get();

        if(!verificarAtivo.getAtivo()){
            throw  new ValidacaoException("Tem que ser um usuario ativo par amarcar consulta");
        }
    }
}
