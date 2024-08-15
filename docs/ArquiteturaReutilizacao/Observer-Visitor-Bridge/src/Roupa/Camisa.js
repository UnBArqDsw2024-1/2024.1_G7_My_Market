import React from 'react';
import TamanhoPequeno from '../Tamanho/TamanhoPequeno';
import TamanhoGrande from '../Tamanho/TamanhoGrande';

const Camisa = ({ tamanho }) => {
    const tamanhoEscolhido = tamanho === 'pequeno' ? new TamanhoPequeno() : new TamanhoGrande();
    tamanhoEscolhido.aplicarTamanho();
    
    return <div>Camisa com tamanho {tamanho}</div>;
};

export default Camisa;
