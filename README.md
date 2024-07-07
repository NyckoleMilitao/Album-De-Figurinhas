# Sistema de Gerenciamento de Usuários e Álbum de Figurinhas

## 1. Resumo

Neste sistema é possível realizar operações específicas de acordo com o perfil do usuário: Administrador, Autor e Colecionador.

### Perfis e Funcionalidades:

- **Administrador**: Responsável unicamente pelo gerenciamento dos usuários.
  - Após login, verá uma tela com a listagem dos usuários.
  - Possível realizar inclusão, exclusão, edição e filtro dos usuários.
  - Para incluir e editar, será mostrado uma tela para cadastrar nome, senha e perfil (todos campos obrigatórios).
  - Pode zerar a senha do usuário, gerando uma senha padrão (ex: 123456 ou o próprio nome).

- **Autor**: Responsável por criar/gerenciar o único álbum da aplicação.
  - Após login, verá a tela do álbum, onde todas as figurinhas cadastradas serão apresentadas.
  - Possível inserir, excluir, editar e filtrar figurinhas.
  - Ao inserir ou editar, será levado à tela de figurinha para preencher ou alterar dados (nome, número, descrição, página, tag, foto).

- **Colecionador**: Usuário do álbum, pode visualizar páginas do álbum e figurinhas de cada página.
  - Para ter mais detalhes de uma figurinha, basta dar um duplo clique na figurinha desejada para que sejam mostradas todas as informações e a imagem.

A tela de login é comum a todos os usuários e solicita nome e senha.

## 2. Tecnologias Utilizadas

- **Maven**: Gerenciamento de dependências e build do projeto.
- **Spring Boot**: Framework para criação de aplicações Java com configuração mínima.

## 3. Configuração do Backend

### Dependências Necessárias

Adicione as seguintes dependências ao seu `pom.xml`:

```xml
<dependencies>
    <!-- Dependências do Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- Dependência do banco de dados H2 -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Dependência do SQLite -->
    <dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Dependências do Spring Boot DevTools para desenvolvimento -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</artifactId>
    </dependency>

    <!-- Dependências para testes -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

## Configuração do Banco de Dados
No arquivo application.properties, configure o banco de dados:

spring.datasource.url=jdbc:sqlite:C:/caminho/para/seu/BancoTeste.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.database-platform=org.hibernate.dialect.SQLiteDialect
spring.jpa.show-sql=true
spring.h2.console.enabled=true

## Controlador de Login

@RestController
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Optional<UsuarioResponseDTO> usuarioOptional = usuarioService.obterUsuarioPorNome(usuario.getNome());

        if (usuarioOptional.isPresent()) {
            UsuarioResponseDTO usuarioEncontrado = usuarioOptional.get();
            if (usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
                Perfil perfilUsuario = usuarioEncontrado.getPerfil();
                switch (perfilUsuario) {
                    case ADMINISTRADOR:
                        return ResponseEntity.ok("Login realizado com sucesso para: " + usuarioEncontrado.getNome() + ". Redirecionando para a área de Administrador.");
                    case AUTOR:
                        return ResponseEntity.ok("Login realizado com sucesso para: " + usuarioEncontrado.getNome() + ". Redirecionando para a área de Autor.");
                    case COLECIONADOR:
                        return ResponseEntity.ok("Login realizado com sucesso para: " + usuarioEncontrado.getNome() + ". Redirecionando para a área de Colecionador.");
                    default:
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Perfil não autorizado");
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }
}


# 4. Configuração do Frontend
## Estrutura HTML Básica
Crie um arquivo index.html com o seguinte conteúdo:

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form id="loginForm">
            <label for="username">Usuário:</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Senha:</label>
            <input type="password" id="password" name="password" required>
            <button type="submit">Entrar</button>
        </form>
        <p id="loginStatus"></p>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="scripts.js"></script>
</body>
</html>

## Estilos CSS Básicos
Crie um arquivo styles.css com o seguinte conteúdo:

body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.login-container {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
    text-align: center;
}

form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

label {
    margin-bottom: 5px;
}

input {
    width: 100%;
    padding: 8px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}


## Scripts JavaScript
Crie um arquivo scripts.js com o seguinte conteúdo:

$(document).ready(function() {
    $('#loginForm').submit(function(event) {
        event.preventDefault();

        var formData = {
            nome: $('#username').val(),
            senha: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/login',
            data: JSON.stringify(formData),
            dataType: 'text',
            success: function(response) {
                $('#loginStatus').html(response);
                if (response.includes('Login realizado com sucesso')) {
                    setTimeout(function() {
                        window.location.href = determineRedirectURL(formData.nome);
                    }, 1000);
                }
            },
            error: function(xhr, status, error) {
                $('#loginStatus').html('Erro ao realizar login: ' + xhr.responseText);
            }
        });
    });

    function determineRedirectURL(username) {
        switch (username) {
            case 'admin':
                return '/admin/dashboard';
            case 'autor':
                return '/autor/dashboard';
            case 'colecionador':
                return '/colecionador/dashboard';
            default:
                return '/';
        }
    }
});


# Observações Finais
** Ajuste os URLs de redirecionamento (/admin/dashboard, /autor/dashboard, /colecionador/dashboard) conforme necessário para corresponder às rotas definidas no seu backend.
* Este exemplo é simplificado e não inclui medidas de segurança avançadas. Considere implementar medidas de segurança adequadas para um ambiente de produção.
* Teste o aplicativo integrando o frontend e o backend para garantir que o fluxo de login e redirecionamento funcione conforme esperado.



###Este README.md fornece uma visão geral clara do projeto, instruções de configuração para o backend e frontend
