package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

public record dadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,
                                  DadosEndereco endereco ) {
}

/**
 * https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3
 */