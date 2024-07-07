import { Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import FrmUsuarios from "./pages/FrmUsuarios";
import FrmAutoria from "./pages/FrmAutoria";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/usuarios" element={<FrmUsuarios />} />
      <Route path="/autoria" element={<FrmAutoria />} />
    </Routes>
  );
}

export default App;
