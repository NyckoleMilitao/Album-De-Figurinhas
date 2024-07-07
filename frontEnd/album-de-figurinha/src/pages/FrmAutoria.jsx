import { useEffect, useState } from "react";
import md5 from "md5";

function FrmFigurinha({ isCollector, figurinha, onClose }) {
  const [figurinhaData, setFigurinhaData] = useState({});

  useEffect(() => {
    if (figurinha) {
      setFigurinhaData(figurinha);
    }
  }, [figurinha]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFigurinhaData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Lógica para salvar as alterações da figurinha aqui
    onClose(); // Fechar o formulário após salvar
  };

  return (
    <div
      style={{
        position: "absolute",
        top: "50%",
        left: "50%",
        transform: "translate(-50%, -50%)",
        width: "400px",
        background: "#fff",
        padding: "20px",
        borderRadius: "5px",
        boxShadow: "0 0 10px rgba(0, 0, 0, 0.1)",
        boxSizing: "border-box",
      }}
    >
      <h2
        style={{
          textAlign: "center",
          marginBottom: "20px",
        }}
      >
        Edição de Figurinha
      </h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: "10px" }}>
          <label htmlFor="nome" style={{ display: "block" }}>
            Nome da Figurinha:
          </label>
          <input
            type="text"
            id="nome"
            name="nome"
            value={figurinhaData.nome || ""}
            onChange={handleChange}
            style={{
              width: "100%",
              padding: "8px",
              fontSize: "16px",
              border: "1px solid #ccc",
              borderRadius: "4px",
              boxSizing: "border-box",
              marginBottom: "10px",
            }}
          />
        </div>
        <div style={{ marginBottom: "10px" }}>
          <label htmlFor="hash" style={{ display: "block" }}>
            Hash MD5:
          </label>
          <input
            type="text"
            id="hash"
            name="hash"
            value={md5(figurinhaData.nome || "")}
            readOnly
            style={{
              width: "100%",
              padding: "8px",
              fontSize: "16px",
              border: "1px solid #ccc",
              borderRadius: "4px",
              boxSizing: "border-box",
              marginBottom: "10px",
            }}
          />
        </div>
        <button
          type="submit"
          style={{
            width: "100%",
            padding: "10px",
            fontSize: "16px",
            backgroundColor: "#007bff",
            color: "#fff",
            border: "none",
            borderRadius: "4px",
            cursor: "pointer",
          }}
        >
          Salvar
        </button>
      </form>
      <button
        onClick={onClose}
        style={{
          marginTop: "10px",
          width: "100%",
          padding: "10px",
          fontSize: "16px",
          backgroundColor: "#dc3545",
          color: "#fff",
          border: "none",
          borderRadius: "4px",
          cursor: "pointer",
        }}
      >
        Cancelar
      </button>
    </div>
  );
}

export default FrmFigurinha;
