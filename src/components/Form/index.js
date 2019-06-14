import React, { useState, Component } from 'react';

import {
  Container,
  Title,
  Touchable,
  TouchableContent,
  TouchableText,
  Input,
  InputMask,
} from './styles';
import { FormatNumbers } from '~/helpers/formatNumber';

const Form = ({ handleFormSubmit }) => {
  const [idCompra, setIdCompra] = useState('');
  const [value, setValue] = useState(0);
  const [inputMoney, setInputMoney] = useState(null);
  return (
    <Container>
      <Title>Pagamentos</Title>
      <Input placeholder="Id compra" value={idCompra} onChangeText={text => setIdCompra(text)} />
      <InputMask
        type="money"
        ref={ref => setInputMoney(ref)}
        options={{
          precision: 2,
          separator: ',',
          delimiter: '.',
          unit: 'R$ ',
          suffixUnit: '',
        }}
        value={value}
        onChangeText={text => setValue(text)}
      />
      <Touchable onPress={() => handleFormSubmit(inputMoney.getRawValue(), idCompra)}>
        <TouchableContent>
          <TouchableText>Pagar</TouchableText>
        </TouchableContent>
      </Touchable>
    </Container>
  );
};

export default Form;
