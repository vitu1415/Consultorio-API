package consultorio.apimed.domain.paciente;

public record DadosListaPaciente(Long id, String nome, String email) {

    public DadosListaPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail());
    }
}
