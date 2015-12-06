#Database

Movi a responsabilidade por saber o salário dos funcionários para aqui, já que essa informação está em um local externo e precisa ser carregada no programa.

## Métodos adicionados

### getSalarioFixoPara(Class<Funcionario>)

Recebe a classe cujo salário se quer saber, e retorna esse salário fixo. A classe fornecida deve herdar de funcionário.

### getSalarioVariavelPara(Class<Funcionario>)

Recebe a classe cujo salário se quer saber, e retorna esse salário fixo. A classe fornecida deve herdar de funcionário.


#OperaçõesAuxiliar

Foi necessário criar um método para retornar a lista de mesas sujas. Da maneira que o programa estava estruturado, não havia como informar ao usuário quais mesas ele deveria limpar, e então esse método teve de ser criado.

# Testes Unitários

Criamos testes unitários para testar a inicialização correta da base de dados. Esses testes foram feitos para garantir que mudanças futuras não iriam alterar de forma significativa o estado dos dados.

Também criamos testes para as ações do Cozinheiro e AuxiliarCozinha. Partindo de um estado conhecido, os testes garantiam que o estado final era o esperado, permitindo assim testar casos extremos e fazer alterações sem afetar a funcionalidade esperada do programa.