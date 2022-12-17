package med.voll.api.domain.paciente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record DadosCadastroPaciente(


        @NotBlank
        String nome,
         @NotBlank
         @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,
        DadosEndereco endereco  ) {
}

/*
Todas as informações são de preenchimento obrigatório, exceto o número e o complemento do endereço.
 */