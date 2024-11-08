# Coffee Shop Mobile

Coffee Shop Mobile é um aplicativo de loja de café, desenvolvido em Kotlin para a plataforma Android. O projeto segue a Arquitetura MVVM e Clean Architecture, utilizando várias tecnologias e bibliotecas modernas, como Firebase Firestore para armazenamento de dados, Hilt para injeção de dependência, e outras ferramentas essenciais para desenvolvimento de apps robustos e escaláveis.

## Figma

![Selecionado novembro 08 2024 14:33:23](https://github.com/user-attachments/assets/94ad6d65-de18-4aa5-b1d9-d178740f7488)


## Funcionalidades

- Exibição de um catálogo de cafés em um layout de grade.
- Navegação entre telas de maneira intuitiva.
- Integração com o Firebase Firestore para armazenamento de dados.
- Arquitetura limpa e modular, facilitando manutenibilidade e testes.

## Tecnologias e Bibliotecas

- **Kotlin**: Linguagem principal do projeto.
- **MVVM e Clean Architecture**: Estrutura de código bem organizada e fácil de escalar.
- **Hilt**: Para injeção de dependência simplificada.
- **Firebase Firestore**: Utilizado para armazenamento e recuperação dos dados dos cafés.
- **DataBinding e ViewBinding**: Para facilitar o uso das views.
- **Retrofit e Gson**: Para chamadas de API e manipulação de dados JSON.
- **Picasso**: Carregamento de imagens de maneira eficiente.
- **Jetpack Libraries**: Incluindo Lifecycle, ViewModel, Navigation, e RecyclerView.

## Estrutura do Projeto

O projeto segue a estrutura padrão do MVVM com Clean Architecture, com separação clara de responsabilidades:

- **presentation**: Contém as Activities e ViewModels.
- **domain**: Camada de lógica de negócios.
- **data**: Camada de acesso aos dados, que inclui o repositório Firebase Firestore.

## Configuração do Projeto

### Pré-requisitos

- Android Studio Flamingo ou superior.
- JDK 11 instalado.
- Firebase configurado no projeto (adicione o arquivo `google-services.json` na pasta `app`).

### Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/coffe_shop_mobile.git
   cd coffe_shop_mobile
   ```
2. Abra o projeto no Android Studio.

3. Sincronize as dependências com o Gradle.

4. Conecte-se ao Firebase e configure o Firestore para o armazenamento de dados.


###   Build e Execução
- Para compilar e rodar o aplicativo, selecione o dispositivo desejado no Android Studio e clique em "Run" e configurar o **firebase**.

### Projeto Finalizado


https://github.com/user-attachments/assets/5d067bb1-e16f-48bb-ac21-7235f3a690c4




