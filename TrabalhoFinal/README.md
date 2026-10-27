# Sistema de Pesquisa e Indexação de Palavras

Trabalho final desenvolvido em equipe durante a disciplina de Algoritmos e Estruturas de Dados do curso de Ciências da Computação, utilizando Java. O projeto tem como objetivo realizar pesquisas de palavras em arquivos de texto por meio de um índice implementado com mapa de dispersão (*Hash*).

## Funcionalidades

- Indexação de arquivos `.txt` em um diretório e seus subdiretórios.
- Extração e normalização de palavras dos documentos.
- Desconsideração de pontuações, números isolados e palavras com menos de três letras.
- Associação de palavras aos documentos em que aparecem.
- Persistência do índice em disco e carregamento dos dados na memória.
- Pesquisa por uma ou mais palavras.
- Retorno dos documentos que contêm todas as palavras pesquisadas.

## Conteúdos praticados

- Tabelas de dispersão (*Hash*).
- Implementação de estruturas de dados sem utilizar coleções nativas do Java, como `ArrayList` e `HashMap`.
- Manipulação de arquivos e diretórios.
- Indexação e pesquisa de palavras.
- Persistência e recuperação de dados.

## Tecnologias utilizadas

- **Linguagem:** Java
- **Estrutura de indexação:** mapa de dispersão (*Hash*)
- **Armazenamento:** arquivos em disco
