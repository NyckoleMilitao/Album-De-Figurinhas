package com.prj.albumdefigurinhas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.prj.albumdefigurinhas.controller"))
            .paths( PathSelectors.any())
            .build()
            .useDefaultResponseMessages(true)
            .apiInfo(apiInfo());

            
    }


    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("iLab UP")
                .description("1. Resumo" + //
                                        "Neste sistema é possível realizar operações específicas de acordo com o perfil do usuário: Administrador, Autor e Colecionador." + //
                                        
                                        "Perfis e Funcionalidades:\r\n" + //
                                        "Administrador: Responsável unicamente pelo gerenciamento dos usuários.\r\n" + //
                                        "\r\n" + //
                                        "Após login, verá uma tela com a listagem dos usuários.\r\n" + //
                                        "Possível realizar inclusão, exclusão, edição e filtro dos usuários.\r\n" + //
                                        "Para incluir e editar, será mostrado uma tela para cadastrar nome, senha e perfil (todos campos obrigatórios).\r\n" + //
                                        "Pode zerar a senha do usuário, gerando uma senha padrão (ex: 123456 ou o próprio nome).\r\n" + //
                                        "Autor: Responsável por criar/gerenciar o único álbum da aplicação.\r\n" + //
                                        "\r\n" + //
                                        "Após login, verá a tela do álbum, onde todas as figurinhas cadastradas serão apresentadas.\r\n" + //
                                        "Possível inserir, excluir, editar e filtrar figurinhas.\r\n" + //
                                        "Ao inserir ou editar, será levado à tela de figurinha para preencher ou alterar dados (nome, número, descrição, página, tag, foto).\r\n" + //
                                        "Colecionador: Usuário do álbum, pode visualizar páginas do álbum e figurinhas de cada página.\r\n" + //
                                        "\r\n" + //
                                        "Para ter mais detalhes de uma figurinha, basta dar um duplo clique na figurinha desejada para que sejam mostradas todas as informações e a imagem.\r\n" + //
                                        "A tela de login é comum a todos os usuários e solicita nome e senha.\r\n" + //
                                        "\r\n" + //
                                        "2. Tecnologias Utilizadas\r\n" + //
                                        "Maven: Gerenciamento de dependências e build do projeto.\r\n" + //
                                        "Spring Boot: Framework para criação de aplicações Java com configuração mínima.")

                        .version("1.0.0")
                        .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0%22")
                .termsOfServiceUrl("/service.html")
                
                .build();
        return apiInfo;

    }
}