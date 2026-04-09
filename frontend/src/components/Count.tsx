import { useState } from "react";
import Button from "@mui/material/Button";

export default function Count() {
    const [count, setCount] = useState(0);

    function increaseCount() {
        setCount(count + 1);
    }

    function resetCount() {
        setCount(0);
    }

    return (
        <>
            <Button onClick={increaseCount}>
                Click me! - Current count: {count}
            </Button>
            <Button onClick={resetCount}>
                Reset
            </Button>
        </>
    )
}