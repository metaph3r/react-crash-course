import { useEffect, useState } from "react";
import { Button, ButtonGroup, Grid, Input, Paper, Stack, styled, Checkbox, List, ListItemText, ListItem, ListItemIcon, ListItemButton, IconButton } from "@mui/material";
import DeleteIcon from '@mui/icons-material/Delete';

export default function Notes() {
    const url = "http://localhost:8080/api/v1/notes";

    type Note = {
        id: string,
        note: string
    }

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
                    <List>
                        {notes.map(note => (
                            <ListItem key={note.id} secondaryAction={
                                <IconButton id={note.id} edge="end" aria-label="delete" onClick={(e) => console.log("Delete note " + e.currentTarget.id)}>
                                    <DeleteIcon />
                                </IconButton>
                            }>
                                <ListItemText>{note.note}</ListItemText>
                            </ListItem>
                        ))}
                    </List>
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