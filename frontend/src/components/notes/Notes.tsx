import { useState } from "react";
import Note from "./Note";
import { Button, ButtonGroup, Grid, Input, Stack } from "@mui/material";

export default function Notes() {
    const [note, setNote] = useState<string>("");
    const [notes, setNotes] = useState<string[]>([]);

    function addNote(note: string) {
        setNotes(notes.concat(note));
        setNote("");
    }

    return (
        <>
            <Grid container spacing={2} sx={{ justifyContent: "center" }}>
                <Grid size={12}>
                    <Stack spacing={1}>
                        {notes.map(note => (<Note note={note} />))}
                    </Stack>
                </Grid>
                <Grid size={12}>
                    <Input name="note" placeholder="Note" fullWidth={true} value={note} onChange={(e) => setNote(e.target.value)} onKeyUp={(e) => {
                        if (e.key == "Enter") addNote(note)
                    }} />
                </Grid>
                <Grid>
                    <ButtonGroup>
                        <Button onClick={() => addNote(note)}>Add note</Button>
                        <Button onClick={() => setNotes([])}>Reset notes</Button>
                    </ButtonGroup>
                </Grid>
            </Grid>
        </>);
}