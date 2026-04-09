import HelloWorld from './components/HelloWorld'
import Count from './components/Count'
import Notes from './components/notes/Notes'
import { Container } from '@mui/material'

function App() {
  return (
    <Container maxWidth="sm">
      <HelloWorld />
      <Count />
      <Notes />
    </Container>
  )
}

export default App
