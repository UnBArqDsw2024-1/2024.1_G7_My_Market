import React, { useEffect, useState } from 'react';
import { useLoja } from './LojaContext';

const Cliente = ({ nome, tipoNotificacao }) => {
  const { novosProdutos, descontos } = useLoja();
  const [ultimosProdutos, setUltimosProdutos] = useState([]);
  const [ultimosDescontos, setUltimosDescontos] = useState({});

  useEffect(() => {
    const novosProdutosFiltrados = novosProdutos.filter(
      (produto) => !ultimosProdutos.includes(produto)
    );
    const novosDescontosFiltrados = Object.fromEntries(
      Object.entries(descontos).filter(
        ([produto]) => !(produto in ultimosDescontos)
      )
    );

    if (novosProdutosFiltrados.length > 0 || Object.keys(novosDescontosFiltrados).length > 0) {
      console.log(`Notificação para ${nome}:`);
      if (tipoNotificacao === 'produtos' && novosProdutosFiltrados.length > 0) {
        console.log('Novos produtos adicionados: ', novosProdutosFiltrados);
      } else if (tipoNotificacao === 'tudo') {
        if (novosProdutosFiltrados.length > 0) {
          console.log('Novos produtos adicionados: ', novosProdutosFiltrados);
        }
        if (Object.keys(novosDescontosFiltrados).length > 0) {
          console.log('Descontos disponíveis: ', novosDescontosFiltrados);
        }
      }
      console.log();

      setUltimosProdutos((prev) => [...prev, ...novosProdutosFiltrados]);
      setUltimosDescontos((prev) => ({ ...prev, ...novosDescontosFiltrados }));
    }
  }, [novosProdutos, descontos, nome, tipoNotificacao, ultimosProdutos, ultimosDescontos]);

  return null;
};

export default Cliente;
