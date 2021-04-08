### Aplicativo desenvolvido para visualização de estados e municípios do Brasil

- Aplicativo permite visualizar a lista de estados e suas respectivas cidades e visualizar seus estados por região.

O Brasil é compost por 27 capitais, distribuídas em 26 estados e o Distrito Federal.

[![Mapa do Brasil por regiões](https://www.infoescola.com/wp-content/uploads/2020/08/mapa-capitais-brasil.jpg "Mapa do Brasil por regiões")](https://www.infoescola.com/wp-content/uploads/2020/08/mapa-capitais-brasil.jpg "Mapa do Brasil por regiões")
Fonte: https://www.infoescola.com/geografia/capitais-do-brasil/

## Tecnologia envolvida

1. Android Studio 4.1.+;
1. Linguagem Java para desenvolvimento do backend;
1. XML para desenvolvimento a interface gráfica;
1. Compatibilidade com Android 4.4 KitKat +;
1. Android Emulator para visualização da aplicação e teste;
1. ListView para visualização das informações;

>O uso de ListView é o principal componete utilizado nesta aplicação para visualizar a lista de estados, regiões e cidades, foi escolhido esse componente pela sua capacidade de lista informações de maneira dinâmica.

## Como "startar" a aplicação
1. Clonar o projeto no diretório de sua preferência;
1. Abrir o Android Studio e importar a aplicação;
1. Configurar um emulador ([click aqui);](https://developer.android.com/studio/run/emulator?hl=pt-br "click aqui")
1. Após clicar em "Run" para "startar" a aplicação.

## Navegar na aplicação
O aplicativo dispoe de 3 telas principais, composta pela tela principal que pode ser visualizada ao "startar" a aplicação, com duas opções para ver todos  os estados brasileiros ou  todos os estados por região, em ambas as telas, poderá ter detalhes dos estados para visualização das cidades correspondentes.

A aplicação, dispoe nas telas de visualização, a opção de pesquisar por nome do estado, caso não existe, a lista ficará vazia e para retornar, basta limpar o valor posto para pesquisa e clicar em pesquisar.

## API's para alimentação dos dados
Para visualziação dos dados, foi utilizada a api em Rest para visualização dos dados necessários, neste [link](https://servicodados.ibge.gov.br/api/docs/localidades "link"), poderá visualizar a documentação completa do endpoint rest utilizado.
- Rest API de Unidades Federativas do Brasil, acesse [aqui](https://servicodados.ibge.gov.br/api/docs/localidades#api-UFs-estadosGet "aqui").
- Rest API de Distritos por Unidade Federativas, acesse [aqui](https://servicodados.ibge.gov.br/api/docs/localidades#api-Distritos-estadosUFDistritosGet "aqui").
