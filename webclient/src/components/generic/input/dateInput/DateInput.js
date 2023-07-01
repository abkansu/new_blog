import React, { useState } from "react";
import "./DateInput.css";
import { formatDate } from "../../validations/Validations";


const DateInput = (props) => {
    const { theme, placeholder } = props;
    return (
        <div className="DateBox">
            <input className={`DateInput-${theme}`} type="text" required placeholder="GG-AA-YYYY" onChange={formatDate}/>
            <label className={`DateLabel-${theme}`}>{placeholder}</label>
        </div>
    );
}

export default DateInput;