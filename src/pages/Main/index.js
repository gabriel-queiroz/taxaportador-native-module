import React from 'react';

import ToastExample from '~/libs/Toast';
import {
  Container, Touchable, TouchableContent, TouchableText,
} from './styles';

const Main = () => {
  const handleClick = () => {
    ToastExample.show('Awsome', ToastExample.SHORT);
  };

  return (
    <Container>
      <Touchable onPress={() => handleClick()}>
        <TouchableContent>
          <TouchableText>Abrir AAAA</TouchableText>
        </TouchableContent>
      </Touchable>
    </Container>
  );
};

export default Main;
