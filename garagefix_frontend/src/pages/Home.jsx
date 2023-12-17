
import { useEffect, useState } from "react"

export default function Home() {

  const [data, setData] = useState([])

  useEffect(() => {
    fetch("http://localhost:8080/client")
    .then(response => response.json())
    .then((data) => {
      setData(data.content)
    })
  }, [])

  let clientElements = data.map((client, index) => {
    const createdAt = new Date(client.createdAt)
    return (
      <tr key={index}>
        <th scope="row">{index + 1}</th>
        <th>{client.name}</th>
        <th>{client.phoneNumber}</th>
        <th>{createdAt.toLocaleString()}</th>
        <th><button>opa</button></th>
      </tr>
    )
  })

  return (
    <>
      <table className="table table-sm table-hover">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome</th>
            <th scope="col">Telefone</th>
            <th scope="col">Cadastrado em</th>
            <th scope="col">Ação</th>
          </tr>
        </thead>
        <tbody>
          {clientElements}
        </tbody>
      </table>
    </>
  )
}