# 🐾 Sistema de Adoção de Pets - CLI

![Java](https://img.shields.io/badge/Java-17-orange)
![License](https://img.shields.io/badge/License-MIT-blue)

Sistema de cadastro para Adoção de Pets via CLI (interface de linha de comando), desenvolvido inteiramente com Java 17, que permite o cadastro, alteração, busca, listagem e exclusão de pets.

## 💡 Motivação

Projeto desenvolvido como parte de um desafio criado por [@devmagro](https://www.linkedin.com/in/karilho/) para praticar fundamentos do Java: POO, Exceções, Manipulação de arquivos, Collections, Enums e Java IO.

Confira o [README do desafio](https://github.com/karilho/desafioCadastro#) com as regras completas.

## 📥 Instalação

**Pré-requisitos:** JDK 17 ou superior

### Via Git:
```bash
git clone https://github.com/fnbritosx/PetAdoptionCLI.git
cd PetAdoptionCLI
```

### Via Download:
1. Na página do repositório: **Code** → **Download ZIP**
2. Extraia e abra em sua IDE

## 🚀 Como Executar

1. Abra o projeto em sua IDE
2. Execute a classe `Main.java`
3. Interaja com o menu via console

**Não há necessidade de configurar caminhos!** O sistema detecta automaticamente os diretórios usando `System.getProperty("user.dir")`.

## 🎯 Funcionalidades

### Menu Principal

```
--- MENU ---
1. Cadastrar um novo pet
2. Alterar os dados do pet cadastrado
3. Deletar um pet cadastrado
4. Listar todos os pets cadastrados
5. Listar pets por algum critério (idade, nome, raça)
6. Sair
```

---

### 1️⃣ Cadastrar um Novo Pet

Lê as perguntas do arquivo `form.txt` e coleta as informações do pet. Campos não preenchidos são automaticamente marcados como "Não Informado".

**Exemplo de interação:**

```
Digite um número: 1
1 - Qual o nome e sobrenome do pet?
R: Claude sonnet
2 - Qual o tipo do pet (Cachorro/Gato)?
R: gato
3 - Qual o sexo do animal (Macho/Fêmea)?
R: macho
4 - Qual endereço e bairro que ele foi encontrado?
i. Número da casa
R: 50
ii. Rua
R: Miltan
iii. Cidade
R: Saquarema
5 - Qual a idade aproximada do pet?
R: 10
6 - Qual o peso aproximado do pet?
R: 2
7 - Qual a raça do pet?
R: pinsher
O cadastro do pet foi realizado!
```

**Principais validações:**
- Nome obrigatório (apenas letras)
- Peso entre 0.5kg e 60kg
- Idade até 20 anos
- Tipo e Sexo validados por Enums

---

### 2️⃣ Alterar Dados do Pet

Permite modificar atributos de um pet cadastrado. O sistema lista todos os pets e solicita qual deseja alterar.

**Exemplo de interação:**

```
Digite um número: 2
1 - Não Informado - Gato - Macho - Rua sla, Não Informado - sla - Não Informado - Não Informado - Não Informado
2 - Não Informado - Cachorro - Macho - Rua miltan, 40 - saquarema - 50 anos - 30 kg - pitbull
3 - Claude sonnet - Gato - Macho - Rua Miltan, 50 - Saquarema - 10 anos - 2 kg - pinsher
Qual pet deseja alterar?
R: 1

Qual atributo do pet deseja alterar?
1 - Nome
2 - Rua
3 - Número
4 - Cidade
5 - Peso
6 - Raça
R: 1
Nome: Grook X
Deseja continuar as alterações no pet?
1 - Sim
2 - Não
R: 1

Antes: 
1 - Não Informado - Gato - Macho - Rua sla, Não Informado - sla - Não Informado - Não Informado - Não Informado
Depois: 
1 - Grook X - Gato - Macho - Rua sla, Não Informado - sla - Não Informado - Não Informado - Não Informado

Qual atributo do pet deseja alterar?
1 - Nome
2 - Rua
3 - Número
4 - Cidade
5 - Peso
6 - Raça
R: 3
Número: 20
Deseja continuar as alterações no pet?
1 - Sim
2 - Não
R: 2

Antes: 
1 - Grook X - Gato - Macho - Rua sla, Não Informado - sla - Não Informado - Não Informado - Não Informado
Depois: 
1 - Grook X - Gato - Macho - Rua sla, 20 - sla - Não Informado - Não Informado - Não Informado
```

**Características:**
- Permite alterar múltiplos atributos em sequência
- Mostra comparação "Antes" e "Depois"
- Não permite alterar Tipo e Sexo do pet

---

### 3️⃣ Deletar Pet

Remove permanentemente um pet do sistema após confirmação.

**Exemplo de interação:**

```
Digite um número: 3
1 - Grook X - Gato - Macho - Rua Amaral Peixoto, 20 - sla - Não Informado - Não Informado - Não Informado
2 - Não Informado - Cachorro - Macho - Rua miltan, 40 - saquarema - 50 anos - 30 kg - pitbull
3 - Claude sonnet - Gato - Macho - Rua Miltan, 50 - Saquarema - 10 anos - 2 kg - pinsher
Qual linha deseja deletar? 
R: 2

Tem certeza de que quer deletar a linha: 
2 - Não Informado - Cachorro - Macho - Rua miltan, 40 - saquarema - 50 anos - 30 kg - pitbull
1- Sim
2 - Não
R: 2
Operação cancelada.

1 - Grook X - Gato - Macho - Rua Amaral Peixoto, 20 - sla - Não Informado - Não Informado - Não Informado
2 - Não Informado - Cachorro - Macho - Rua miltan, 40 - saquarema - 50 anos - 30 kg - pitbull
3 - Claude sonnet - Gato - Macho - Rua Miltan, 50 - Saquarema - 10 anos - 2 kg - pinsher
Qual linha deseja deletar? 
R: 1

Tem certeza de que quer deletar a linha: 
1 - Grook X - Gato - Macho - Rua Amaral Peixoto, 20 - sla - Não Informado - Não Informado - Não Informado
1- Sim
2 - Não
R: 1
Pet deletado com sucesso!
```

**Características:**
- Solicita confirmação antes de deletar
- Permite cancelar a operação
- Arquivo do pet é removido permanentemente

---

### 4️⃣ Listar Todos os Pets

Exibe todos os pets cadastrados no sistema. Após deletar um pet, os índices são automaticamente reajustados.

**Exemplo de interação:**

```
Digite um número: 4
1 - Não Informado - Cachorro - Macho - Rua miltan, 40 - saquarema - 50 anos - 30 kg - pitbull
2 - Claude sonnet - Gato - Macho - Rua Miltan, 50 - Saquarema - 10 anos - 2 kg - pinsher
```

**Observação:** Note que o pet "Grook X" (índice 1) foi deletado, e os demais pets tiveram seus índices atualizados automaticamente (2→1, 3→2).

---

### 5️⃣ Buscar por Critérios

Sistema de busca avançada com filtros combinados (até 2 critérios). Cria um arquivo `petfilter.txt` com os resultados.

**Exemplo de interação:**

```
Digite um número: 5
Escolha o tipo de animal
1 - Cachorro
2 - Gato
R: 2

Escolha o primeiro critério de busca
1 - Nome ou Sobrenome
2 - Sexo
3 - Idade
4 - Peso
5 - Raça
6 - Endereço
R: 2
Sexo: macho

Deseja selecionar mais um critério?
1 - Sim
2 - Não
R: 1

Escolha um novo critério
1 - Nome ou Sobrenome
3 - Idade
4 - Peso
5 - Raça
6 - Endereço
R: 6

Digite o subtipo do endereço: 
1 - Rua
2 - Número
3 - Cidade
R: 1
Endereço - Rua: M

Arquivo 'pets_filtrados.txt' criado com sucesso! 
=== PETS ENCONTRADOS ===
1 - Claude sonnet - Gato - Macho - Rua Miltan, 50 - Saquarema - 10 anos - 2 kg - pinsher
```

**Características:**
- Tipo de animal sempre obrigatório
- Permite combinar até 2 critérios
- Busca parcial em nomes e endereços (ex: "M" encontra "Miltan")
- Gera arquivo com resultados filtrados

---

### 6️⃣ Sair

Encerra o programa.

```
Digite um número: 6
Encerrando o programa...
```

## 📂 Estrutura de Arquivos

O sistema gerencia automaticamente os seguintes diretórios:

```
PetAdoptionCLI/
├── src/model/repository/form/form.txt    # Formulário de perguntas
├── database/
│   ├── pets/                             # Pets cadastrados
│   ├── allpets/allPets.txt              # Lista completa
│   └── registeredpets/petfilter.txt     # Resultados de busca
```


## 📄 Licença

[MIT](https://choosealicense.com/licenses/mit/)

---

**Desenvolvido por [@fnbritosx](https://github.com/fnbritosx)**