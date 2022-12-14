package ilab.projeto.up.ilab.up.config;



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
            .apis(RequestHandlerSelectors.basePackage("ilab.projeto.up.ilab.up.controller"))
            .paths( PathSelectors.any())
            .build()
            .useDefaultResponseMessages(true)
            .apiInfo(apiInfo());

            
    }


    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("iLab UP")
                .description("Essa foi a API desenvolvida para projeto aplicado da Residência em TIC/Software do Serratec, \n"
                		+ "para desenvolvimento do Sistema iLab Up.\n\n"

                		+ "Desenvolvedores: Gilnei Lima, Nyckole Militão.\n\n"
                        + "Aconselhamos o seguinte passo a passo ao utilizar a API:\n"
                        + "1) Cadastrar primeiro uma COLABORADOR; \n"
                        + "2) Cadastrar um PAPEL(FUNÇÃO); \n"
                        + "3) Cadastrar um CLIENTE; \n"
                        + "4) Cadastrar um CONTRATO; \n"
                        + "5) Cadastrar uma NOTA FISCAL; \n"
                        + "6) Alimentar através de arquivo de planilha EXCEL a informações do relacionamento entre colaboradores e contratos.")

                        .version("1.0.0")
                        .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0%22")
                .termsOfServiceUrl("/service.html")
                
                .build();
        return apiInfo;
    
    }

}