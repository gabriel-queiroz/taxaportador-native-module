import React, { useState } from 'react';

import { Container, Title } from 'react-native';
import { TextField } from 'react-native-material-textfield';

const Form = () => (
  <Container>
    <Title>Pagamentos</Title>
    <TextField label="Phone number" />
  </Container>
);

export default Form;
