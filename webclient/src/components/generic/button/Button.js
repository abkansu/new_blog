import React from "react";
import "./Button.css";

const Button = (props) => {
    const { children, type, style, disabled, onClick, theme } = props;
    return (
        <button className={`Button ${type}-${theme}`}
            style={style} 
            onClick={onClick}
            disabled={disabled}>
            {children}
        </button>
    );
}

export default Button;