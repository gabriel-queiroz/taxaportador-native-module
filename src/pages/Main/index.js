import React from 'react';

import ToastExample from '~/libs/Toast';
import { Container } from './styles';
import Form from '~/components/Form';

const Main = () => {
  const handleClick = () => {
    ToastExample.show('Awsome', ToastExample.SHORT);
  };

  return (
    <Container>
      <Form handleFormSubmit={handleClick} />
    </Container>
  );
};

export default Main;
