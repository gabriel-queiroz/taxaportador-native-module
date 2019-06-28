import React from 'react';
import '~/config/ReactotronConfig';
import Routes from '~/routes';
import { DeviceEventEmitter } from 'react-native';

const App = () => <Routes />;

export default App;

const onPayment = (event) => {
  console.tron.log(event);
};

DeviceEventEmitter.addListener("onPayment", onPayment);
