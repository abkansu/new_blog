import './App.css';
import Button from './components/button/Button';
function App() {
  const onClick = (e) => {
    console.log(e);
  }
  return (
    <div className="App">
      <Button label="Positive" onClick={onClick}/>
      <Button label="Negative" disabled={true} onClick={onClick}/>
    </div>
  );
}

export default App;
