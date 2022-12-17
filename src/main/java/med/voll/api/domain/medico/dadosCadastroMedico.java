package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record dadosCadastroMedico(

        Long id,
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //Expressão regular que valida o CRM de 4 a 6 digitos
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco ) {
}

/**
 * https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3
 */

/**Validação
 * https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints
 */