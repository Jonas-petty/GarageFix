// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
// import './App.css'
// import RepairTable from './components/Table/RepairTable'
// import { useEffect, useState } from 'react'
import { BrowserRouter as Router } from 'react-router-dom'

import MainRoutes from './routes'
import { GlobalStyle } from './styles'

function App() {

  // const [data, setData] = useState([])

  return (
    <>
    <Router>
      <GlobalStyle />
      <MainRoutes />
    </Router>
    </>
  )
}

export default App
