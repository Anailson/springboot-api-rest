package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){

        //Ser não tem paciente com id (não cadastrado)
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw  new ValidacaoException("Id do paciente informado não existe!!");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw  new ValidacaoException("Id do médico informado não existe!!");
        }

        //pecorrendo a lista de validadores
        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository .getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        if(medico == null){
            throw  new ValidacaoException("Não existe médico disponível nessa data!!");
        }
        var consulta = new Consulta(null , medico, paciente, dados.data());
        consultaRepository.save(consulta);

        return  new DadosDetalhamentoConsulta(consulta);

    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

        if(dados.idMedico() != null){
            return  medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade()== null){
            throw  new ValidacaoException("Especialidade é obrigatória quando o médico não for escolhido");

        }

        return  medicoRepository.escolherMedicoAlealtorioLivreNaData(dados.especialidade(),dados.data());


    }

}


/*
Regras de negócio do agendamento
 */