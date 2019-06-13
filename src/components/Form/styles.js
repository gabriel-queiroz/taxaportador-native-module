import styled from 'styled-components/native';
import { TextInputMask } from 'react-native-masked-text'

export const Container = styled.View`
  background: #ccc;
  justify-content: center;
  flex: 1;
  width: 90%;
  align-items: center;
`;

export const Title = styled.Text`
  font-size: 20px;
  font-weight: bold;
  color: #777777;
  margin-bottom: 30px;
`;

export const Touchable = styled.TouchableNativeFeedback``;

export const TouchableContent = styled.View`
  margin-top: 10px;
  height: 50px;
  width: 100%;
  background-color: #3641d8;
  justify-content: center;
  align-items: center;
  border-radius: 5px;
`;

export const TouchableText = styled.Text`
  font-size: 20px;
  color: #ffffff;
  font-weight: bold;
`;

export const Input = styled(TextInputMask).attrs({
  placeholderStyle: {
    fontSize: '10px',
  },
})`
  height: 50px;
  width: 100%;
  font-size: 15px;
  background-color: #ffffff;
  margin-bottom: 15px;
  color: #757575;
  border-radius: 5px;
  padding: 0px 5px;
`;
