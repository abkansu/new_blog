import React from "react";
import "./TextInput.css"

const TextInput = (props) => {
    const { theme, placeholder } = props;
    return ( 
        <div className="TextBox">
            <input className={`TextInput-${theme}`} type="text" required/>
            <label className={`TextLabel-${theme}`}>{placeholder}</label>
        </div>
    );
}
export default TextInput;

/*
const TextInput = (props) => {
    const { theme, placeholder } = props;

    return (
        <div>
            <input className={`TextInput-${theme}`} type="text" placeholder={`${placeholder}`}/>
        </div>
    );
}



*/

