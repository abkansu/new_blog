import React, { useState } from "react";
import "./DateInput.css";


const DateInput = (props) => {
    const { theme, placeholder } = props;
    const [ day, setDay ] = useState();
    const [ month, setmonth ] = useState();
    const [ year, setYear ] = useState();
    // TODO : Date Formatting
    return (
        <div className="DateBox">
            <input className={`DateInput-${theme}`} type="text" required placeholder="GG-AA-YYYY"/>
            <label className={`DateLabel-${theme}`}>{placeholder}</label>
        </div>
    );
}

export default DateInput;