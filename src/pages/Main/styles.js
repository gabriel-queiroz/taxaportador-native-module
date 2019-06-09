import styled from 'styled-components/native';

export const Container = styled.View`
  flex: 1;
  justify-content: center;
  align-items: center;
  background-color: #ccc;
`;

export const Touchable = styled.TouchableNativeFeedback``;

export const TouchableContent = styled.View`
  width: 200px;
  height: 70px;
  background-color: #f53;
  border-radius: 20px;
  justify-content: center;
  align-items: center;
`;

export const TouchableText = styled.Text`
  font-size: 20px;
  color: #ffffff;
  flex: 1;
  justify-content: center;
  align-items: center;
`;
