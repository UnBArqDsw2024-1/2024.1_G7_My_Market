import Visitor from './VIsitor1';

class DiscountA extends Visitor {
    visitarProduto(produto) {
        console.log(`Aplicando 10% de desconto em ${produto.nome}`);
        const precoComDesconto = produto.preco * 0.9;
        console.log(`Preço com desconto: R$${precoComDesconto}`);
    }
}

export default DiscountA;
