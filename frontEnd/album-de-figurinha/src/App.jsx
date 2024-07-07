import { Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import FrmUsuarios from "./pages/FrmUsuarios";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/usuarios" element={<FrmUsuarios />} />
    </Routes>
  );
}

export default App;
