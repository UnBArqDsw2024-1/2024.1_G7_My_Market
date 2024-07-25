# Builder - GoF Criacional

## 1. Introdução

O Padrão Builder, um elemento essencial dos padrões de projeto criacionais, oferece uma abordagem estruturada para enfrentar o desafio de criar objetos complexos. Ao modularizar o processo de construção e promover a escalabilidade, ele capacita os desenvolvedores a produzir diversas representações de produtos com clareza e precisão. Em um cenário de software em constante evolução, o Padrão Builder destaca-se como um modelo de criação de objetos flexível e claro, facilitando a manutenção e extensão do código.

## 2. Objetivo
No MyMarket um produto pode ter vários atributos obrigatórios e opcionais que precisam ser preenchidos para um objeto ser construído. Pensando nisto, uma forma de evitar um construtor enorme com muitos campos nulos preenchidos seria criar um Builder para fornecer uma implementação mais limpa do objeto Produto.

Como exemplo, considere os seguintes atributos:

### Atributos Obrigatórios:

- id (int): Identificador único do produto.
- name (String): Nome do produto.
- price (double): Preço do produto.
- quantity (int): Quantidade em estoque.
- category (String): Categoria do produto.

### Atributos Opcionais:

- description (String): Descrição do produto.
- brand (String): Marca do produto.
- size (String): Tamanho do produto (ex: P, M, G, GG ou especificações como 15cm x 10cm).
- color (String): Cor do produto.
- weight (double): Peso do produto.
- dimensions (String): Dimensões do produto (ex: 30cm x 20cm x 10cm).
- material (String): Material do produto.
- manufacturer (String): Fabricante do produto.
- warranty (String): Garantia do produto.
- sku (String): Stock Keeping Unit, código de rastreamento do produto.
- releaseDate (LocalDate): Data de lançamento do produto.
- ratings (double): Classificação média do produto.
- numReviews (int): Número de avaliações do produto.
- imageURL (String): URL da imagem do produto.
- tags (List<String>): Lista de tags associadas ao produto.

## 3. Implementação
...
### 3.1. Diagrama UML


Modelagem a seguir foi criada utilizando a ferramenta online [Lucidchart](https://www.lucidchart.com/pages/) pelos alunos [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan).

![Builder](https://github.com/user-attachments/assets/5274db2c-c138-437b-af9d-d99f9d52741d)


<h6 align = "center">Figura 01: Diagrama de Classes utilizando o padrão criacional Builder. Fonte: Mateus Orlando, Pedro Lucas e Thiago Vivan.</h6>

### 3.2. Código

O código em java a seguir foi desenvolvido pelos alunos [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan).

```java
import java.time.LocalDate;
import java.util.List;

public class Product {
    private final int id;
    private final String name;
    private final double price;
    private final int quantity;
    private final String category;
    private final String description;
    private final String brand;
    private final String size;
    private final String color;
    private final double weight;
    private final String dimensions;
    private final String material;
    private final String manufacturer;
    private final String warranty;
    private final String sku;
    private final LocalDate releaseDate;
    private final double ratings;
    private final int numReviews;
    private final String imageURL;
    private final List<String> tags;

    private Product(ProductBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.category = builder.category;
        this.description = builder.description;
        this.brand = builder.brand;
        this.size = builder.size;
        this.color = builder.color;
        this.weight = builder.weight;
        this.dimensions = builder.dimensions;
        this.material = builder.material;
        this.manufacturer = builder.manufacturer;
        this.warranty = builder.warranty;
        this.sku = builder.sku;
        this.releaseDate = builder.releaseDate;
        this.ratings = builder.ratings;
        this.numReviews = builder.numReviews;
        this.imageURL = builder.imageURL;
        this.tags = builder.tags;
    }

    public static class ProductBuilder {
        private final int id;
        private final String name;
        private final double price;
        private final int quantity;
        private final String category;
        private String description;
        private String brand;
        private String size;
        private String color;
        private double weight;
        private String dimensions;
        private String material;
        private String manufacturer;
        private String warranty;
        private String sku;
        private LocalDate releaseDate;
        private double ratings;
        private int numReviews;
        private String imageURL;
        private List<String> tags;

        public ProductBuilder(int id, String name, double price, int quantity, String category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.category = category;
        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public ProductBuilder setSize(String size) {
            this.size = size;
            return this;
        }

        public ProductBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public ProductBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public ProductBuilder setDimensions(String dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public ProductBuilder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public ProductBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public ProductBuilder setWarranty(String warranty) {
            this.warranty = warranty;
            return this;
        }

        public ProductBuilder setSku(String sku) {
            this.sku = sku;
            return this;
        }

        public ProductBuilder setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public ProductBuilder setRatings(double ratings) {
            this.ratings = ratings;
            return this;
        }

        public ProductBuilder setNumReviews(int numReviews) {
            this.numReviews = numReviews;
            return this;
        }

        public ProductBuilder setImageURL(String imageURL) {
            this.imageURL = imageURL;
            return this;
        }

        public ProductBuilder setTags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

}

// Exemplo de uso
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product product = new Product.ProductBuilder(1, "T-Shirt", 29.99, 50, "Clothing")
                .setDescription("Comfortable cotton t-shirt")
                .setBrand("FashionBrand")
                .setSize("M")
                .setColor("Blue")
                .setWeight(0.2)
                .setDimensions("40cm x 30cm x 1cm")
                .setMaterial("Cotton")
                .setManufacturer("FashionBrand Inc.")
                .setWarranty("6 months")
                .setSku("TSHIRT12345")
                .setReleaseDate(LocalDate.of(2024, 4, 1))
                .setRatings(4.7)
                .setNumReviews(200)
                .setImageURL("http://example.com/tshirt.jpg")
                .setTags(Arrays.asList("clothing", "t-shirt", "fashion"))
                .build();

        System.out.println(product);
    }
}


```

Observe: Atualmente há algumas ferramentas, por exemplo, o Lombok para a linguagem Java, que permitem criar um Builder. No caso do Lombok basta usar a anotação @Builder na classe Product. 

## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.

## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização |
| :------: | :---: | :-----: | :----: | :----: |
| 1.0    | Inicio da estrutura do documento. | [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan) | [Mateus Orlando](https://github.com/MateusPy) | 23/07/2024 |
| 2.0    | Adição do Diagrama. | [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan) | [Mateus Orlando](https://github.com/MateusPy) | 24/07/2024 |
| 3.0    | Adiçãod o código. | [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan) | [Mateus Orlando](https://github.com/MateusPy) | 24/07/2024 |
