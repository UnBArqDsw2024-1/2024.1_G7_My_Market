import React, { useContext } from 'react';
import { LojaContext, LojaProvider } from './LojaContext';
import Product from './Product';
import DiscountA from './visitors/DiscountA';
import DiscountB from './visitors/DiscountB';

const App = () => {
    const { produtos, adicionarProduto } = useContext(LojaContext);

    const aplicarDesconto = (produto) => {
        const discountA = new DiscountA();
        const discountB = new DiscountB();
        discountA.visitarProduto(produto);
        discountB.visitarProduto(produto);
    };

    return (
        <div>
            <h1>Loja de Roupas</h1>
            {produtos.map((produto, index) => (
                <Product key={index} nome={produto.nome} preco={produto.preco} onApplyDiscount={() => aplicarDesconto(produto)} />
            ))}
            <button onClick={() => adicionarProduto({ nome: 'Camisa', preco: 100 })}>Adicionar Camisa</button>
            <button onClick={() => adicionarProduto({ nome: 'Casaco', preco: 200 })}>Adicionar Casaco</button>
        </div>
    );
};

export default function WrappedApp() {
    return (
        <LojaProvider>
            <App />
        </LojaProvider>
    );
}
