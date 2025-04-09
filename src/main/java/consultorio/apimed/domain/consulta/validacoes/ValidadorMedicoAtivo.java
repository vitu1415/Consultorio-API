package consultorio.apimed.domain.consulta.validacoes;

import consultorio.apimed.domain.ValidacaoException;
import consultorio.apimed.domain.consulta.DadosAgendamentoConsulta;
import consultorio.apimed.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorMedicoAtivo {

    @Autowired
    MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados){
        if(dados.idMedico() == null){
            return;
        }

        var dadosMedico = medicoRepository.findById(dados.idMedico());
        if(dadosMedico.isEmpty()){
            throw new ValidacaoException("O medico nao encontrado");
        }
        var verificarAtivo = dadosMedico.get();
        if(!verificarAtivo.getAtivo()){
            throw new ValidacaoException("Medico precisa estar ativo para agendar consulta");
        }
    }
}
