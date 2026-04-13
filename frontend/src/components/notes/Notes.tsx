import { useEffect, useState } from "react";
import { Button, ButtonGroup, Grid, Input, Paper, Stack, styled } from "@mui/material";

export default function Notes() {
    const url = "http://localhost:8080/api/v1/notes";

    type Note = {
        id: string,
        note: string
    }

    const Item = styled(Paper)(({ theme }) => ({
        backgroundColor: '#fff',
        ...theme.typography.body2,
        padding: theme.spacing(1),
        textAlign: 'center',
        color: (theme.vars ?? theme).palette.text.secondary,
        ...theme.applyStyles('dark', {
            backgroundColor: '#1A2027',
        }),
    }));

    const [note, setNote] = useState<Note>({ id: "", note: "" });
    const [notes, setNotes] = useState<Note[]>([]);

    useEffect(() => {
        fetch(url)
            .then(response => response.json())
            .then(data => setNotes(data));
    }, [setNotes])

    function addNote(note: string) {
        fetch(url, { method: "POST" })

        setNotes(notes.concat({ id: "", note: note }));
        setNote({ id: "", note: "" });
    }

    return (
        <>
            <Grid container spacing={2} sx={{ justifyContent: "center" }}>
                <Grid size={12}>
                    <Stack spacing={1}>
                        {notes.map(note => (<Item key={note.id} id={note.id}>{note.note}</Item>))}
                    </Stack>
                </Grid>
                <Grid size={12}>
                    <Input name="note" placeholder="Note" fullWidth={true} value={note.note} onChange={(e) => setNote({ id: e.target.id, note: e.target.value })} onKeyUp={(e) => {
                        if (e.key == "Enter") addNote(note.note)
                    }} />
                </Grid>
                <Grid>
                    <ButtonGroup>
                        <Button onClick={() => addNote(note.note)}>Add note</Button>
                        <Button onClick={() => setNotes([])}>Reset notes</Button>
                    </ButtonGroup>
                </Grid>
            </Grid>
        </>);
}