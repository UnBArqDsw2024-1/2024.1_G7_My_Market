import React, { useContext } from 'react';
import { LojaContext, LojaProvider } from './LojaContext';
import Product from './components/Product/Product';
import DiscountA from './visitors/DiscountA';
import DiscountB from './visitors/DiscountB';
import { ChakraProvider, Button, Box, Grid, GridItem } from '@chakra-ui/react';
import PageHeader from "./components/PageHeader/index";
import { theme } from "./styles/theme"

const App = () => {
    const { produtos, adicionarProduto } = useContext(LojaContext);

    const aplicarDesconto = (produto) => {
        const discountA = new DiscountA();
        const discountB = new DiscountB();
        discountA.visitarProduto(produto);
        discountB.visitarProduto(produto);
    };

    return (
        <ChakraProvider theme={theme}>
            <PageHeader title="MyMarket"/>
            <Button onClick={() => adicionarProduto({ nome: 'Camisa', preco: 100 })}>Adicionar Camisa</Button>
            <Button onClick={() => adicionarProduto({ nome: 'Casaco', preco: 200 })}>Adicionar Casaco</Button>

            <Grid templateColumns="repeat(5, 1fr)" gap={4}>
                
                    {produtos.map((produto, index) => (
                        <GridItem key={index}>
                            <Product key={index} nome={produto.nome} preco={produto.preco} onApplyDiscount={() => aplicarDesconto(produto)} />
                        </GridItem>))
                    }
            </Grid>
            <Box display="flex" flexDirection="row" alignItems="center">
                
            </Box>
        </ChakraProvider>
        
    );
};

export default function WrappedApp() {
    return (
        <LojaProvider>
            <App />
        </LojaProvider>
    );
}
