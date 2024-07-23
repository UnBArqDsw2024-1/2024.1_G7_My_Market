# Facade - GoF Estrutural

## 1. Introdução

O Facade(Fachada) é um padrão de projeto estrutural que permite fornecer uma interface unificada para um conjunto de interfaces em um subsistema. O uso do Facade garante uma interface de comunicação entre sistemas de forma clara e segura.

## 2. Objetivo

Considerando o projeto My Market, para realizar uma compra precisamos utilizar vários serviços, conferir o estoque, pagamento, transporte. Dessa forma, podemos utilizar o padrão de Facade para criar uma interface de forma que o cliente só se comunique com a interface e que cada sistema só se comunique com a interface. 


## 3. Implementação


### 3.1. Diagrama UML


Modelagem a seguir foi criada utilizando a ferramenta online [Lucidchart](https://www.lucidchart.com/pages/) pelos alunos [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan).

![facade](https://github.com/user-attachments/assets/d3f6fe6a-e129-4f3d-9115-08bde8899d37)


<h6 align = "center">Figura 01: Diagrama de Classes utilizando o padrão estrutural Facade. Fonte: Mateus Orlando, Pedro Lucas e Thiago Vivan.</h6>

### 3.2. Código

O código em java a seguir foi desenvolvido pelos alunos [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan).

```java

public class MyMarketApp {

	public static void main(String[] args) {

		PedidoFacade facade = new InsFacade();
		CarrinhoController controller = new CarrinhoController(facade);
		controller.selecionarProduto(1);
		boolean resultado = controller.isPedidoRealizado();
		System.out.println("Pedido concluído? " + resultado); 

	}
}


public interface PedidoFacade {
	
	boolean criarPedido(int idProduto);

}


public class InsFacade implements PedidoFacade {

	public boolean criarPedido(int idProduto) {
		
		boolean pedidoRealizado = false;
		
		Produto produto = new Produto();
		produto.id = idProduto;
		
		if (EstoqueService.isDisponivel(produto)) {
			System.out.println("Produto com ID " + produto.id + " está disponível!");
			boolean pagtoConfirmado = PagamentoService.realizarPagamento();
			if (pagtoConfirmado) {
				System.out.println("Pagamento confirmado...");
				TransportadorService.entregarProduto(produto);
				System.out.println("Produto despachado...");
				pedidoRealizado = true;
			}
		}
		return pedidoRealizado;
	}
}


public class CarrinhoController {

	private PedidoFacade facade;
	private boolean pedidoRealizado = false;
	
	public CarrinhoController(PedidoFacade facade) {
		this.facade = facade;
	}
	
	public void selecionarProduto(int idProduto) {
		pedidoRealizado = facade.criarPedido(idProduto);
	}


	public boolean isPedidoRealizado() {
		return pedidoRealizado;
	}
}


public class EstoqueService {
	
	public static boolean isDisponivel(Produto product) {
		/* Verifica no banco de dados a disponibilidade do produto */
		return true;
	}
}


public class PagamentoService {

	public static boolean realizarPagamento() {
		/* Conecta com o serviço de pagamento selecionado. */
		return true;
	}
}


public class TransportadorService {
	
	public static void entregarProduto(Produto product) {
		/* Conecta ao serviço do transportador para entregar o produto */
	}
}


```



## Referências

> **Arquitetura e Desenho de Software - Aula GoFs Comportamentais**. Material de apoio em slides. Milene Serrano.

> **Padrão de Projeto Facade em Java**. 
[material devMedia](http://www.devmedia.com.br/padrao-de-projeto-facade-em-java/26476)

## Versionamento

| Versão | Alteração |  Responsável  | Revisor | Data de realização | Data de revisão |
| :------: | :---: | :-----: | :----: | :----: | :-----: |
| 1.0    | Inicio da estrutura do documento. | [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan) | - | 23/07/2024 | x |
| 2.0    | Adição do código e Diagrama | [Mateus Orlando](https://github.com/MateusPy), [Pedro Lucas](https://github.com/AlefMemTav) e [Thiago Vivan](https://github.com/thiago-vivan) | - | 23/07/2024 | x |
