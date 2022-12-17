package med.voll.api.domain.medico;

public record DadosListagemMedico(Long id, String nome, String email, String rcm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }

}

//Informando apenas os dados que devem retorna aplicação