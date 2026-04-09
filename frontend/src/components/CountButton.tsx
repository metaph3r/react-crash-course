import { useState } from "react";

export default function CountButton() {
    const [count, setCount] = useState(0);

    function increaseCount() {
        setCount(count + 1);
    }

    function resetCount() {
        setCount(0);
    }

    return (
        <>
            <button className="count-button" onClick={increaseCount}>
                Click me! - Current count: {count}
            </button>
            <button className="count-button" onClick={resetCount}>
                Reset
            </button>
        </>
    )
}