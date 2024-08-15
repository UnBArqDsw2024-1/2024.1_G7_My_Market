import React from 'react';
import { Button, Box } from '@chakra-ui/react';

const Product = ({ nome, preco, onApplyDiscount }) => (
    <>
        <Box mt="10px" mr="20px" ml="10px">
            <h2>{nome}</h2>
            <p>Preço: R${preco}</p>
            <Button onClick={onApplyDiscount}>Aplicar Desconto</Button>
        </Box>
    </>
);

export default Product;
