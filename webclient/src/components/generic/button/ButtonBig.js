import React from "react";
import "./Button.css";

const ButtonBig = (props) => {
    const { label, type, style, disabled, onClick, theme } = props;
    return (
        <button className={`Button-Big ${type}-${theme}`}
            style={style} 
            onClick={onClick}
            disabled={disabled}>
            {label}
        </button>
    );
}

export default ButtonBig;