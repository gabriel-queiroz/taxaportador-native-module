import styled from 'styled-components/native';
import { getStatusBarHeight } from 'react-native-status-bar-height';

export const Container = styled.View`
  height: ${70};
  padding-top: ${getStatusBarHeight()};
  background-color: #ffffff;
  align-items: center;
  flex-direction: row;
`;

export const Title = styled.Text`
  color: #757575;
  font-size: 25px;
  font-weight: bold;
`;

export const Left = styled.View``;

export const Right = styled.View``;
