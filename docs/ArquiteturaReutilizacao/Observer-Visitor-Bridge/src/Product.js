import React from 'react';

const Product = ({ nome, preco, onApplyDiscount }) => (
    <div>
        <h2>{nome}</h2>
        <p>Preço: R${preco}</p>
        <button onClick={onApplyDiscount}>Aplicar Desconto</button>
    </div>
);

export default Product;
