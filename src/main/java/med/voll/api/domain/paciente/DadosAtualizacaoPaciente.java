package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.DadosEndereco;

import javax.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}


/**
 * Dados que podem ser atualizados
 * Nome
 * Telefone
 * Endereço
 * Não permitir a alteração do e-mail do paciente;
 * Não permitir a alteração do CPF do paciente.
 */