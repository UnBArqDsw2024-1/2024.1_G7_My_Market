import React, { createContext, useState } from 'react';

const LojaContext = createContext();

const LojaProvider = ({ children }) => {
    const [produtos, setProdutos] = useState([]);
    const [descontos, setDescontos] = useState({});

    const adicionarProduto = (produto) => {
        setProdutos([...produtos, produto]);
        // Notificar observadores (clientes)
    };

    const adicionarDesconto = (produto, desconto) => {
        setDescontos({ ...descontos, [produto]: desconto });
        // Notificar observadores (clientes)
    };

    return (
        <LojaContext.Provider value={{ produtos, descontos, adicionarProduto, adicionarDesconto }}>
            {children}
        </LojaContext.Provider>
    );
};

export { LojaContext, LojaProvider };

