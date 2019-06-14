import React from 'react';

import ToastExample from '~/libs/Toast';
import { Container } from './styles';
import Form from '~/components/Form';
import Payment from '~/libs/Payment';

const Main = () => {
  const handleClick = (value, transationId) => {
    Payment.startPayment(value, transationId, false);
  };

  return (
    <Container>
      <Form handleFormSubmit={handleClick} />
    </Container>
  );
};

export default Main;
