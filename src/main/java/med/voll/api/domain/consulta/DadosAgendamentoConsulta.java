package med.voll.api.domain.consulta;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(


        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future //data no futuro
        LocalDateTime data) {

}
