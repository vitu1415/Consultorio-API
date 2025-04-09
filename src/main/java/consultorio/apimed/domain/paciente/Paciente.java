package consultorio.apimed.domain.paciente;

import consultorio.apimed.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastradoPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosAtualizadosPaciente dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarIndormcoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
