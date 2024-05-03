
<h1 align="center">Projeto Spring boot com postgres</h1>
<p align="center" >
        <a href="https://skillicons.dev">
          <img src="https://skillicons.dev/icons?i=git,spring,hibernate,postgres" />
        </a>
</p>
<h2>Sobre o projeto</h2>
<p>Projeto construído no curso "Java COMPLETO Programação Orientada a Objetos + Projeto ~Nélio alves".
<p> <a href="https://www.udemy.com/course/java-curso-completo"/> << Link do curso >> </a> </p>
</p>
<h2>Características do projeto:</h2>
<p> Projeto consciste em integrar banco de dado relacional atravéz de JPA. Implementado com Hibernate.</p>
<p> Na etapada de desenvolvimento é utilizado o banco de dados em memória H2. </p>


<h2>Instalação e execução do projeto</h2>

<p>Você precisara ter o Java rodando em sua maquina </p>

<p>Clone o projeto em sua máquina.</p>

<p>Abra-o de preferência com a IDE inteliJ e atualize as dependências do projeto (caso elas n atualizem automaticamente).</p>

<p>Banco de dados postgres instalado. <em> Observação: O Hibernate criara o database e as tabelas automaticamenteem </p>

<p>Confira se o postgres esta rodando na porta 5432 </p>

<p>Modifique as variavies "spring.datasource.url", "spring.datasource.username", "spring.datasource.password" do arquivo application-dev.properties localizado na pasta src/main/resources do projeto.</p>

 <p>De um start na aplicação. Para conferir se o projeto está funcionando. Usando Postman ou qualquer outro software da sua escolha, faça uma requisição get ao endereço: <Strong> http://localhost:8080/users <strong> na qual devera retornar dois objetos UserDTO ("Maria Brown" e "Alex Green")  </p>

<h2>API Endpoints</h2>

<p>A api fornece os seguintes endpoints: </p>

<h3>Users</h3>

<p>GET /users - Retorna toda a lista de usuarios .</p>

<p>GET /users/id - retorna um user com o id passado por parâmetro caso exista. </p>

<p>POST /users - Registra um novo usuário .</p>

<p>DELETE /users/id -Deleta o usuário com o id passado .</p>

<p>UPDATE /users/id - atualiza os atributos de um usuário .</p>

<h3>Categories</h3>

<p>GET /categories - Retorna todas as categorias .</p>

<p>GET /categories/id - Retorna a categoria com o id passado por parâmetro caso exista.</p>

<h3>Order</h3>

<p>GET /orders - Retorna todas order .</p>

<p>GET /orders/id - Retorna a order com o id passado por parâmetro caso exista.</p>

<h3>Product</h3>

<p>GET /products - Retorna todas os products .</p>

<p>GET /products/id - Retorna o produto com o id passado por parâmetro caso exista.</p>
