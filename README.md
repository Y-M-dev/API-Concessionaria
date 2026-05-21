# API de Gestão de Concessionária

API REST para gerenciamento de clientes e veículos de uma concessionária, desenvolvida em Java com Spring Boot.


## Como Rodar o Projeto

### Configuração do Banco de Dados

No application.properties configure:

spring.datasource.url=jdbc:postgresql://localhost:5432/concessionaria
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update


O endereço da API: http://localhost:8080/api/v1


### Cliente


 `POST` `/cliente`
 
`GET`  `/cliente` | Listar clientes (filtrar por `/nome` e/ou `/cpf`) 

 `DELETE`  `/cliente/{id}`  Remover cliente 

#### Body — POST /cliente

```json
{
  "nome": "João Silva",
  "telefone": "11999999999",
  "cpf": "12345678901",
  "email": "joao@email.com"
}
```
### Veículo

 Método  Rota  Descrição
 `POST`  `/veiculo`  Cadastrar novo veículo 

 `GET`  `/veiculo`  Listar veículos (filtrar por `/placa`, `/marca` e/ou `/modelo`) 

 `PUT`  `/veiculo/{id}`  Atualizar dados do veículo 

 `DELETE`  `/veiculo/{id}`  Remover veículo 

#### Body — POST /veiculo

```json
{
  "clienteId": "uuid-do-cliente",
  "placa": "ABC1D23",
  "marca": "Toyota",
  "modelo": "Corolla",
  "ano": 2022,
  "valor": 95000.00,
  "maximoDesconto": 5.0
}
```

#### Body — PUT /veiculo/{id}

```json
{
  "marca": "Toyota",
  "modelo": "Corolla",
  "ano": 2022,
  "valor": 95000.00,
  "placa": "ABC1D23",
  "maximoDesconto": 5.0,
  "vendido": true,
  "valorVenda": 90000.00
}
```

> Se `vendido` for `true`, `valorVenda` é obrigatório e deve ser maior que 0.  
> Se `vendido` for `false`, `valorVenda` deve ser 0.

---
