package med.voll.api.controller;

import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import med.voll.api.medico.dadosCadastroMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;
	
	@PostMapping()
	@Transactional
	public void cadastrar(@RequestBody  @Valid dadosCadastroMedico dados) {

		repository.save(new Medico(dados));

	}

	@GetMapping
	public Page<DadosListagemMedico> listar(Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemMedico::new);
	}

}
