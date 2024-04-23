import { Outlet } from "react-router-dom";
import { Footer } from "./components/Footer";
import { NavBar } from "./components/NavBar";


export default function App() {
  return (
    <>
      <NavBar />
      <Outlet />
      <Footer />
    </>
  )
}