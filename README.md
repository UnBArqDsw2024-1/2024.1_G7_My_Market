# RepositorioTemplate

Repositório que deve ser utilizado como template inicial pelos grupos da matéria de Arquitetura e Desenho de Software.

## Introdução

Este repositório traz um template de repo de documentação a ser seguido pelos grupos de arquitetura e desenho de software.

## Tecnologia

A geração do site estático é realizada utilizando o [docsify](https://docsify.js.org/).

```shell
"Docsify generates your documentation website on the fly. Unlike GitBook, it does not generate static html files. Instead, it smartly loads and parses your Markdown files and displays them as a website. To start using it, all you need to do is create an index.html and deploy it on GitHub Pages."
```

### Instalando o docsify

Execute o comando:

```shell
npm i docsify-cli -g
```

### Executando localmente

Para iniciar o site localmente, utilize o comando:

```shell
docsify serve ./docs
```


# Projeto MyMarket

## Configuração e Execução
### Pré-requisitos

Certifique-se de ter o Docker e o Docker Compose instalados no seu sistema.

```
docker-compose --version
```

## Instalação do Docker Compose no Linux

### Execute os seguintes comandos no terminal:

```
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```

```
sudo chmod +x /usr/local/bin/docker-compose
```

Verifique se o Docker Compose está disponível:

```
docker-compose --version
```

### Primeira Execução

Na primeira vez que for rodar o projeto, utilize o comando abaixo para construir e iniciar os contêineres:

#### Na raiz do diretório onde está o arquivo docker-compose, use o comando:

```
docker-compose up --build
```

#### Vá para o diretório frontend:

```
cd frontend
```

#### Instale as dependências do frontend: 

```
npm install
```

#### Inicie o frontend:

```
npm run start
```

### Execuções Futuras

Para iniciar o projeto nas próximas vezes, apenas utilize o comando:

```
docker-compose up
```

```
cd frontend
```

```
npm run start
```
