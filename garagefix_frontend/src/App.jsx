// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import { useEffect, useState } from 'react'
import './App.css'

function App() {

  const [clients, setClients] = useState([])

  useEffect(() => {
    fetch("http://localhost:8080/client")
    .then(response => {return response.json()})
    .then(data => {setClients(data.content)})
    
  }, [])

  const clientElements = clients.map((client) => {
    console.log(client)

    return <div key={client.id}>
      <p>Nome: {client.nome}</p>
      <p>Telefone: {client.phoneNumber}</p>
    </div>
  })

  return (
    <>
      <div>
        {clientElements}
      </div>
    
    </>
  )
}

export default App
