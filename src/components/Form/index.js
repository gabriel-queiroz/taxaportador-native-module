import React, { useState } from 'react';
import {
  Container, Title, Touchable, TouchableContent, TouchableText, Input,
} from './styles';

const Form = ({ handleFormSubmit }) => {
  const [idCompra, setIdCompra] = useState('');
  const [value, setValue] = useState('');
  return (
    <Container>
      <Title>Pagamentos</Title>
      <Input
        placeholder="Id compra"
        value={idCompra}
        onChangeText={idCompra => setIdCompra(idCompra)}
      />
      <Input
        type="numeric"
        placeholder="Valor a pagar"
        value={value}
        onChangeText={value => setValue(value)}
      />
      <Touchable onPress={handleFormSubmit}>
        <TouchableContent>
          <TouchableText>Pagar</TouchableText>
        </TouchableContent>
      </Touchable>
    </Container>
  );
};

export default Form;
