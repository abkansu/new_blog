import React from "react";
import "./Button.css";

const ButtonSmall = (props) => {
    const { label, type, style, disabled, onClick, theme } = props;
    return (
        <button className={`Button-Small ${type}-${theme}`}
            style={style} 
            onClick={onClick}
            disabled={disabled}>
            {label}
        </button>
    );
}

export default ButtonSmall;