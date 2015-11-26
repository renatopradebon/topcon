package com.oxsys.topcon;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.oxsys.topcon.model.Contato;
import com.oxsys.topcon.model.Contrato;
import com.oxsys.topcon.model.Pessoa;
import com.oxsys.topcon.model.Unidade;
import com.oxsys.topcon.model.Vaga;

@Configuration
public class RepositoryConfig extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Contato.class);
        config.exposeIdsFor(Contrato.class);
        config.exposeIdsFor(Pessoa.class);
        config.exposeIdsFor(Unidade.class);
        config.exposeIdsFor(Vaga.class);
    }
    

}