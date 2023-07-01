import { useState } from 'react';
import './App.css';
import Button from './components/generic/button/Button';
import ButtonBig from './components/generic/button/ButtonBig';
import { ThemeContext } from './context/Context';
import ButtonSmall from './components/generic/button/ButtonSmall';
import TopBar from './components/specific/topBar/TopBar';
import TextInput from './components/generic/input/textInput/TextInput';
import DateInput from './components/generic/input/dateInput/DateInput';
import EnumInput from './components/generic/input/enumInput/EnunmInput';



function App() {
  const [ theme, setTheme ] = useState("Dark");
  const switchTheme = (e) => {
    if (theme == "Dark") setTheme("Light")
     else setTheme("Dark")
  }
  return (
    <ThemeContext.Provider value={theme}>
      <TopBar theme={theme} onClickIcon={switchTheme}/>
      <div className={`App-${theme}`}>
        <div>
        <TextInput theme={theme} placeholder={"Username"}/>
        </div>
        <div style={{marginLeft: "25%", marginTop:"25%"}}>
        <EnumInput theme={theme} placeholder={"Date"}/>
        </div>
      </div>
      
    </ThemeContext.Provider>
  );
}

export default App;
