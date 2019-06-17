import React, { useState, Component } from 'react';

import {
  Container,
  Content,
  Title,
  Touchable,
  TouchableContent,
  TouchableText,
  Input,
  InputMask,
} from './styles';
import Payment from '~/libs/Payment';

const Form = ({ handleFormSubmit }) => {
  const [idCompra, setIdCompra] = useState('');
  const [value, setValue] = useState(0);
  const [inputMoney, setInputMoney] = useState(0);

  const handleForm = async () => {
    if (!!value && !!idCompra) {
      const purchaseValue = inputMoney.getRawValue();
      if (purchaseValue <= 0) {
        alert('O valor da compra não pode ser 0');
      }
      try {
        const response = await Payment.startPayment(purchaseValue, idCompra, true);
        console.tron.log(response);
        if (response === undefined) {
          alert('error');
        }
        alert(response.message.toString());
        setValue(0);
        setIdCompra('');
      } catch (error) {
        // alert('Aconteceu um erro ao pagar!');
        alert(error.toString());
      }
    } else {
      alert('identificador ou valor da compra não informado!');
    }
  };

  return (
    <Container>
      <Title>Pagamentos</Title>
      <Input
        placeholder="Id compra"
        keyboardType="numeric"
        value={idCompra}
        onChangeText={text => setIdCompra(text)}
      />
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
      <Touchable onPress={handleForm}>
        <TouchableContent>
          <TouchableText>Pagar</TouchableText>
        </TouchableContent>
      </Touchable>
    </Container>
  );
};

export default Form;
