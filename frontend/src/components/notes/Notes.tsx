import { useEffect, useState } from "react";
import { Button, ButtonGroup, Grid, Input, List, ListItemText, ListItem, IconButton } from "@mui/material";
import DeleteIcon from '@mui/icons-material/Delete';

export default function Notes() {
    const url = "http://localhost:8080/api/v1/notes";

    type Note = {
        id: string,
        note: string
    }

    const [note, setNote] = useState<Note>({ id: "", note: "" });
    const [notes, setNotes] = useState<Note[]>([]);
    const [loadingNotes, setLoadingNotes] = useState<boolean>(false);
    const [deletingNote, setDeleting] = useState<boolean>(false);
    const [addingNote, setAdding] = useState<boolean>(false);

    useEffect(() => {
        if (deletingNote || addingNote || loadingNotes) return;

        setLoadingNotes(true);
        fetch(url)
            .then(response => response.json())
            .then(data => setNotes(data))
            .finally(() => setLoadingNotes(false));
    }, [deletingNote, addingNote, loadingNotes]);

    async function handleAddNote(note: string) {
        setAdding(true);
        console.log("adding note: " + note);
        await fetch(url, { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ note: note }) });
        console.log("added note: " + note);
        setNote({ id: "", note: "" });
        setAdding(false);
    }

    async function handleDeleteNote(id: string) {
        setDeleting(true);
        console.log("deleting note with id: " + id);
        await fetch(url + "/" + id, { method: "DELETE" });
        console.log("deleted note with id: " + id);
        setDeleting(false);
    }

    return (
        <>
            <Grid container spacing={2} sx={{ justifyContent: "center" }}>
                <Grid size={12}>
                    <List>
                        {notes.map(note => (
                            <ListItem key={note.id} secondaryAction={
                                <IconButton id={note.id} edge="end" aria-label="delete" onClick={(e) => handleDeleteNote(e.currentTarget.id)}>
                                    <DeleteIcon />
                                </IconButton>
                            }>
                                <ListItemText>{note.note}</ListItemText>
                            </ListItem>
                        ))}
                    </List>
                    <Input name="note" placeholder="Note" fullWidth={true} value={note.note} onChange={(e) => setNote({ id: e.target.id, note: e.target.value })} onKeyUp={(e) => {
                        if (e.key == "Enter") handleAddNote(note.note)
                    }} />
                </Grid>
                <Grid>
                    <ButtonGroup>
                        <Button onClick={() => handleAddNote(note.note)}>Add note</Button>
                        <Button onClick={() => setNotes([])}>Reset notes</Button>
                    </ButtonGroup>
                </Grid>
            </Grid>
        </>);
}