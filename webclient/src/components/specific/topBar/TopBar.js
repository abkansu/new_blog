import React, { useContext } from "react";
import "./TopBar.css";
import { FaLightbulb, FaRegLightbulb } from "react-icons/fa";

const TopBar = (props) => {
    const { theme, onClickIcon } = props;
    return(
        <div className={`TopBar-${theme}`}>
            <div className={`Brand-${theme}`}>Hacettepe University Enviromental Engineering</div>
            <div className={`Icon-${theme}`}><FaRegLightbulb onClick={onClickIcon}/></div>
            <div className={`Page-${theme}`}>Login</div>
            <div className={`Page-${theme}`}>Home</div>
            <div className={`Page-${theme}`}>Resources</div>
            <div className={`Page-${theme}`}>Staff</div>
            <div className={`Page-${theme}`}>About</div>
            
        </div>
    );
}

export default TopBar;