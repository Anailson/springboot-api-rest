package med.voll.api.medico;

public record DadosListagemMedico(String nome, String email, String rcm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }

}

//Informando apenas os dados que devem retorna aplicação