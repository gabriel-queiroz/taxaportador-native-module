import { AppRegistry } from 'react-native';
import App from './src';
import { name as appName } from './app.json';
import afterPayment from './src/tasks/afterPayment';

AppRegistry.registerComponent(appName, () => App);

AppRegistry.registerHeadlessTask('AfterPayment', () => afterPayment());
