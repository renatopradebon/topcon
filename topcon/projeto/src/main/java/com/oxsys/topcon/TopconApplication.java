package com.oxsys.topcon;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.oxsys.topcon.model.Contato;
import com.oxsys.topcon.model.Contrado;
import com.oxsys.topcon.model.Pessoa;
import com.oxsys.topcon.model.Unidade;
import com.oxsys.topcon.model.Usuario;
import com.oxsys.topcon.model.Vaga;
import com.oxsys.topcon.model.enums.ContatoTipo;
import com.oxsys.topcon.model.enums.ContratoTipo;
import com.oxsys.topcon.model.enums.PessoaSituacao;
import com.oxsys.topcon.model.enums.Sexo;
import com.oxsys.topcon.model.enums.UnidadeTipo;
import com.oxsys.topcon.model.enums.UsuarioSituacao;
import com.oxsys.topcon.model.enums.UsuarioTipo;
import com.oxsys.topcon.repository.ContatoRepository;
import com.oxsys.topcon.repository.ContratoRepository;
import com.oxsys.topcon.repository.PessoaRepository;
import com.oxsys.topcon.repository.UnidadeRepository;
import com.oxsys.topcon.repository.UsuarioRepository;
import com.oxsys.topcon.repository.VagaRepository;

@SpringBootApplication
public class TopconApplication {

	@Autowired
	PessoaRepository repoPessoa;
	
	@Autowired
	UnidadeRepository repoUnidade;
	
	@Autowired
	VagaRepository repoVaga;
	
	@Autowired
	ContratoRepository repoContrato;
	
	@Autowired
	ContatoRepository repoContato;
	
	@Autowired
	UsuarioRepository repoUsuario;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(TopconApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		for(long i=1 ; i<=10; i++){
			
			Pessoa p = new Pessoa(i,"Pessoa-"+i,PessoaSituacao.ATIVA,Sexo.MASCULINO,new Date());
			repoPessoa.save(p);
			
			Contato c = new Contato(0,"Contato",ContatoTipo.AMIGO,"9999-000"+i,"email@com",p);
			repoContato.save(c);
		
			Unidade u = new Unidade(i,UnidadeTipo.APARTAMENTO,"Q."+i,"BL."+i,"Rua "+i,"1","1",i,null);
			repoUnidade.save(u);
			
			Vaga v = new Vaga(i,u,Long.toString(i));
			repoVaga.save(v);
			
			
			Contrado ctr = new Contrado(i,"201-11-01-"+i, ContratoTipo.ALUGUEL , new Date(), new Date(), p, p, u);
			repoContrato.save(ctr);
			
			Usuario usu = new Usuario("usuario-"+i,"usuario-"+i,"123",UsuarioSituacao.ATIVO,UsuarioTipo.USER);
			repoUsuario.save(usu);
			
			
		}
			
		
	}
}
