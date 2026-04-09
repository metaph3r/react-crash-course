import { useState } from "react";
import Note from "./Note";

export default function Notes() {
    const [note, setNote] = useState<string>("");
    const [notes, setNotes] = useState<string[]>([]);

    function handleAddNote() {
        setNotes(notes.concat(note));
        setNote("");
    }

    function handleResetNotes() {
        setNote("");
        setNotes([]);
    }

    return (
        <>
            <ul>
                {notes.map(note => (<Note note={note} />))}
            </ul>
            <input name="note" value={note} onChange={e => setNote(e.target.value)} />
            <button onClick={handleAddNote}>Add note</button>
            <button onClick={handleResetNotes}>Reset notes</button>
        </>);
}