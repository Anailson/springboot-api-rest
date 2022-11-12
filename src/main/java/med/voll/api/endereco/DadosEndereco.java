package med.voll.api.endereco;

public record DadosEndereco(String logradouro, String bairro, String cep, String cidade, String uf,
                            String complemento, String numero) {
}


/**
 * Consulta sobre a utilização do record no java
 * https://www.guiadojava.com.br/2021/04/java-records.html
 * https://docs.oracle.com/en/java/javase/16/language/records.html
 * o RECORD É SIMILAR AO DTO. PORÉM COM MENOS ATRIBUTOS
 */