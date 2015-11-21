#Database

Movi a responsabilidade por saber o salário dos funcionários para aqui, já que essa informação está em um local externo e precisa ser carregada no programa.

## Métodos adicionados
### carregaMesas(BufferedReader)

O método para carregar a configuração das mesas pelo arquivo. Para melhor testar o método, ele recebe um BufferedReader, e não um arquivo, para fazer a leitura.

### carregaSalarios(BufferedReader)

Lê a distribuição dos salários de uma stream. 

### getSalarioFixoPara(Class<Funcionario>)

Recebe a classe cujo salário se quer saber, e retorna esse salário fixo. A classe fornecida deve herdar de funcionário.

### getSalarioVariavelPara(Class<Funcionario>)

Recebe a classe cujo salário se quer saber, e retorna esse salário fixo. A classe fornecida deve herdar de funcionário.

## Métodos removidos

## Métodos modificados