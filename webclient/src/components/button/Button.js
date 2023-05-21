import React from "react";
import "./Button.css";

const Button = (props) => {
    const { label, style, disabled, onClick } = props;

    return (
        <div className={disabled ? `Button ${label} Disabled` : `Button ${label}`}
            style={style} 
            onClick={onClick}>
            label
        </div>
    );
}

export default Button;