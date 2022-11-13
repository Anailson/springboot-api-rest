package med.voll.api.endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")//Expressão regular Cep com 8 digitos
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento,
        String numero) {
}


/**
 * Consulta sobre a utilização do record no java
 * https://www.guiadojava.com.br/2021/04/java-records.html
 * https://docs.oracle.com/en/java/javase/16/language/records.html
 * o RECORD É SIMILAR AO DTO. PORÉM COM MENOS ATRIBUTOS
 */