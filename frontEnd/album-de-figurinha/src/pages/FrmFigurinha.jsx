import React from "react";
import md5 from "md5";
import { BsX } from "react-icons/bs";

function FrmFigurinha({ figurinha, onClose }) {
  const [figurinhaName, setFigurinhaName] = React.useState("");
  const [figurinhaTag, setFigurinhaTag] = React.useState("");
  const [pagina, setPagina] = React.useState("");
  const [descricao, setDescricao] = React.useState("");

  React.useEffect(() => {
    if (figurinha) {
      setFigurinhaName(figurinha.nome);
      setPagina(figurinha.pagina);
      setDescricao(figurinha.descricao);
      // Simula o preenchimento automático da tag com o hash MD5 da figurinha
      const hash = md5(figurinha.nome);
      setFigurinhaTag(hash);
    }
  }, [figurinha]);

  const handleCapaChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      // Envie a imagem para o backend
    }
  };

  return (
    <div
      style={{
        position: "absolute",
        top: "50%",
        left: "50%",
        transform: "translate(-50%, -50%)",
        width: "800px",
        background: "#fff",
        padding: "40px",
        borderRadius: "5px",
        boxShadow: "0 0 10px rgba(0, 0, 0, 0.1)",
        boxSizing: "border-box",
      }}
    >
      <h2
        style={{
          textAlign: "center",
          marginBottom: "30px",
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
        }}
      >
        Edição de Figurinha
      </h2>
      <BsX
        style={{
          position: "absolute",
          top: "10px",
          right: "10px",
          cursor: "pointer",
          fontSize: "24px",
        }}
        onClick={onClose}
      />
      <table style={{ width: "100%", marginBottom: "20px" }}>
        <tbody>
          <tr>
            <td style={{ padding: "10px" }}>
              <label htmlFor="figurinhaName">Nome:</label>
              <input
                type="text"
                id="figurinhaName"
                value={figurinhaName}
                onChange={(e) => setFigurinhaName(e.target.value)}
                style={{
                  width: "100%",
                  padding: "8px",
                  fontSize: "16px",
                  border: "1px solid #ccc",
                  borderRadius: "4px",
                  boxSizing: "border-box",
                  marginBottom: "10px",
                }}
                readOnly={!figurinha}
              />
            </td>
            <td style={{ padding: "10px" }}>
              <label htmlFor="pagina">Página:</label>
              <input
                type="text"
                id="pagina"
                value={pagina}
                onChange={(e) => setPagina(e.target.value)}
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
            </td>
            <td style={{ padding: "10px" }}>
              <label htmlFor="capa">Capa:</label>
              <input
                type="file"
                id="capa"
                accept="image/*"
                onChange={handleCapaChange}
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
            </td>
          </tr>
          <tr>
            <td style={{ padding: "10px" }}>
              <label htmlFor="figurinhaTag">Tag (MD5):</label>
              <input
                type="text"
                id="figurinhaTag"
                value={figurinhaTag}
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
            </td>
            <td style={{ padding: "10px" }}>
              <label htmlFor="descricao">Descrição:</label>
              <textarea
                id="descricao"
                value={descricao}
                onChange={(e) => setDescricao(e.target.value)}
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
            </td>
            <td style={{ padding: "10px", textAlign: "center" }}>
              {figurinha && figurinha.imagem && (
                <div
                  style={{
                    border: "2px solid #007bff",
                    borderRadius: "8px",
                    padding: "5px",
                    width: "200px",
                    height: "200px",
                    overflow: "hidden",
                    margin: "auto",
                  }}
                >
                  <img
                    src={figurinha.imagem}
                    alt="Preview"
                    style={{
                      width: "100%",
                      height: "100%",
                      objectFit: "cover",
                    }}
                  />
                </div>
              )}
            </td>
          </tr>
        </tbody>
      </table>
      {/* Botões de ação */}
      <div style={{ display: "flex", justifyContent: "center" }}>
        <button
          style={{
            marginRight: "10px",
            padding: "8px 20px",
            fontSize: "16px",
            backgroundColor: "#007bff",
            color: "#fff",
            border: "none",
            borderRadius: "4px",
            cursor: "pointer",
          }}
          onClick={onClose}
        >
          Fechar
        </button>
        {/* Adicione aqui a lógica para salvar ou atualizar a figurinha */}
      </div>
    </div>
  );
}

export default FrmFigurinha;
