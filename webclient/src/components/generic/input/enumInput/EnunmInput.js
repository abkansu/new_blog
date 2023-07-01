import React, { useState } from "react";
import "./EnumInput.css";
import { CgFormatRight } from "react-icons/cg";

const EnumInput = (props) => {
    const { theme } = props;
    const [ isSelected, setIsSelected ] = useState(false);

    const onFocus = (e) => {
        setIsSelected(!isSelected);
        console.log(isSelected);
    }

    return (
        <div className="EnumBox">
            <input className={`EnumInput-${theme}`} type="text" required onFocus={onFocus}/> 
            <span className={`EnumIcon-${theme}`}><CgFormatRight /></span>
        </div>
    );
}

export default EnumInput;
