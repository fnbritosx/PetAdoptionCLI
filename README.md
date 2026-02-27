# 🐾 PetAdoptionCLI

Sistema de adoção de pets via linha de comando (CLI) desenvolvido em Java puro, utilizando os princípios de **Orientação a Objetos**, padrão **MVC** e manipulação de arquivos com **Java IO**.

---

## Sobre o Projeto

O **PetAdoptionCLI** é um sistema de gerenciamento de abrigo de animais para adoção. O dono do abrigo pode cadastrar, buscar, alterar, listar e deletar pets diretamente pelo terminal, sem necessidade de interface gráfica ou banco de dados — todos os dados são persistidos em arquivos `.txt`.

---

## Funcionalidades

| Opção | Funcionalidade |
|-------|----------------|
| 1 | Cadastrar um novo pet |
| 2 | Alterar os dados de um pet cadastrado |
| 3 | Deletar um pet cadastrado |
| 4 | Listar todos os pets cadastrados |
| 5 | Buscar pets por critério (nome, sexo, idade, peso, raça, endereço) |
| 6 | Sair do programa |

---

## Arquitetura

O projeto segue o padrão **MVC (Model-View-Controller)**, separando claramente as responsabilidades:

```
┌─────────────┐     ┌──────────────┐     ┌─────────────┐
│    View     │ ◄── │  Controller  │ ──► │    Model    │
│  (entrada/  │     │  (orquestra  │     │  (regras,   │
│   saída)    │     │   o fluxo)   │     │  dados, IO) │
└─────────────┘     └──────────────┘     └─────────────┘
```

- **View**: lida exclusivamente com entrada e saída no terminal (Scanner / System.out)
- **Controller**: coordena o fluxo entre View e Model, trata exceções
- **Model**: contém as entidades, serviços de validação e acesso a arquivos (Repository)

---

## Estrutura de Pastas

```
PetAdoptionCLI/
│
├── src/
│   ├── main/
│   │   └── Main.java                          # Ponto de entrada da aplicação
│   │
│   ├── controller/
│   │   ├── MenuController.java                # Controla o menu principal
│   │   ├── PetController.java                 # Controla o cadastro de pet
│   │   ├── ChangePetController.java           # Controla a alteração de pet
│   │   ├── DeletePetController.java           # Controla a exclusão de pet
│   │   ├── AllPetsController.java             # Controla a listagem de todos os pets
│   │   └── SearchPetController.java           # Controla a busca por critérios
│   │
│   ├── model/
│   │   ├── entity/
│   │   │   ├── Pet.java                       # Entidade principal
│   │   │   ├── PetType.java                   # Enum: CACHORRO / GATO
│   │   │   ├── PetSex.java                    # Enum: MACHO / FEMEA
│   │   │   └── PetConstants.java              # Constante NAO_INFORMADO
│   │   │
│   │   ├── exception/
│   │   │   ├── MenuNumberException.java       # Entrada inválida no menu
│   │   │   ├── ResponseFormException.java     # Resposta inválida no formulário
│   │   │   ├── ChangePetException.java        # Erro ao alterar pet
│   │   │   ├── DeletePetException.java        # Erro ao deletar pet
│   │   │   └── SearchPetException.java        # Erro ao buscar pet
│   │   │
│   │   ├── repository/
│   │   │   ├── PetRepository.java             # Leitura e escrita de arquivos
│   │   │   └── form/
│   │   │       └── form.txt                   # Perguntas do formulário
│   │   │
│   │   └── service/
│   │       ├── PetService.java                # Validações do cadastro
│   │       ├── MenuService.java               # Validações do menu
│   │       ├── ChangePetService.java          # Validações da alteração
│   │       ├── DeletePetService.java          # Validações da exclusão
│   │       └── SearchPetService.java          # Filtros e validações da busca
│   │
│   └── view/
│       ├── MenuView.java                      # Exibe e captura o menu
│       ├── PetView.java                       # Exibe formulário e captura respostas
│       ├── ChangePetView.java                 # Interface para alteração
│       ├── DeletePetView.java                 # Interface para exclusão
│       ├── AllPetsView.java                   # Interface para listagem
│       └── SearchPetView.java                 # Interface para busca
│
└── database/
    ├── allpets/
    │   └── allPets.txt                        # Registro de todos os pets (índice geral)
    ├── pets/
    │   └── <TIMESTAMP>-<NOME>.txt             # Arquivo individual por pet
    └── registeredpets/
        └── petfilter.txt                      # Resultado temporário de buscas
```

---

## Como Executar

```bash
git clone https://github.com/fnbritosx/PetAdoptionCLI.git
```

Abra o projeto no IntelliJ IDEA, navegue até `src/main/Main.java` e clique em ▶.

> ⚠️ **Importante:** Execute sempre a partir da raiz do projeto. O sistema usa `System.getProperty("user.dir")` para construir os caminhos dos arquivos em tempo de execução — isso significa que ele detecta automaticamente onde o projeto está na sua máquina, sem precisar configurar nada. No entanto, se o ponto de execução não for a raiz do projeto, os caminhos ficam errados e o programa não consegue encontrar os arquivos. O IntelliJ já define o diretório de trabalho como a raiz por padrão, então ao rodar pelo IDE isso nunca deve ser um problema.

---

## Como Usar

Ao iniciar, o menu principal é exibido:

```
--- MENU ---
1. Cadastrar um novo pet
2. Alterar os dados do pet cadastrado
3. Deletar um pet cadastrado
4. Listar todos os pets cadastrados
5. Listar pets por algum critério (idade, nome, raça)
6. Sair
Digite um número:
```

### Opção 1 — Cadastrar Pet

O sistema lê as perguntas do arquivo `form.txt` e exibe uma a uma:

```
1 - Qual o nome e sobrenome do pet?
R: Rex Silva

2 - Qual o tipo do pet (Cachorro/Gato)?
R: CACHORRO

3 - Qual o sexo do animal (Macho/Fêmea)?
R: MACHO

4 - Qual endereço e bairro que ele foi encontrado?
  i. Número da casa: 123
  ii. Rua: Paulista
  iii. Cidade: São Paulo

5 - Qual a idade aproximada do pet?
R: 3

6 - Qual o peso aproximado do pet?
R: 12.5

7 - Qual a raça do pet?
R: Labrador
```

### Opção 2 — Alterar Pet

Lista todos os pets, o usuário escolhe o número do pet e o atributo a alterar:

```
Qual atributo do pet deseja alterar?
1 - Nome
2 - Rua
3 - Número
4 - Cidade
5 - Peso
6 - Raça
```

> **Nota:** Tipo e Sexo do pet não podem ser alterados.

### Opção 5 — Buscar por Critério

O usuário escolhe o tipo de animal (Cachorro/Gato) e depois o critério de busca. É possível combinar até **2 critérios**:

```
Escolha o tipo de animal
1 - Cachorro
2 - Gato

Escolha o primeiro critério de busca
1 - Nome ou Sobrenome
2 - Sexo
3 - Idade
4 - Peso
5 - Raça
6 - Endereço
```

O resultado é salvo em `database/registeredpets/petfilter.txt` e exibido no terminal.

---

## Regras de Validação

### Nome do Pet
- Obrigatório ter **nome e sobrenome** (mínimo 2 palavras)
- Somente letras (A-Z, incluindo caracteres acentuados)
- Máximo de 30 palavras
- Se em branco: preenchido com `Não Informado`

### Tipo (`PetType`)
- Aceita apenas: `CACHORRO` ou `GATO` (case insensitive)

### Sexo (`PetSex`)
- Aceita apenas: `MACHO` ou `FEMEA` (case insensitive)

### Endereço
- **Número da casa:** até 5 dígitos numéricos; se em branco: `Não Informado`
- **Rua:** mínimo 3 caracteres, somente letras e espaços; prefixo `Rua` adicionado automaticamente se ausente
- **Cidade:** entre 2 e 40 caracteres, somente letras, deve conter vogal

### Idade
- Formato aceito: número de 0 a 99 com até 1 casa decimal (ex: `0.5`, `3`, `12.5`)
- Armazenado como `"X anos"` (ex: `"3 anos"`)
- Se em branco: `Não Informado`

### Peso
- Entre **0.5 kg** e **60 kg**
- Aceita vírgula ou ponto como separador decimal
- Armazenado como `"X kg"` (ex: `"12.5 kg"`)
- Se em branco: `Não Informado`

### Raça
- Somente letras e espaços
- Se em branco: `Não Informado`

### Menu Principal
- Aceita apenas números de **1 a 6**
- Não aceita letras, caracteres especiais, valores negativos ou zero

---

## Armazenamento de Dados

### Arquivo individual do pet

Criado em `database/pets/` com o formato de nome:

```
20260114T1242-REXSILVA.txt
```

O nome do arquivo segue o padrão **`AAAAMMDDTHHMI-NOMEPET.txt`**, onde:

- `20260114` → data do cadastro: ano `2026`, mês `01`, dia `14`
- `T` → separador padrão ISO entre data e hora
- `1242` → horário do cadastro: `12h42min`
- `REXSILVA` → nome completo do pet em maiúsculo, sem espaços

Isso garante que cada arquivo seja único e facilmente identificado pela data/hora de cadastro.

Conteúdo:
```
1 - Rex Silva
2 - Cachorro
3 - Macho
5 - Rua Paulista, 123, São Paulo
6 - 3 anos
7 - 12.5 kg
8 - Labrador
```

### Arquivo de índice geral

`database/allpets/allPets.txt` — uma linha por pet, com ID sequencial:

```
1 - Rex Silva - Cachorro - Macho - Rua Paulista, 123 - São Paulo - 3 anos - 12.5 kg - Labrador
2 - Florzinha da Silva - Gato - Femea - Rua das Flores, 456 - Campinas - 6 anos - 5 kg - Siames
```

### Arquivo de busca filtrada

`database/registeredpets/petfilter.txt` — gerado a cada busca, sobrescrito automaticamente.

---

## Documentação das Classes

### `main.Main`
Ponto de entrada da aplicação. Instancia o `MenuController` e dá início ao loop principal.

---

### Controllers

A decisão de ter um controller por funcionalidade foi intencional — inicialmente tudo estava concentrado em um único lugar, mas ficou inviável de manter. Separar em controllers dedicados tornou cada fluxo mais fácil de entender, testar e modificar de forma independente.

| Classe | Responsabilidade |
|--------|-----------------|
| `MenuController` | Loop do menu principal, despacha para o controller correto |
| `PetController` | Cadastro de novo pet |
| `ChangePetController` | Alteração de dados (exceto Tipo e Sexo) |
| `DeletePetController` | Exclusão com confirmação e renumeração dos IDs |
| `AllPetsController` | Listagem de todos os pets |
| `SearchPetController` | Busca por até 2 critérios combinados |

---

### Model — Entity

A entidade `Pet` é simples por escolha: armazena tudo como `String` (exceto `PetType` e `PetSex`, que são enums) para facilitar a leitura e escrita nos arquivos `.txt` sem precisar de conversões complexas. `PetType` e `PetSex` foram modelados como enums para evitar que valores arbitrários fossem aceitos nesses campos.

| Classe | Descrição |
|--------|-----------|
| `Pet` | Entidade central com todos os dados do animal |
| `PetType` | Enum: `CACHORRO` / `GATO` |
| `PetSex` | Enum: `MACHO` / `FEMEA` |
| `PetConstants` | Constante `NAO_INFORMADO` usada em campos opcionais |

---

### Model — Repository

Todo acesso a arquivo passa pelo `PetRepository`. Essa foi uma das decisões de design mais importantes do projeto — centralizar leitura e escrita em um único lugar evita que a lógica de IO fique espalhada pelo código e facilita qualquer mudança futura na forma de persistência.

| Classe | Descrição |
|--------|-----------|
| `PetRepository` | Toda leitura e escrita de arquivos (form, allPets, pets individuais, filtro) |

---

### Model — Service

Cada operação tem seu próprio service de validação. A ideia foi manter os controllers limpos — eles apenas orquestram o fluxo, enquanto toda a lógica de negócio e validação fica isolada nos services. Isso também facilita reutilizar validações em mais de um lugar, como acontece com `PetService`, que é usado tanto no cadastro quanto na alteração.

| Classe | Descrição |
|--------|-----------|
| `PetService` | Validações do cadastro (nome, tipo, sexo, endereço, idade, peso, raça) |
| `MenuService` | Validação da entrada do menu (número, intervalo, em branco) |
| `ChangePetService` | Validações da alteração de pet |
| `DeletePetService` | Validação da confirmação de exclusão |
| `SearchPetService` | Filtros de busca por todos os critérios disponíveis |

---

### Classes de Exceção

Cada camada tem sua própria exceção para deixar claro onde o erro ocorreu e permitir que os controllers tratem cada caso de forma específica. Todas estendem `RuntimeException` para não forçar tratamento obrigatório em toda a cadeia de chamadas — o tratamento acontece nos controllers, que é onde faz sentido exibir o feedback para o usuário.

| Classe | Quando é lançada |
|--------|-----------------|
| `MenuNumberException` | Entrada inválida no menu |
| `ResponseFormException` | Resposta inválida em qualquer campo do formulário |
| `ChangePetException` | Erro ao alterar (pet não encontrado, atributo inválido) |
| `DeletePetException` | Confirmação de exclusão inválida |
| `SearchPetException` | Entrada inválida nos critérios de busca |

---

- **Java 11+** — linguagem principal
- **Java IO / NIO** — leitura e escrita de arquivos (`Files`, `FileWriter`, `Path`)
- **Java Time** — formatação de timestamp no nome dos arquivos (`LocalDateTime`, `DateTimeFormatter`)
- **Regex (Pattern/Matcher)** — validações de entrada
- **Scanner** — leitura de entradas do terminal
- **Enum** — tipagem de PetType e PetSex
- **ANSI Escape Codes** — cores no terminal (vermelho para erros, verde para sucesso)
- **Padrão MVC** — separação de responsabilidades
- **Padrão Repository** — abstração do acesso a dados

---

## Autor

Desenvolvido por **fnbritosx**.
