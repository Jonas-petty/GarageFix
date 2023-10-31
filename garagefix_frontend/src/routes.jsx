import { Routes, Route } from "react-router-dom";

// import Home from "./pages/Home"
import Layout from "./pages/Layout";
import Home from "./pages/Home";


export default function MainRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Home />}/>
      </Route>
    </Routes>
  )
}