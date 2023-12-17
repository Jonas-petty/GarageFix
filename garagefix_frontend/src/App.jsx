// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
// import './App.css'
// import RepairTable from './components/Table/RepairTable'
// import { useEffect, useState } from 'react'
import { BrowserRouter as Router } from 'react-router-dom'
import { GlobalStyle } from './styles'
import Home from './pages/Home'

function App() {

  return (
    <>
    <Router>
      <GlobalStyle />
      <Home />
    </Router>
    </>
  )
}

export default App
