import React from 'react';
import TamanhoPequeno from '../Tamanho/TamanhoPequeno';
import TamanhoGrande from '../Tamanho/TamanhoGrande';

const Casaco = ({ tamanho }) => {
    const tamanhoEscolhido = tamanho === 'pequeno' ? new TamanhoPequeno() : new TamanhoGrande();
    tamanhoEscolhido.aplicarTamanho();
    
    return <div>Casaco com tamanho {tamanho}</div>;
};

export default Casaco;
