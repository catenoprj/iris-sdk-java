<p align="center">
    <img src="https://www.catenoiris.com.br/v1/images/logoBRA1.png" width="304" height="235">
</p>

# Cateno Íris SDK para Java

O **Cateno Íris SDK para Java** permite que os desenvolvedores de Java trabalhem facilmente com 
[Cateno Íris](https://www.catenoiris.com.br) e construa soluções ágeis para bloqueio de autorizações e muito mais.
Você pode começar em minutos usando ***Maven*** ou baixando um [único arquivo zip]().

## Instalar

#### Construindo a partir do código fonte ####
Depois de fazer o checkout do código fonte no GitHub, você pode empacotar o jar usando o Maven:
```sh
mvn clean package
```

#### Usando os módulos Maven do SDK ####

Basta adicionar Cateno Íris SDK como uma dependência:
```xml
<dependencies>

  <dependency>
    <groupId>br.com.cateno</groupId>
    <artifactId>iris-sdk-java</artifactId>
    <version>1.0.0</version>
  </dependency>
  
</dependencies>
```

## Começando

#### Configurar credenciais Cateno Íris ####

Antes de começar, você precisa de uma conta Cateno Íris. Inscreva-se no [Portal Cateno Íris](https://portal-cateno.sensedia.com/api-portal/user/register) 
para obter informações sobre como criar uma app Cateno Íris e recuperar suas credenciais.

Para definir suas credenciais pelo Cateno Íris SDK para Java basta:
```java
IrisClient iris = IrisClientBuilder.standard()
    .withClientCredentials(new ClientCredentials(CLIENT_ID, CLIENT_SECRET))
    .withUserCredentials(new UserCredentials(USERNAME, PASSWORD))
    .build();
```
Uma vez autenticado, a instância de `IrisClient` provê acesso aos serviços responsáveis por cada componente do Cateno Íris.
Abaixo, o exemplo de uma consulta a contestações:
```java
ClaimService claimService = iris.loadClaimService();

ClaimFilters filters = ClaimFilters.builder()
    .closeDate(CloseDateRange.from(2013, 2, 7))
    .issuer("ebaea3a9-4ff1-4353-83bf-e9e033f86dae")
    .status("C")
    .term("Owagner Lane")
    .value(ValueRange.between(1100.6, 1200.0))
    .build();

List<Claim> claims = claimService.list(filters, Pagination.with(10, 0));
```
