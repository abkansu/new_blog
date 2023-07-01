import { dates } from "../constants/Constants";

const formatDate = (e) => {
    const value = e.target.value;
    if (!value) return value;
    const date = value.replace(/[^\d]/g, '');
    const valueLength = date.length;
    const day = Number(date.slice(0, 2));
    const month = Number(date.slice(2, 4));
    const year = Number(date.slice(4, 8));
    if (valueLength < 3) {
        if (valueLength === 2 && day === 0) return e.target.value = ``;
        if (valueLength === 2 && day > 31) return e.target.value = `31`;
        return e.target.value = date;
    }
    if (valueLength < 5) {
        if (valueLength === 4 && month === 0) return e.target.value = ``;
        if (valueLength === 4 && month > 12) return e.target.value = `${date.slice(0, 2)}-12`;
        if (valueLength === 4 && month === 2 && day === dates[month - 1]?.maxDay + 1) return e.target.value = `${date.slice(0, 2)}-${date.slice(2)}`;
        if (valueLength === 4 && day > dates[month - 1]?.maxDay) return e.target.value = `${dates[month - 1]?.maxDay}-${date.slice(2)}`;
        return e.target.value = `${date.slice(0, 2)}-${date.slice(2)}`;
    }
    if (valueLength === 8 && month === 2 && year % 4 !== 0 && day === 29) return e.target.value = `28-${date.slice(2, 4)}-${date.slice(4, 8)}`;
    return e.target.value = `${date.slice(0, 2)}-${date.slice(2, 4)}-${date.slice(4, 8)}`; 
}

export {formatDate};